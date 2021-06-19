package com.example.lab2_4;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    //Sử dụng MyArrayAdapter thay thì ArrayAdapter
    EmployeeAdapter adapter = null;
    ListView lvNhanvien = null;

    Button btnNhap;
    EditText editMa, editTen;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = (Button) findViewById(R.id.btnNhap);
        editMa = (EditText) findViewById(R.id.editMa);
        editTen = (EditText) findViewById(R.id.editTen);
        genderGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        lvNhanvien = (ListView) findViewById(R.id.lvnhanvien);
        arrEmployee = new ArrayList<Employee>();
        //Khởi tạo đối tượng adapter và gán Data source
        adapter = new EmployeeAdapter(
                this,
                R.layout.my_item_layout,// lấy custom layout
                arrEmployee/*thiết lập data source*/);
        lvNhanvien.setAdapter(adapter);//gán Adapter vào Lisview

        btnNhap.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                xulyNhap();
            }
        });
    }
    //gọi hàm xử lý nhập thông tin nhân viên
    public void xulyNhap() {
        String ma = editMa.getText() + "";
        String ten = editTen.getText() + "";
        boolean quanly = false;//Staff =false
        CheckBox chk = (CheckBox) findViewById(R.id.cbStaff);
        //Nếu nó Checked thì laf Manager
        if (chk.isChecked()) {
            quanly = true;
        } else {
            quanly = false;
        }
        Employee emp = new Employee();
        emp.setId(ma);
        emp.setName(ten);
        emp.setManager(quanly);
        //Đưa vào danh sách
        arrEmployee.add(emp);
        //gọi hàm cập nhật giao diện
        adapter.notifyDataSetChanged();
        //Sau khi update thì xóa trắng dữ liệu và cho editma focus
        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();

    }
}