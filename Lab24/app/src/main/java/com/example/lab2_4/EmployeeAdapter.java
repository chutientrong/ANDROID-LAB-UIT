package com.example.lab2_4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter<Employee>
{
    View llParent = null;
    Activity context=null;
    ArrayList<Employee>myArray=null;
    int layoutId;
    String staff ="Staff";
    /**
     * Constructor này dùng để khởi tạo các giá trị
     * từ MainActivity truyền vào
     * @param context : là Activity từ Main
     * @param layoutId: Là layout custom do ta tạo (my_item_layout.xml)
     * @param arr : Danh sách nhân viên truyền từ Main
     */
    public EmployeeAdapter(Activity context,
                          int layoutId,
                          ArrayList<Employee>arr){
        super(context, layoutId, arr);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arr;
    }
    /**
     * hàm dùng để custom layout, ta phải override lại hàm này
     * từ MainActivity truyền vào
     * @param position : là vị trí của phần tử trong danh sách nhân viên
     * @param convertView: convertView, dùng nó để xử lý Item
     * @param parent : Danh sách nhân viên truyền từ Main
     * @return View: trả về chính convertView
     */
    public View getView(int position, View convertView,
                        ViewGroup parent) {

        Employee employee = getItem(position);
        LayoutInflater inflater=
                context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);
        //chỉ là test thôi, bạn có thể bỏ If đi
        if(myArray.size()>0 && position>=0) {
            //dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
            final TextView txtdisplay = (TextView)
                    convertView.findViewById(R.id.txtitem);
            //lấy ra nhân viên thứ position
            final Employee emp = myArray.get(position);
            //đưa thông tin lên TextView
            //emp.toString() sẽ trả về Id và Name
            txtdisplay.setText(emp.toString());
            //lấy ImageView ra để thiết lập hình ảnh cho đúng
            final ImageView imgitem = (ImageView)
                    convertView.findViewById(R.id.imgitem);
            final TextView txtitem2 = (TextView)
                    convertView.findViewById(R.id.txtitem2);
            LinearLayout linearLayout = (LinearLayout)
                    convertView.findViewById(R.id.LinearLayout1);

            // If this is a manager -> show icon manager. Otherwise, show Staff in tvPosition
            if (emp.isManager()) {
                imgitem.setVisibility(View.VISIBLE);
                imgitem.setImageResource(R.drawable.manager);
                txtitem2.setVisibility(View.GONE);
            } else {
                imgitem.setVisibility(View.GONE);
                txtitem2.setVisibility(View.VISIBLE);
                txtitem2.setText(context.getString(R.string.staff));
            }
        }
// Show different color backgrounds for 2 continuous employees

//        if (position%2==0)
//        {
//            llParent.setBackgroundResource(R.color.white);
//        }
//        else
//        {
//            llParent.setBackgroundResource(R.color.light_blue);
//        }

        return convertView;//trả về View này, tức là trả luôn
        //về các thông số mới mà ta vừa thay đổi
    }
}
