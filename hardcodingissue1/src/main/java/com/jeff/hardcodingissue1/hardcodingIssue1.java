package com.jeff.hardcodingissue1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class hardcodingIssue1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardcoding_issue1);
    }

    public void access(View view) {
        EditText hckey = findViewById(R.id.hcKey);
        String verySecretKey = "vendorsecretkey";

        if (hckey.getText().toString().equals(verySecretKey)) {
            Toast.makeText(this, "Access granted! See you on the other side :)", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Access denied! See you in hell :D", Toast.LENGTH_SHORT).show();
        }
    }
}
