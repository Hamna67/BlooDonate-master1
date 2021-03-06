package com.example.marif.bloodapp.PageAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marif.bloodapp.R;

/**
 * Created by ABC on 12/18/2017.
 */

public class CustomHomeAdapter extends BaseAdapter {
    Context context;
    String TextFileds[];
    String Values[];
    LayoutInflater inflter;

    public CustomHomeAdapter(Context applicationContext, String[] txt, String[] val) {
        this.context = context;
        this.TextFileds = txt;
        this.Values = val;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return TextFileds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView tag = (TextView) view.findViewById(R.id.tagTextView);
        TextView value = (TextView) view.findViewById(R.id.valueTextView);

        tag.setText(TextFileds[i]);
        value.setText(Values[i]);

        return view;
    }
}
