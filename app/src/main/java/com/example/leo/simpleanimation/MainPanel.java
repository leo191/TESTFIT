package com.example.leo.simpleanimation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainPanel extends Fragment {

    static  boolean bol;
    ImageView bef,af;
    public MainPanel() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        bef.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        bef.setVisibility(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        bef.setVisibility(View.VISIBLE);
                        break;


                }
                return true;
            }

        });
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_main_panel, container, false);

        bef = (ImageView)view.findViewById(R.id.before_im);
        af =(ImageView)view.findViewById(R.id.after_im);

        return view;
    }

}
