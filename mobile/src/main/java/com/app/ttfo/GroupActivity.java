package com.app.ttfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class GroupActivity extends Activity {

    @InjectView(R.id.button_joinGroup)
    Button joinGroupBtn;

    @InjectView(R.id.button_createGroup)
    Button createGroupBtn;

    private View.OnClickListener onJoinGroupClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent joinGroupIntent = new Intent(getApplicationContext(), JoinGroupActivity.class);
            startActivity(joinGroupIntent);
        }
    };
    private View.OnClickListener onCreateGroupClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent createGroupIntent = new Intent(getApplicationContext(), CreateGroupActivity.class);
            startActivity(createGroupIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        ButterKnife.inject(this);
        joinGroupBtn.setOnClickListener(onJoinGroupClick);
        createGroupBtn.setOnClickListener(onCreateGroupClick);
    }
}
