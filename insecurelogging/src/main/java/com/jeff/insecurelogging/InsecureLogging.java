package com.jeff.insecurelogging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsecureLogging extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecure_logging);
    }


    public void checkout(View view) {
        EditText cctxt = findViewById(R.id.ccText);
        try {
            // Assuming we do some HTTP requests credit card validation and processing
            //Everything seems fine and then we hit some unforeseen error
            processCC(cctxt.getText().toString());
        } catch (RuntimeException re) {
            Log.e("divax-log", "Error while processing transaction with credit card: " + cctxt.getText().toString());
            Toast.makeText(this, "An error occured. Please try again later", Toast.LENGTH_SHORT).show();
        }
    }

    private void processCC(String toString) {
        // Do some important processing and throw if there is any error
        RuntimeException e = new RuntimeException();
        throw e;
    }
}
