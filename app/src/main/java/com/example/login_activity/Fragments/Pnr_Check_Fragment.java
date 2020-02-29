package com.example.login_activity.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.login_activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pnr_Check_Fragment extends Fragment {

    ProgressBar  bar;
    public Pnr_Check_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pnr__check_, container, false);
        bar=view.findViewById(R.id.pnr_progressBar);
        bar.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(),"Loading",Toast.LENGTH_SHORT).show();


        openUrl("https://www.ndtv.com/indian-railway/pnr-status");

        return view;
    }

    private void openUrl(String s) {

        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(s));
        startActivity(intent1);
    }

    @Override
    public void onPause() {
        super.onPause();
        bar.setVisibility(View.GONE);
    }
}
