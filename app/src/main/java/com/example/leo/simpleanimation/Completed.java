package com.example.leo.simpleanimation;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leo.simpleanimation.model.RecyclerItemClickListener;
import com.example.leo.simpleanimation.model.RecyclerViewAdapter;


public class Completed extends Fragment {

    RecyclerView recyclerView,another;
    RecyclerViewAdapter adapterU,adapterL;
    String[] upper,lower;


    public Completed() {


    }


    public void setNames()
    {
        upper = new String[]{"back squat","dead lift","bench press","bent row"};
        lower = new String[] {
                "barbell curl",
                "front squat",
                "lunge",
                "plate cocoon",
                "plate sit up",
                "plate twist",
                "pull over",
                "pull press",
                "sl deadlift",
                "sumo deadlift",
                "thruster",
                "tricep extension",
                "upper row",
                "wt dip",
                "wt pull up"
                ,""
        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed, container, false);
        setNames();

        recyclerView = (RecyclerView)view.findViewById(R.id.upper_rc_view);
        another = (RecyclerView)view.findViewById(R.id.lower_rc_view);
        recyclerView.setHasFixedSize(true);

        adapterU = new RecyclerViewAdapter(upper);
        adapterL = new RecyclerViewAdapter(lower);

        another.setAdapter(adapterL);
        recyclerView.setAdapter(adapterU);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager linearLayoutManager1  = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        another.addItemDecoration(dividerItemDecoration);
        another.setLayoutManager(linearLayoutManager1);
        recyclerView.setLayoutManager(linearLayoutManager);



        return  view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        String tv=((TextView) (((ViewGroup)((ViewGroup)view).getChildAt(0)).getChildAt(0))).getText().toString();
                        Intent in = new Intent(getActivity(),ExerciseWindow.class);
                        in.putExtra("ename",tv);
                        startActivity(in);


                    }
                })
        );



        another.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String tv=((TextView) (((ViewGroup)((ViewGroup)view).getChildAt(0)).getChildAt(0))).getText().toString();
                Intent in = new Intent(getContext(),ExerciseWindow.class);
                in.putExtra("ename",tv);
                startActivity(in);
            }
        }));
    }
}
