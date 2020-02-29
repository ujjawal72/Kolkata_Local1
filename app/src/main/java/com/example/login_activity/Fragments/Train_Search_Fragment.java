package com.example.login_activity.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_activity.Activity.TrainDetailShow;
import com.example.login_activity.Database.Database;
import com.example.login_activity.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Train_Search_Fragment extends Fragment {

    /* public static final String EXTRA_TEXT = "com.example.myapplication.EXTRA_TEXT";
     public static final String EXTRA_TEXT1 = "com.example.myapplication.EXTRA_TEXT1";
 */
    AutoCompleteTextView source;
    AutoCompleteTextView destination;

    private Button swapButton;
    private Button searchButton;


    private final static String[] LOCAL_STATION_NAME = {"Howrah", "Kolkata", "Krisnanager", "Lalgola", "Naihati", "Belgharia", "Sealdah", "Birati", "Ranaghat", "Gede", "Kalyani", "Barrackpore", "Barddhaman", "Bidhan Nagar", "Agarpara", "Sodpur", "Shantipur"};

    public Train_Search_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_train__search_, container, false);


        final AutoCompleteTextView source = (AutoCompleteTextView) view.findViewById(R.id.sourceAutoCompleteTextView);
        final AutoCompleteTextView destination = (AutoCompleteTextView) view.findViewById(R.id.destinationAutoCompleteTextView);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, LOCAL_STATION_NAME);

        (source).setAdapter(adapter);
        destination.setAdapter(adapter);

        final Database database = new Database(getActivity());

        swapButton = (Button) view.findViewById(R.id.swapButton);
        searchButton = (Button) view.findViewById(R.id.searchTrainButton);

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = source.getText().toString();
                source.setText(destination.getText().toString());
                destination.setText(temp);

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String src = source.getText().toString();
                String des = destination.getText().toString();

                if (!src.equals("") && !des.equals("")) {

                    database.openDB();
                    if(!database.getTrainDirection(src,des).equals("Not Found")){

                        database.closeDB();
                        Intent intent = new Intent(getActivity(), TrainDetailShow.class);
                        intent.putExtra("SOURCE", src);
                        intent.putExtra("DESTINATION", des);
                        startActivity(intent);

                    }else {
                        Toast.makeText(getActivity(),"Train Not Available for this route!!",Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Please Enter Source and Destination", Toast.LENGTH_LONG).show();
                }

            }

        });


        return view;
    }


}
