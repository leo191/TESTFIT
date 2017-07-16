package com.example.leo.simpleanimation.model;

/**
 * Created by leo on 16/07/17.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leo.simpleanimation.R;

import java.util.ArrayList;
import java.util.List;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ThisViewHolder> {



    public String[] list_data;


    public static class ThisViewHolder extends RecyclerView.ViewHolder{

        public TextView exerise_name;

        public CardView mCardView;



        public ThisViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView)itemView.findViewById(R.id.my_card);
            exerise_name = (TextView) itemView.findViewById(R.id.exercise_tv);

        }
    }

    public RecyclerViewAdapter(String[] list_data)
    {
            this.list_data = list_data;
    }




    @Override
    public ThisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.exercise_row, parent, false);
        return new ThisViewHolder(itemView);



    }

    @Override
    public void onBindViewHolder(ThisViewHolder holder, int position) {

        holder.exerise_name.setText(list_data[position]);


    }

    @Override
    public int getItemCount() {
        return list_data.length;
    }





}
