package com.example.lab2_5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = 30)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_add = findViewById(R.id.button);
        EditText ed_name = findViewById(R.id.ed_name);
        CheckBox ck_position = findViewById(R.id.checkBox);
        List<Dish> dishs = new ArrayList<Dish>();
        DishAdapter dishAdapter = new DishAdapter(this,R.layout.activity_main, dishs);
        Spinner spinner = findViewById(R.id.spinner);
        List<Thumbnail> thumbnails = List.of(Thumbnail.Thumbnail1,Thumbnail.Thumbnail2, Thumbnail.Thumbnail3, Thumbnail.Thumbnail4);
        ThumbnailAdapter ThumbnailAdapter = new ThumbnailAdapter(this,R.layout.activity_main,thumbnails);
        spinner.setAdapter(ThumbnailAdapter);
        GridView gd_list = findViewById(R.id.list_dish);
        bt_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName(ed_name.getText().toString());
                dish.setThumbnail((Thumbnail) spinner.getSelectedItem());
                dish.setPromotion(ck_position.isChecked());
                dishs.add(dish);
                ed_name.getText().clear();
                spinner.setSelection(0);
                ck_position.setChecked(false);
                Toast.makeText(getApplicationContext(),"Add sucessfully",
                        Toast.LENGTH_SHORT).show();
                gd_list.setAdapter(dishAdapter);
            }
        });
    }
}