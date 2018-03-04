package com.example.marif.bloodapp.Page;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marif.bloodapp.Connectivity.historyConnectivity;
import com.example.marif.bloodapp.Connectivity.wallOfFameConnectivity;
import com.example.marif.bloodapp.Entity.UserHistory;
import com.example.marif.bloodapp.PageAdapter.CustomHistoryAdapter;
import com.example.marif.bloodapp.PageAdapter.CustomwallOfFameAdapter;
import com.example.marif.bloodapp.R;

import java.util.ArrayList;

/**
 * Created by Maryem on 2/26/2018.
 */

public class WallOfFameActivity extends AppCompatActivity
{
    RecyclerView WallOfFame;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);


        phone= getIntent().getStringExtra("PHONE");
        new wallOfFameConnectivity(this,phone, 0).execute();

    }

    public void populate(String sum)
    {
        //WallOfFame = (RecyclerView) findViewById(R.id.historyRecyclerView);
        //WallOfFame.setHasFixedSize(true);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //WallOfFame.setLayoutManager(llm);
        CustomwallOfFameAdapter customAdapter = new CustomwallOfFameAdapter(getApplicationContext(), sum);
        WallOfFame.setAdapter(customAdapter);

    }
}
