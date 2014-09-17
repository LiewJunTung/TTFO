package com.app.ttfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.ttfo.receiver.MyAdminReceiver;

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

            View numberPickerView = getLayoutInflater().inflate(R.layout.layout_numberpickerview, null);
            AlertDialog dialog = new AlertDialog.Builder(getApplicationContext())
                    .setTitle("Set Hours")
                    .setView(numberPickerView)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            boolean isAdmin = mDevicePolicyManager.isAdminActive(mComponentName);
                            if (isAdmin) {
                                mDevicePolicyManager.lockNow();
                            }else{
                                Toast.makeText(getApplicationContext(), "Not Registered as admin", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .create();
            dialog.show();
        }
    };
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mComponentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupdetails);
        ButterKnife.inject(this);
        mDevicePolicyManager = (DevicePolicyManager)getSystemService(
                Context.DEVICE_POLICY_SERVICE);
        mComponentName = new ComponentName(this, MyAdminReceiver.class);
        startLockBtn.setOnClickListener(onStartLockClick);
    }


}
