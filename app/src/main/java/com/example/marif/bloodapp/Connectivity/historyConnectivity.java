package com.example.marif.bloodapp.Connectivity;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.Entity.UserHistory;
import com.example.marif.bloodapp.Page.HistoryActivity;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Maryem on 2/13/2018.
 */

public class historyConnectivity extends AsyncTask<Void, Void, String> {

    ArrayList<UserHistory> userList;
    String phone;
    private Context context;
    private int byGetOrPost = 0;

    HistoryActivity historyContext;
    //flag 0 means get and 1 means post.(By default it is get.)
    public historyConnectivity(Context context,String phone, int flag) {
        super();
        this.context = context;
        byGetOrPost = flag;
        this.phone = phone;

        this.historyContext = (HistoryActivity)context;
        this.userList = new ArrayList<UserHistory>();

    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(Void... params) {



        try {
            String link = "http://ec2-13-127-129-16.ap-south-1.compute.amazonaws.com/HistoryUser.php?phone="+phone+"";;

            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }

            in.close();

            return sb.toString();
        } catch (Exception e) {
            return new String("Exception: GET" + e.getMessage());
        }

    }

    @Override
    protected void onPostExecute(String result){
        Log.d("REQUEST:",result);
        //  historyContext.submitForm(result);

        UserHistory new_user;

        String[] sentences = result.split("Break!");
        for(String s: sentences)
        {
            String[] values=s.split("\\*.\\*");
            Log.d("histry user retrieveing",values[0] + values[1]+values[2]+values[3]);
            new_user = new UserHistory(values[0],values[1],values[2],values[3]);
            userList.add(new_user);
        }

        historyContext.populate(userList);

    }


}
