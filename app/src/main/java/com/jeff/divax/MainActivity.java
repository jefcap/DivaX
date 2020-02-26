package com.jeff.divax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    protected void registerVulnerabilities(List<Vulnerability> vulnerabilities){
        vulnerabilities.add(new Vulnerability(getString(R.string.insecure_logging), getString(R.string.insecure_logging_description), com.jeff.insecurelogging.InsecureLogging.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.hardcoding_issues_1), getString(R.string.hardcoding_issue_1_description), ActivityTest2.class));
//        vulnerabilities.add(new Vulnerability("3- Insecure Data Storage - Part 1", "Find out where/how the credentials are being stored and the vulnerable code (SharedPreferences)."));
//        vulnerabilities.add(new Vulnerability("4- Insecure Data Storage - Part 2", "Find out where/how the credentials are being stored and the vulnerable code (SQLite local Database)."));
//        vulnerabilities.add(new Vulnerability("5- Insecure Data Storage - Part 3", "Find out where/how the credentials are being stored and the vulnerable code (Saved in internal R/W file)."));
//        vulnerabilities.add(new Vulnerability("6- Insecure Data Storage - Part 4", "Find out where/how the credentials are being stored and the vulnerable code (Saved in external R/W file)."));
//        vulnerabilities.add(new Vulnerability("7- Access Control Issues - Part 1", "You are able to access the API credentials when you click the button. Now, try to access the APO credentials from outside the app (Activity with exported intent)."));
//        vulnerabilities.add(new Vulnerability("8- Access Control Issues - Part 2", "You are able to access the API credentials when you click the button. Now, try to access the APO credentials from outside the app (Activity with exported intent and putextras)."));
//        vulnerabilities.add(new Vulnerability("9- Access Control Issues - Part 3", "This is a private notes application. You can create a PIN once and access your notes after entering the correct pin. Now, try to access the private notes from outside the app without knowing the PIN."));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);


        final List<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();
        registerVulnerabilities(vulnerabilities);

        mAdapter = new VulnerabilityAdapter(vulnerabilities, this, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //Showing toast of chosen option
                String postId = vulnerabilities.get(position).getVulnName();
                Toast.makeText(v.getContext(),"Entering " + postId, Toast.LENGTH_SHORT).show();

                Class chosenActivity = vulnerabilities.get(position).getVulnClass();
                //Create intent to open activity (explicit intent)
                Intent activityTest1 = new Intent(MainActivity.this, chosenActivity);
                //Start new activity
                startActivity(activityTest1);
            }
        });
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);



    }
}
