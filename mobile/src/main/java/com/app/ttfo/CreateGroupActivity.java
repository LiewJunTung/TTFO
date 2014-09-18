package com.app.ttfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ttfo.api.ApiFactory;
import com.app.ttfo.api.TTFOApi;
import com.app.ttfo.callback.CreateGroupCallback;
import com.app.ttfo.exception.CreateGroupException;
import com.app.ttfo.response.CreateGroupResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class CreateGroupActivity extends Activity {

    @InjectView(R.id.button_invitePeople)
    Button invitePeopleBtn;

    @InjectView(R.id.textView_groupCode)
    TextView tvGroupId;


    @InjectView(R.id.button_gotoGroup)
    Button gotoGroupBtn;


    private TTFOApi ttfoApi;

    private View.OnClickListener onInvitePeopleClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "I've created a group. Join in via group code " + tvGroupId.getText().toString());
            startActivity(shareIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgroup);
        ButterKnife.inject(this);
        ttfoApi = ApiFactory.INSTANCE.getTTFOApi();
        ttfoApi.createGroup(getApplicationContext(), tvGroupId.getText().toString(), "JT123", "", new CreateGroupCallback() {
            @Override
            public void onFail(CreateGroupException exception) {
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(CreateGroupResponse response) {
                if(response.isResult()){
                    Toast.makeText(getApplicationContext(), "Group created. ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        invitePeopleBtn.setOnClickListener(onInvitePeopleClick);
        gotoGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent groupDetailsIntent = new Intent(getApplicationContext(), GroupDetailsActivity.class);
                startActivity(groupDetailsIntent);
            }
        });
    }
}
