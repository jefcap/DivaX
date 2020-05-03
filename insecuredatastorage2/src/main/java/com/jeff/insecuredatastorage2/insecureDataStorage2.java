package com.jeff.insecuredatastorage2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insecureDataStorage2 extends AppCompatActivity {

    private SQLiteDatabase mDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mDB = openOrCreateDatabase("ids2.db", MODE_PRIVATE, null);
            mDB.execSQL("CREATE TABLE IF NOT EXISTS myuser(user VARCHAR, password VARCHAR);");
        } catch (SQLException e) {
            Log.d("DivaX", "Error occurred while creating database: " + e.getMessage());
            e.printStackTrace();
        }

        setContentView(R.layout.activity_insecure_data_storage2);
    }

    public void saveCredentials(View view) {
        EditText usr = findViewById(R.id.ids2Usr);
        EditText pwd = findViewById(R.id.ids2Pwd);

        try{
            mDB.execSQL("INSERT INTO myuser VALUES ('"+ usr.getText().toString() +"', '"+ pwd.getText().toString() +"');");
            mDB.close();
            Toast.makeText(this, "3rd party credentials saved successfully!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Log.d("Divax", "Error occurred while inserting into database: " + e.getMessage());
        }
    }
}

// For Exploit:
//https://stackoverflow.com/questions/7053809/share-sqlite-database-between-2-android-apps
//Usually databases are done with content provider