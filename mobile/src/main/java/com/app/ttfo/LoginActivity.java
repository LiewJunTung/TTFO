package com.app.ttfo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ttfo.api.ApiFactory;
import com.app.ttfo.api.TTFOApi;
import com.app.ttfo.callback.LoginCallback;
import com.app.ttfo.exception.LoginException;
import com.app.ttfo.response.LoginResponse;

import butterknife.InjectView;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class LoginActivity extends Activity {

    @InjectView(R.id.button_login)
    Button loginBtn;

    @InjectView(R.id.editText_username)
    EditText etUsername;

    @InjectView(R.id.editText_password)
    EditText etPassword;

    private View.OnClickListener onLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TTFOApi ttfoApi = ApiFactory.INSTANCE.getTTFOApi();
            ttfoApi.login(getApplicationContext(), etUsername.getText().toString(), etPassword.getText().toString(), new LoginCallback() {
                @Override
                public void onFail(LoginException exception) {
                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(LoginResponse response) {
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword.setTypeface(Typeface.DEFAULT);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        loginBtn.setOnClickListener(onLoginClick);
    }

}
