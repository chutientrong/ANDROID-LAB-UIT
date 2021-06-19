package com.example.lab2_6;


import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_fullname;
        private TextView tv_position;
        private ImageView is_manager;
        private LinearLayout ll_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_fullname = itemView.findViewById(R.id.item_employee_tv_fullname);
            tv_position = itemView.findViewById(R.id.item_employee_tv_position);
            is_manager = itemView.findViewById(R.id.item_employee_iv_manager);
            ll_parent = itemView.findViewById(R.id.item_employee_ll_parent);
        }
    }
    private Activity context;
    private List<Employee> employees;
    private int layout;

    public EmployeeAdapter(Activity context,int layoutID, List<Employee> objects) {
        this.context = context;
        this.employees = objects;
        this.layout = layoutID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View employeeView = inflater.inflate(R.layout.item_employee,parent,false);
        ViewHolder viewHolder = new ViewHolder((employeeView));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employees.get(position);
        if(employee.getFullName() != null) {
            holder.tv_fullname.setText((employee.getFullName()));
        } else {
            holder.tv_fullname.setText("");
        }
        // If this is a manager -> show icon manager. Otherwise, show staff in tvPosition
        if(employee.isManager()) {
            holder.is_manager.setVisibility(View.VISIBLE);
            holder.tv_position.setVisibility(View.GONE);
        } else {
            holder.is_manager.setVisibility(View.GONE);
            holder.tv_position.setVisibility(View.VISIBLE);
            holder.tv_position.setText(context.getString(R.string.staff));
        }
        // Show different color backgrounds for 2 continuois employees
        if(position%2==0){
            holder.ll_parent.setBackgroundResource(R.color.white);
        }
        else {
            holder.ll_parent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

}



