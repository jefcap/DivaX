package com.jeff.hardcodingissue2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class hardcodingIssue2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardcoding_issue2);
    }

    public void access(View view) {
        Toast.makeText(this, "Method not ready yet. It'll use JNI call", Toast.LENGTH_SHORT).show();
    }
}
