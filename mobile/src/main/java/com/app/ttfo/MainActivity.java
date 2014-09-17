package com.app.ttfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.button_walkWithMe)
    Button walkWithMeBtn;

    @InjectView(R.id.button_meeting)
    Button meetingBtn;

    private View.OnClickListener onWalkWithMeClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent walkIntent = new Intent(getApplicationContext(), WalkWithMeActivity.class);
            startActivity(walkIntent);
        }
    };
    private View.OnClickListener onMeetingClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent groupIntent = new Intent(getApplicationContext(), GroupActivity.class);
            startActivity(groupIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        walkWithMeBtn.setOnClickListener(onWalkWithMeClick);
        meetingBtn.setOnClickListener(onMeetingClick);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_add:
                break;
            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
