package com.app.ttfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.ttfo.receiver.MyAdminReceiver;
import com.michaelnovakjr.numberpicker.NumberPicker;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;

/**
 * Created by kevintanhongann on 9/18/14.
 */
public class GroupDetailsActivity extends Activity {

    @InjectView(R.id.button_startLock)
    Button startLockBtn;

    private View.OnClickListener onStartLockClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View numberPickerView = getLayoutInflater().inflate(R.layout.layout_numberpickerview, null);
            final NumberPicker numberPicker = (NumberPicker) numberPickerView.findViewById(R.id.numberpicker);
            numberPicker.setCurrent(1);
            AlertDialog dialog = new AlertDialog.Builder(GroupDetailsActivity.this)
                    .setTitle("Set Hours")
                    .setView(numberPickerView)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            EventBus.getDefault().postSticky(new Integer(numberPicker.getCurrent()));
                            startActivity(new Intent(GroupDetailsActivity.this, LockScreenActivity.class));
                        }
                    })
                    .create();
            dialog.show();
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
