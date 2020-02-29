package com.example.login_activity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login_activity.Adapter.HelpLineAdapter;
import com.example.login_activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpLine_Fragment extends Fragment {


    public HelpLine_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_help_line_, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHelpline);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new HelpLineAdapter(getActivity(),getActivity()));

        return  view;
    }

}
