package com.example.marif.bloodapp.Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marif.bloodapp.PageAdapter.CustomHomeAdapter;
import com.example.marif.bloodapp.R;
import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.Connectivity.homepageConnectivity;

public class HomePage extends AppCompatActivity {

    User logged_user;
    String phone;

    TextView userNameText;

    ListView simpleList;
    String tagList[] = {"Name", "Email","Phone","Blood Group","Available for Donation","Date of Birth","Location", "Weight", "Height"};
  //  String tagList[] = {"First Name", "Last Name", "Email","Phone", "Location", "Blood Group", "Weight", "Height","Date of Birth"};
    String valueList[] = {"","","","","","","","",""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userNameText = (TextView) findViewById(R.id.username);
        phone= getIntent().getStringExtra("PHONE");
        Toast.makeText(this, "Logged in as " + phone, Toast.LENGTH_LONG).show();
        fetchUserData();





    }

    protected void fetchUserData()
    {
        new homepageConnectivity(this,phone, 0).execute();
    }
    public void populate(User u)
    {

        userNameText.setText(u.getFirstName() + " " + u.getLastName());

       /* valueList[0] = u.getFirstName();
        valueList[1] = u.getLastName();
        valueList[2] = u.getEmail();
        valueList[3] = u.getPhoneNum();
        valueList[4] = u.getCity();
        valueList[5] = u.getBloodGroup();
        valueList[6] = Double.toString(u.getWeight());
        valueList[7] = Double.toString(u.getHeight());
        valueList[8] = u.getDateOfBirth();
*/
        valueList[0] = u.getFirstName() + " " + u.getLastName();
        valueList[1] = u.getEmail();
        valueList[2] = u.getPhoneNum();
        valueList[3] = u.getBloodGroup();
        valueList[4]=  "NO"; //later read from database
        valueList[5] = u.getDateOfBirth();
        valueList[6] = u.getCity();
        valueList[7] = Double.toString(u.getWeight());
        valueList[8] = Double.toString(u.getHeight());

        simpleList = (ListView) findViewById(R.id.profileList);
        CustomHomeAdapter customAdapter = new CustomHomeAdapter(getApplicationContext(), tagList, valueList);
        simpleList.setAdapter(customAdapter);


    }

    public void changepassword(View view)
    {
        Intent myIntent = new Intent(HomePage.this, ChangePassword.class).putExtra("PHONE",phone);
        startActivity(myIntent);
    }
    public void editdataprofile(View view)
    {
        Intent myIntent = new Intent(HomePage.this, EditProfile.class).putExtra("PHONE",phone);
        startActivity(myIntent);
    }
    public void request(View view)
    {
        Intent myIntent = new Intent(HomePage.this, RequestActivity.class).putExtra("PHONE",phone);
        startActivity(myIntent);

    }
    public void history(View view)
    {
        Intent myIntent = new Intent(HomePage.this, HistoryActivity.class).putExtra("PHONE",phone);
        startActivity(myIntent);

    }
    public void WallOfFame(View view)
    {
        Intent myIntent = new Intent(HomePage.this, WallOfFameActivity.class).putExtra("PHONE",phone);
        startActivity(myIntent);

    }
}
