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
        vulnerabilities.add(new Vulnerability(getString(R.string.hardcoding_issues_1), getString(R.string.hardcoding_issue_1_description), com.jeff.hardcodingissue1.hardcodingIssue1.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.hardcoding_issues_2), getString(R.string.hardcoding_issue_2_description), com.jeff.hardcodingissue2.hardcodingIssue2.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.insecure_data_storage_1), getString(R.string.insecure_data_storage_1_description), com.jeff.insecuredatastorage1.insecureDataStorage1.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.insecure_data_storage_2), getString(R.string.insecure_data_storage_2_description), com.jeff.insecuredatastorage2.insecureDataStorage2.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.insecure_data_storage_3), getString(R.string.insecure_data_storage_3_description), com.jeff.insecuredatastorage3.insecureDataStorage3.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.insecure_data_storage_4), getString(R.string.insecure_data_storage_4_description), com.jeff.insecuredatastorage4.insecureDataStorage4.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.input_validation_issue_1), getString(R.string.input_validation_issue_1_description), com.jeff.inputvalidationissue1.inputValidationIssue1.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.input_validation_issue_2), getString(R.string.input_validation_issue_2_description), com.jeff.inputvalidationissue2.inputValidationIssue2.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.input_validation_issue_3), getString(R.string.input_validation_issue_3_description), com.jeff.inputvalidationissue3.inputValidationIssue3.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.access_control_issue_1), getString(R.string.access_control_issue_1_description), com.jeff.accesscontrolissue1.accessControlIssue1.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.access_control_issue_2), getString(R.string.access_control_issue_2_description), com.jeff.accesscontrolissue2.accessControlIssue2.class));
        vulnerabilities.add(new Vulnerability(getString(R.string.access_control_issue_3), getString(R.string.access_control_issue_3_description), com.jeff.accesscontrolissue3.accessControlIssue3.class));


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
