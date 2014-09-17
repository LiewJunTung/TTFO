package com.app.ttfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class GroupDetailsActivity extends Activity {

    @InjectView(R.id.button_startLock)
    Button startLockBtn;

    private View.OnClickListener onStartLockClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupdetails);
        ButterKnife.inject(this);

        startLockBtn.setOnClickListener(onStartLockClick);
    }
}
