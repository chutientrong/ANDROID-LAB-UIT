package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    private Button btn_back;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        btn_back = findViewById(R.id.button);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewActivity.this.finishActivity(0);
                startActivity(new Intent(NewActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.anim_right, R.anim.anim_fade_out);
            }
        });
    }
}