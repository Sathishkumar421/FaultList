package com.example.controlapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controlapp.R;
import com.example.controlapp.Single_Fault;

import java.util.ArrayList;

public class RecyclerVIewAdapter extends RecyclerView.Adapter<RecyclerVIewAdapter.ViewHolder> {

    public Context context;
    public ArrayList<Single_Fault> FaultList;

    public RecyclerVIewAdapter(Context context, ArrayList<Single_Fault> faultList) {
        this.context = context;
        FaultList = faultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.single_work,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Single_Fault fault=FaultList.get(position);
        holder.id.setText(fault.getID());
        holder.taskStat.setText(fault.getTaskStatus());
        holder.title.setText(fault.getTitle());
        holder.place.setText(fault.getPlace());
        holder.days.setText(fault.getDays());
        holder.type1.setText(fault.getType1());
        holder.type2.setText(fault.getType2());
        holder.type3.setText(fault.getType3());

    }

    @Override
    public int getItemCount() {
        return FaultList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id,taskStat,title,place,days,type1,type2,type3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.FaultID);
            taskStat=itemView.findViewById(R.id.TaskStat);
            title=itemView.findViewById(R.id.Task);
            place=itemView.findViewById(R.id.Location);
            days=itemView.findViewById(R.id.Time);
            type1=itemView.findViewById(R.id.Type1);
            type2=itemView.findViewById(R.id.Type2);
            type3=itemView.findViewById(R.id.Type3);
        }
    }
}
