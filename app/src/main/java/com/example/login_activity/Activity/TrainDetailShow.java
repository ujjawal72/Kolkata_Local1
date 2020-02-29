package com.example.login_activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.login_activity.Adapter.TrainAdapter;
import com.example.login_activity.Database.Database;
import com.example.login_activity.Fragments.Train_Search_Fragment;
import com.example.login_activity.R;

public class TrainDetailShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_detail_show);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String source = intent.getStringExtra("SOURCE");
        String destination = intent.getStringExtra("DESTINATION");

        if (source != null ) {
            if (destination != null) {
                setTitle(source.toUpperCase() + "-to-"+destination.toUpperCase());
            }
        }

        recyclerView.setAdapter(new TrainAdapter(this, source, destination));


    }
}
