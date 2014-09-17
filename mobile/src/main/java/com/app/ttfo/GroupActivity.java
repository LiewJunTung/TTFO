package com.app.ttfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        }
    };
    private View.OnClickListener onCreateGroupClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        joinGroupBtn.setOnClickListener(onJoinGroupClick);
        createGroupBtn.setOnClickListener(onCreateGroupClick);
    }
}
