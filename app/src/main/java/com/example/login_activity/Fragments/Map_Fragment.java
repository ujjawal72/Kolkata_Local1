package com.example.login_activity.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login_activity.R;
import com.example.login_activity.MapActivity.map_LocationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Map_Fragment extends Fragment  {


    public Map_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_map_, container, false);

       startActivity(new Intent(getActivity(), map_LocationActivity.class));

        return view;
    }


}
