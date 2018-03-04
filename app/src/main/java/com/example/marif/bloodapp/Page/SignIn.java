package com.example.marif.bloodapp.Page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marif.bloodapp.R;
import com.example.marif.bloodapp.Connectivity.signinConnectivity;

public class SignIn extends AppCompatActivity {


    TextView textview;
    EditText PhoneNumber;
    EditText Password;
    SharedPreferences sp;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Phone = "phoneKey";
    public static final String Pass = "PassKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
       // PhoneNumber=(EditText)findViewById(R.id.phone_input_signin);
        //Password=(EditText)findViewById(R.id.password_input_signin);
        textview = (TextView) findViewById(R.id.textView6);
        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);



    }

    public void login(){
        PhoneNumber=(EditText)findViewById(R.id.phone_input_signin);
        Password=(EditText)findViewById(R.id.password_input_signin);


        new signinConnectivity(this,textview,PhoneNumber.getText().toString(),Password.getText().toString(), 0).execute();
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(Phone, "0320-1122445");
        editor.putString(Pass, "Peanut12*");
        editor.commit();

    }

    public void goToHomeAfterSignin(View view) {
        login();
     /*   TextView T=(TextView)findViewById(R.id.textView6);
        String txt=T.getText().toString();
        if (txt.length()<10) {
            Intent myIntent = new Intent(SignIn.this,
                    HomePage.class);
            startActivity(myIntent);// Do something in response to button
        }*/
    }

    public void loggedIn(String result)
    {
        Log.i("loggedIn:",result);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        if(result.equals(" logged in"))
        {

            Log.i("loggedIn:","YES");
            Intent myIntent = new Intent(SignIn.this,
                    HomePage.class).putExtra("PHONE",PhoneNumber.getText().toString());
            startActivity(myIntent);
        }
    }
}
