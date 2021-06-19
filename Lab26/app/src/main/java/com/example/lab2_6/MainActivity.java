package com.example.lab2_6;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_add = findViewById(R.id.button);
        final EditText ed_id = findViewById(R.id.ed_id);
        final EditText ed_fullname = findViewById(R.id.ed_fullname);
        final CheckBox checkBox = findViewById(R.id.checkBox);
        RecyclerView lv_nv = findViewById(R.id.lv_nv);
        final List<Employee> employeeList = new ArrayList<Employee>();
        final EmployeeAdapter employeeAdapter = new EmployeeAdapter(this,R.layout.activity_main,employeeList);
        lv_nv.setAdapter(employeeAdapter);
        lv_nv.setLayoutManager(new LinearLayoutManager(this));
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = new Employee();
                employee.setId(ed_id.getText().toString());
                employee.setFullName(ed_fullname.getText().toString());
                employee.setManager(checkBox.isChecked());
                employeeList.add(employee);
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }
}