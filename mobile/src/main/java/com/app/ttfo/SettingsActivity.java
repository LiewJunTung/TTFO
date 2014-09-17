package com.app.ttfo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by kevintanhongann on 9/17/14.
 */
public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
