package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duandovui.R;

public class HuongDanActivity extends AppCompatActivity implements HuongDanInterface {
   Button btnThoat;
HuongDanPrecenter pre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        pre = new HuongDanPrecenter(this);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               pre.prethoat();
            }
        });
    }

    @Override
    public void thoat() {
        finish();
    }
}
