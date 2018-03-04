package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.marif.bloodapp.Connectivity.RequestConnectivity;
import com.example.marif.bloodapp.Connectivity.historyConnectivity;
import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.Entity.UserHistory;
import com.example.marif.bloodapp.PageAdapter.CustomHistoryAdapter;
import com.example.marif.bloodapp.PageAdapter.CustomRequestAdapter;
import com.example.marif.bloodapp.R;

import java.util.ArrayList;

/**
 * Created by Maryem on 2/13/2018.
 */

public class HistoryActivity extends AppCompatActivity
{
    RecyclerView historyList;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        phone= getIntent().getStringExtra("PHONE");
        new historyConnectivity(this,phone, 0).execute();

    }

    public void populate(ArrayList<UserHistory> userList)
    {
        historyList = (RecyclerView) findViewById(R.id.historyRecyclerView);
        historyList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        historyList.setLayoutManager(llm);
        CustomHistoryAdapter customAdapter = new CustomHistoryAdapter(getApplicationContext(), userList);
        historyList.setAdapter(customAdapter);

    }
    public void Donationhistory(View view)
    {
        Intent myIntent = new Intent(HistoryActivity.this, DHistoryActivity.class).putExtra("PHONE",phone);
        //myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(myIntent);

    }
    public void Requesthistory(View view)
    {
        Intent myIntent = new Intent(HistoryActivity.this, HistoryActivity.class).putExtra("PHONE",phone);
        //myIntent.setFlags( Intent.FL);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(myIntent);

    }
}

