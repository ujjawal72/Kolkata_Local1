package com.example.login_activity.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_activity.R;

public class HelpLineAdapter extends RecyclerView.Adapter<HelpLineAdapter.ViewHolder> {

    final static private int REQUEST_CALL = 1;
    String call;
    private String[] details = {"test1", "test2", "RPF", "Ambulance", "Fire", "Police", "State Police", "Vigilance", "Food Quality Complaint", "Railway Enquiry", "Rail Accident Emergency", "Aids Helpline", "RPF", "Ambulance", "Fire", "Police", "State Police", "Vigilance", "Food Quality Complaint", "Railway Enquiry"};
    private String[] numbers = {"1234", "4321", "182", "102", "101", "100", "1512", "155210", "138", "139", "1072", "1097", "182", "102", "101", "100", "1512", "155210", "138", "139"};


    Activity activity;
    private Context context;

    public HelpLineAdapter(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpline_single_item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtAboutNumber.setText(details[position]);
        holder.txtNumber.setText(numbers[position]);
        holder.txtNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    String[] permissions = {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions(activity, permissions, REQUEST_CALL);

                } else{
                    Toast.makeText(context, "Calling: " + numbers[position], Toast.LENGTH_LONG).show();
                    call =  "tel:"+numbers[position];
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(call));
                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return details.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAboutNumber;
        TextView txtNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAboutNumber = itemView.findViewById(R.id.txtAboutNumber);
            txtNumber = itemView.findViewById(R.id.txtCall);

        }
    }
}
