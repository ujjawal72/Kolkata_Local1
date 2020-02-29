package com.example.login_activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login_activity.R;

public class PlanYourTrip extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView txtTripDetail;
    Button btnBookTrain,btnBookHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_your_trip);



        imageView = (ImageView)findViewById(R.id.imgShow);
        textView = (TextView)findViewById(R.id.txtNameShow);
        txtTripDetail = (TextView)findViewById(R.id.txtTripDetail);
        btnBookTrain = (Button)findViewById(R.id.btnBookTrain);
        btnBookHotel = (Button)findViewById(R.id.btnBookHotel);


        final Intent intent = getIntent();
        txtTripDetail.setText(intent.getIntExtra("Detail",0));
        textView.setText(intent.getStringExtra("Name"));
        imageView.setImageResource(intent.getIntExtra("Image",0));

        btnBookTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://www.irctc.co.in/");
            }
        });

        btnBookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl("https://www.trivago.in/");
            }
        });

    }

    private void openUrl(String url){
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(url));
        startActivity(intent1);
    }
}
