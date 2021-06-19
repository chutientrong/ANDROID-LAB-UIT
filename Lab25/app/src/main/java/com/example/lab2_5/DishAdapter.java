package com.example.lab2_5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;
    public DishAdapter(Activity context, int resource, List<Dish> object){
        super(context, resource,object);
        this.context = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish,null, false);
        }
        // Get item
        Dish dish = getItem(position);

        // Get view
        ImageView im_thumbnail = convertView.findViewById(R.id.imageView1);
        TextView tvName = (TextView)convertView.findViewById(R.id.textView1);
        tvName.setSelected(true);
        ImageView im_position = convertView.findViewById(R.id.imageView2);
//         //Set name
        if(dish.getName() != null) {
            tvName.setText(dish.getName());
        }else{
            tvName.setText("");
        }
//        // If promotion --> show icon promotion
        if(dish.isPromotion()){
            im_position.setVisibility(View.VISIBLE);
            System.out.println(1);
        }
//
//        // Get thumbnail
        if(dish.getThumbnail() != null) {
            im_thumbnail.setImageResource(dish.getThumbnail().getImg());
        }
        return convertView;
    }
}
