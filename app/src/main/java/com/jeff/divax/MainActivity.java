package com.jeff.divax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    protected void registerVulnerabilities(List<Vulnerability> vulnerabilities){
        vulnerabilities.add(new Vulnerability(getString(R.string.insecure_logging), getString(R.string.insecure_logging_description)));
        vulnerabilities.add(new Vulnerability(getString(R.string.hardcoding_issues_1), getString(R.string.hardcoding_issue_1_description)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);


        List<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();
        registerVulnerabilities(vulnerabilities);

        mAdapter = new VulnerabilityAdapter(vulnerabilities, this);
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


    }
}
