package com.example.lab2_1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[]={"Tèo","Tý","Bin","Bo"};
        //2. Lấy đối tượng Listview
        ListView lv=(ListView) findViewById(R.id.lvperson);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String>adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        lv.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.txtsel);
        //5. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0,
                                            View arg1,
                                            int arg2,
                                            long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txt.setText("position :"+arg2+" ; value ="+arr[arg2]);
                    }
                });
    }
}