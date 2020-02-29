package com.example.login_activity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login_activity.Adapter.RailwaypicAdapter;
import com.example.login_activity.Adapter.TrainAdapter;
import com.example.login_activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rail_Tour_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    RailwaypicAdapter railwayPicAdapter;
    private int[] images = {R.drawable.patna,R.drawable.varanasi,R.drawable.madhubani,
            R.drawable.chandigarh,R.drawable.darjeeling,R.drawable.delhi,
            R.drawable.goa,R.drawable.chennai};

    private String[] names = {"Patna","Varanasi","Madhubani","Chandigarh","Darjeeling","Delhi","Goa","Chennai"};




    public Rail_Tour_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_rail__tour, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        railwayPicAdapter = new RailwaypicAdapter(getContext(),names,images);
        recyclerView.setAdapter(railwayPicAdapter);

       return  view;
    }

}
