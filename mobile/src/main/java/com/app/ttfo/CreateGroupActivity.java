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
public class CreateGroupActivity extends Activity {

    @InjectView(R.id.button_invitePeople)
    Button invitePeopleBtn;

    private View.OnClickListener onInvitePeopleClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
            shareIntent.setType("text/plain");
            //shareIntent.putExtra(Intent.EXTRA_TEXT, "I've created a group. Join in via group code " + groupCode);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgroup);
        ButterKnife.inject(this);
        invitePeopleBtn.setOnClickListener(onInvitePeopleClick);
    }
}
