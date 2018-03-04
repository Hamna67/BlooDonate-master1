package com.example.marif.bloodapp.PageAdapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marif.bloodapp.Entity.User;
import com.example.marif.bloodapp.Entity.UserHistory;
import com.example.marif.bloodapp.R;

import java.util.ArrayList;

/**
 * Created by Maryem on 2/13/2018.
 */

public class CustomHistoryAdapter extends RecyclerView.Adapter<CustomHistoryAdapter.PersonViewHolder> {

    Context context;
    ArrayList<UserHistory> userList;
    LayoutInflater inflter;

    public CustomHistoryAdapter(Context applicationContext, ArrayList<UserHistory> ul) {
        this.context = context;
        this.userList = ul;
        inflter = (LayoutInflater.from(applicationContext));
    }


    public int getItemCount() {
        return userList.size();
    }

    @Override
    public CustomHistoryAdapter.PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_history, viewGroup, false);
        CustomHistoryAdapter.PersonViewHolder pvh = new CustomHistoryAdapter.PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CustomHistoryAdapter.PersonViewHolder personViewHolder, int i) {


        personViewHolder.Date.setText(((UserHistory)userList.get(i)).getdate());
        personViewHolder.Time.setText(((UserHistory)userList.get(i)).gettime());
        personViewHolder.bloodType.setText(((UserHistory)userList.get(i)).getbloodType());
        personViewHolder.bloodQuantity.setText(((UserHistory)userList.get(i)).getbloodQuantity());


    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Date;
        TextView Time;
        //ImageView personPhoto;
        TextView bloodQuantity;
        TextView bloodType;
        //TextView city;




        PersonViewHolder(View itemView) {

            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardview);
            Date = (TextView)itemView.findViewById(R.id.Date);
            Time = (TextView)itemView.findViewById(R.id.Time);
            bloodType = (TextView)itemView.findViewById(R.id.BloodType);
            bloodQuantity = (TextView)itemView.findViewById(R.id.BloodQuantity);

            //    personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

}

