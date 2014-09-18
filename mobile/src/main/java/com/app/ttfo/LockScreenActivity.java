package com.app.ttfo;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ttfo.receiver.MyAdminReceiver;

import butterknife.InjectView;
import butterknife.Optional;
import de.greenrobot.event.EventBus;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class LockScreenActivity extends Activity {

    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mComponentName;
    private static final int ADMIN_INTENT = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lockscreen);
        mDevicePolicyManager = (DevicePolicyManager) getSystemService(
                Context.DEVICE_POLICY_SERVICE);
        mComponentName = new ComponentName(this, MyAdminReceiver.class);

        String description = "You need to activate device admin to continue";

        boolean isAdmin = mDevicePolicyManager.isAdminActive(mComponentName);
        if (isAdmin) {
            mDevicePolicyManager.lockNow();
        } else {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,description);
            startActivityForResult(intent, ADMIN_INTENT);
            Toast.makeText(getApplicationContext(), "Not Registered as admin", Toast.LENGTH_SHORT).show();
        }

        Integer hour = EventBus.getDefault().getStickyEvent(Integer.class);

        /*if (hour != null) {
            new CountDownTimer(hour * 60 * 60 * 1000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    Log.d("timeTillFinish", "timeTillFinish " + millisUntilFinished);

                }

                @Override
                public void onFinish() {
                    //disable the lockscreen

                }
            }.start();
        }*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADMIN_INTENT){
            if(resultCode == Activity.RESULT_OK){
                mDevicePolicyManager.lockNow();
            }else{
                Toast.makeText(getApplicationContext(), "Not Registered as admin", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
