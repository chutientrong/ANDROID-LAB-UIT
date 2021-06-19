package com.example.lab2_2;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText txtten;
    TextView txtchon;
    Button btn;
    ListView lv;
    ArrayList<String>arrList=null;
    ArrayAdapter<String> adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtten=(EditText) findViewById(R.id.txtTen);
        txtchon=(TextView) findViewById(R.id.txtsel);

        lv=(ListView) findViewById(R.id.lvperson);
        //1. Tạo ArrayList object
        arrList=new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
        adapter=new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        arrList);
        //3. gán Adapter vào ListView
        lv.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.txtsel);
        btn=(Button) findViewById(R.id.btnNhap);
        //4. Xử lý sự kiện nhấn nút Nhập
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arrList.add(txtten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lv.setOnItemClickListener(new AdapterView
                .OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0,View arg1,
                    int arg2,long arg3) {

                txtchon.setText("position : "+ arg2+
                        "; value ="+arrList.get(arg2));
            }
        });

        //6. xử lý sự kiện Long click
        lv.setOnItemLongClickListener(new AdapterView
                .OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                arrList.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
