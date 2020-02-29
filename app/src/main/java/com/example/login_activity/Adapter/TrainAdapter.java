package com.example.login_activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_activity.Database.DataClassForDatabase;
import com.example.login_activity.Database.Database;
import com.example.login_activity.R;

import java.util.List;

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.MyViewHolder> {

    private Database database;
    private DataClassForDatabase dataClass;
    private List<String> tNameList;
    private List<String> tArrTimeList;
    private List<String> tDepTimeList;
    private List<String> tNumberList;
    private Context context;

    public TrainAdapter(Context context, String source, String destination) {

        this.context = context;
        dataClass = new DataClassForDatabase();
        database = new Database(context);
        database.openDB();
        dataClass = database.getTrains(source,destination);

        tNumberList = dataClass.getTrainNumbers();
        tNameList = dataClass.getTrainNames();
        tArrTimeList = dataClass.getArrTimes();
        tDepTimeList = dataClass.getDepTimes();
        database.closeDB();

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_train_recycler,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.trnName.setText(tNameList.get(position));
        holder.trnArrTime.setText(tArrTimeList.get(position));
        holder.trnDepTime.setText(tDepTimeList.get(position));
        holder.trnNo.setText(tNumberList.get(position));
        holder.trnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return tNameList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView trnNo;
        TextView trnName;
        TextView trnArrTime;
        TextView trnDepTime;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            trnName = itemView.findViewById(R.id.trnName);
            trnNo = itemView.findViewById(R.id.trnNo);
            trnArrTime = itemView.findViewById(R.id.trnArrTime);
            trnDepTime = itemView.findViewById(R.id.trnDepTime);
        }
    }

}
