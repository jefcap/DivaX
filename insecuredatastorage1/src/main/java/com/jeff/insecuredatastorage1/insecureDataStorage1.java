package com.jeff.insecuredatastorage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insecureDataStorage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_data_storage1);
    }

    public void saveCredentials(View view) {
        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor spedit = spref.edit();
        EditText usr = findViewById(R.id.ids1Usr);
        EditText pwd = findViewById(R.id.ids1Pwd);

        spedit.putString("user", usr.getText().toString());
        spedit.putString("password", pwd.getText().toString());
//        spedit.commit(); // Warning:(28, 9) Consider using `apply()` instead; `commit` writes its data to persistent storage immediately, whereas `apply` will handle it in the background
        spedit.apply();

        Toast.makeText(this,"3rd party credentials saved successfully!", Toast.LENGTH_SHORT).show();

//        NOTES for exploit:
//        To attack: https://medium.com/@kuls.droid/access-shared-preference-data-from-one-application-to-another-application-in-android-863af845de4c
//                   https://stackoverflow.com/questions/6030321/android-retrieving-shared-preferences-of-other-application
//        Context mContext = createPackageContext("com.kuls.globalsharedpreference_first", CONTEXT_IGNORE_SECURITY);
//
//        SharedPreferences firstAppSharedPrefs = mContext.getSharedPreferences("Prefs_First", Context.MODE_WORLD_READABLE);
//
//        String strName = firstAppSharedPrefs.getString("name", "");
//        String strPassword = firstAppSharedPrefs.getString("password", "");

    }
}
