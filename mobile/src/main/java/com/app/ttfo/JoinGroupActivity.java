package com.app.ttfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.ttfo.api.ApiFactory;
import com.app.ttfo.api.TTFOApi;
import com.app.ttfo.callback.JoinGroupCallback;
import com.app.ttfo.exception.JoinGroupException;
import com.app.ttfo.response.JoinGroupResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class JoinGroupActivity extends Activity {


    @InjectView(R.id.button_joinGroup)
    Button joinGroupBtn;

    private TTFOApi ttfoApi;

    @InjectView(R.id.editText_groupId)
    EditText etGroupId;

    @InjectView(R.id.editText_username)
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joingroup);
        ttfoApi = ApiFactory.INSTANCE.getTTFOApi();

        ButterKnife.inject(this);
        joinGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ttfoApi.joinGroup(getApplicationContext(),etGroupId.getText().toString(), etUsername.getText().toString(), new JoinGroupCallback() {
                    @Override
                    public void onFail(JoinGroupException exception) {
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(JoinGroupResponse response) {
                        if(response.isResult()){
                            Intent groupDetailsIntent = new Intent(getApplicationContext(), GroupDetailsActivity.class);
                            startActivity(groupDetailsIntent);
                        }else{
                            Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Intent groupDetailsIntent = new Intent(getApplicationContext(), GroupDetailsActivity.class);
                startActivity(groupDetailsIntent);
            }
        });
    }
}
