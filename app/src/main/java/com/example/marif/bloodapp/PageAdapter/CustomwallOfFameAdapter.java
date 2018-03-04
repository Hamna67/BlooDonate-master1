package com.example.marif.bloodapp.PageAdapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillValue;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.marif.bloodapp.Entity.UserHistory;
import com.example.marif.bloodapp.R;

import java.util.ArrayList;

/**
 * Created by Maryem on 2/27/2018.
 */

public class CustomwallOfFameAdapter extends RecyclerView.Adapter<CustomwallOfFameAdapter.PersonViewHolder> {

    Context context;
    public static String sum;
    LayoutInflater inflter;


    public CustomwallOfFameAdapter(Context applicationContext, String sum) {
        this.context = context;
        this.sum = sum;
        inflter = (LayoutInflater.from(applicationContext));
    }

    public int getItemCount() {
        return 1;
    }

    @Override
    public CustomwallOfFameAdapter.PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_wall_of_fame, viewGroup, false);
        CustomwallOfFameAdapter.PersonViewHolder pvh = new CustomwallOfFameAdapter.PersonViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(CustomwallOfFameAdapter.PersonViewHolder personViewHolder, int i) {

        personViewHolder.points.setText(sum);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView points;
        //TextView Time;
        //ImageView personPhoto;
        //TextView bloodQuantity;
        //TextView bloodType;
        //TextView city;
        RatingBar ratingBar;



        PersonViewHolder(View itemView) {

            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardview);
            points = (TextView)itemView.findViewById(R.id.PointInDigits);

            ratingBar = (RatingBar)itemView.findViewById(R.id.ratingBar);
            ratingBar.setNumStars(Integer.parseInt(Integer.toString(Integer.parseInt(sum))));
            //Time = (TextView)itemView.findViewById(R.id.Time);
            //bloodType = (TextView)itemView.findViewById(R.id.BloodType);
            //bloodQuantity = (TextView)itemView.findViewById(R.id.BloodQuantity);

            //    personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

}
