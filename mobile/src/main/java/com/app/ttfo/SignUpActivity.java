package com.app.ttfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ttfo.api.ApiFactory;
import com.app.ttfo.api.TTFOApi;
import com.app.ttfo.callback.MemberCallback;
import com.app.ttfo.exception.MemberException;
import com.app.ttfo.response.MemberResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class SignUpActivity extends Activity {

    @InjectView(R.id.button_signUp)
    Button signUpBtn;

    @InjectView(R.id.editText_username)
    EditText etUsername;

    @InjectView(R.id.editText_password)
    EditText etPassword;

    @InjectView(R.id.editText_email)
    EditText etEmail;

    private TTFOApi ttfoApi;

    private View.OnClickListener onSignUpClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(TextUtils.isEmpty(etUsername.getText().toString())){
                etUsername.setError(getString(R.string.text_required_field));
            }else if(TextUtils.isEmpty(etPassword.getText().toString())){
                etPassword.setError(getString(R.string.text_required_field));
            }else if(TextUtils.isEmpty(etEmail.getText().toString())){
                etEmail.setError(getString(R.string.text_required_field));
            }else if(isValidEmail(etEmail.getText().toString())){
                etEmail.setError("Invalid email");
            }else{
                final ProgressDialog progressDialog = ProgressDialog.show(getApplicationContext(), "", "Signing up", false, false);
                ttfoApi.createMember(getApplicationContext(), etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString(), new MemberCallback() {
                    @Override
                    public void onFail(MemberException exception) {
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                        if(progressDialog.isShowing()){
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onSuccess(MemberResponse response) {
                        if(response.isResult()){
                            Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(mainIntent);
                        }else{
                            Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        if(progressDialog.isShowing()){
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }
    };

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.inject(this);
        ttfoApi = ApiFactory.INSTANCE.getTTFOApi();
        signUpBtn.setOnClickListener(onSignUpClick);
    }
}
