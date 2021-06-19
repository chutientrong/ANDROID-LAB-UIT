package com.example.lab2_5;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Activity context;

    public ThumbnailAdapter(Activity context, int layoutID, List<Thumbnail> objects) {
        super(context,layoutID,objects);
        this.context = context;
    }

    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail,null,false);
        }
        // Get item
        Thumbnail thumbnail = getItem(position);
        //System.out.println("Thumnail" + thumbnail.getName());
        //Get view
        TextView tvname = convertView.findViewById(R.id.name_thumbnail);
        ImageView im_thumbnail = convertView.findViewById(R.id.img_thumbnail);
        //LinearLayout llParent = convertView.findViewById(R.layout.activity_main);

        // Set fullname
        if(thumbnail.getName() != null) {
            tvname.setText(thumbnail.getName());
        } else {
            tvname.setText("");
        }
        // If this is a manager -> show icon manager. Otherwise, show staff in tvPosition
        if(thumbnail.getName() != null) {
            im_thumbnail.setImageResource(thumbnail.getImg());
        }
        return convertView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail,null,false);
        }
        Thumbnail thumbnail = getItem(position);
        TextView tvname = convertView.findViewById(R.id.textView4);
        //System.out.println(thumbnail.getName());
        if(thumbnail.getName() != null) {
            tvname.setText(thumbnail.getName());
        } else {
            tvname.setText("");
        }
        return convertView;
    }
}