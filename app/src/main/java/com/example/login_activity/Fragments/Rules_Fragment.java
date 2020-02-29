package com.example.login_activity.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.login_activity.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rules_Fragment extends Fragment {
    ListView listView;
    TextView textView;
    String [] rules;


    public Rules_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rules, container, false);

        listView=view.findViewById(R.id.Lists);
       textView=view.findViewById(R.id.Rules_And_Helplines);
        rules =getResources().getStringArray(R.array.array_technology);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, rules);
        listView.setAdapter(adapter);
        return  view;
    }

    @Override
    public void onPause() {
        super.onPause();
        Objects.requireNonNull(getActivity()).finish();
    }
}
