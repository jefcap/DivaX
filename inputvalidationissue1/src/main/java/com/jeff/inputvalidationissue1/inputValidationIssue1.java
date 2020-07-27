package com.jeff.inputvalidationissue1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class inputValidationIssue1 extends AppCompatActivity {

    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mDB = openOrCreateDatabase("sqli", MODE_PRIVATE, null);
            mDB.execSQL("DROP TABLE IF EXISTS sqliuser;");
            mDB.execSQL("CREATE TABLE IF NOT EXISTS sqliuser(user VARCHAR, password VARCHAR, credit_card VARCHAR);");
            mDB.execSQL("INSERT INTO sqliuser VALUES ('admin', 'passwd123', '1234567812345678');");
            mDB.execSQL("INSERT INTO sqliuser VALUES ('divax', 'p@sswordX', '1111222233334444');");
            mDB.execSQL("INSERT INTO sqliuser VALUES ('john', 'password123', '5555666677778888');");
        }
        catch (Exception e) {
            Log.d("Divax-sqli", "Error occurred while creating database for SQLI: " + e.getMessage());
        }

        setContentView(R.layout.activity_input_validation_issues1);
    }

    public void search(View view){
        EditText srctxt = findViewById(R.id.ivi1search);
        Cursor cr = null;
        try {
            cr = mDB.rawQuery("SELECT * FROM sqliuser WHERE user = '"+ srctxt.getText().toString() + "'", null);
            StringBuilder strb = new StringBuilder("");
            if ((cr != null) && (cr.getCount() > 0)) {
                cr.moveToFirst();

                do {
                    strb.append("User: (" + cr.getString(0) + ") pass(" + cr.getString(1) + ") Credit Card: (" + cr.getString(2) + ")\n");
                } while (cr.moveToNext());
            }
            else {
                strb.append("User: (" + srctxt.getText().toString() + ") not found");
            }
            Toast.makeText(this, strb.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Log.d("Divax-sqli", "Error occurred while searching in database: " + e.getMessage());
//            To exploit add search: ' OR '1=1--
//            Second option: ' union select * from sqliuser
        }
    }
}
