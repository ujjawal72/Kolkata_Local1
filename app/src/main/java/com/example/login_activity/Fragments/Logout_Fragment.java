package com.example.login_activity.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.login_activity.Activity.MainActivity;
import com.example.login_activity.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class Logout_Fragment extends Fragment {


    public Logout_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_logout_, container, false);

        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getContext(),"Logout Successful",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), MainActivity.class));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().finish();
    }
}
