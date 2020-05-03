package com.jeff.insecuredatastorage4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class insecureDataStorage4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_data_storage4);
    }

    public void saveCredentials(View view) {
        EditText usr = findViewById(R.id.ids4Usr);
        EditText pwd = findViewById(R.id.ids4Pwd);

        File sdir = Environment.getExternalStorageDirectory();  //Doesn't work in Android Q (https://developer.android.com/reference/android/os/Environment#getExternalStorageDirectory())
        Log.d("DivaX", "File path: " + sdir.getAbsolutePath());

        try {
            File uinfo = new File(sdir.getAbsolutePath() + "/.uinfo.txt");
            uinfo.setReadable(true);
            uinfo.setWritable(true);
            FileWriter fw = new FileWriter(uinfo);
            fw.write(usr.getText().toString() + ":" + pwd.getText().toString() + "\n");
            fw.close();
            Toast.makeText(this, "3rd party credentials saved successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "File error occurred. Example not working in Android Q", Toast.LENGTH_SHORT).show();
            Log.d("DivaX", "File error: " + e.getMessage());
        }
    }
}
