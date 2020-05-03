package com.jeff.insecuredatastorage3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class insecureDataStorage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_data_storage3);
    }

    public void saveCredentials(View view) {
        EditText usr = findViewById(R.id.ids3Usr);
        EditText pwd = findViewById(R.id.ids3Pwd);

        File ddir = new File(getApplicationInfo().dataDir);

        try {
            File uinfo = File.createTempFile("uinfo", "tmp", ddir);
            uinfo.setReadable(true);
            uinfo.setWritable(true);
            FileWriter fw = new FileWriter(uinfo);
            fw.write(usr.getText().toString() + ":" + pwd.getText().toString() + "\n");
            fw.close();
            Toast.makeText(this, "3rd party credentials saved successfully!", Toast.LENGTH_SHORT).show();
            // Now you can read the temporary file where ever the credentials are required.
        } catch (IOException e) {
            Toast.makeText(this, "File error occurred", Toast.LENGTH_SHORT).show();
            Log.d("DivaX", "File error: " + e.getMessage());
        }
    }
}
