package com.example.login_activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_activity.Activity.PlanYourTrip;
import com.example.login_activity.R;

public  class RailwaypicAdapter extends RecyclerView.Adapter<RailwaypicAdapter.MyViewHolder> {

    private String[] data;
    private int[] imageView;
    private Context context;

    private int[] PlaceDetails = {R.string.Patna_Detail,R.string.Varanasi_Detail,R.string.Madhubani_Detail,R.string.Chandigarh_Detail,R.string.Darjeeling_Detail,R.string.Delhi_Detail,R.string.Goa_Detail,R.string.Chennai_Detaill};

    public RailwaypicAdapter(Context context, String[] data, int[] imageView)
    {
        this.context = context;
        this.data = data;
        this.imageView = imageView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.railwaypic_singleitem,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String title = data[position];
        final int img = imageView[position];
        holder.txtTitle.setText(title);
        holder.imgIcon.setImageResource(img);
        holder.imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlanYourTrip.class);
                intent.putExtra("Image",img);
                intent.putExtra("Detail",PlaceDetails[position]);
                intent.putExtra("Name",title);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  imageView.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon =(ImageView) itemView.findViewById(R.id.imgIcon);
            txtTitle =(TextView) itemView.findViewById(R.id.txtTitle);

        }
    }
}
