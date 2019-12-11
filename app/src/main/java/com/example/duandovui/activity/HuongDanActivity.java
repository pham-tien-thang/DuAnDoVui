package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duandovui.R;
import com.example.duandovui.databinding.ActivityHuongDanBinding;

public class HuongDanActivity extends AppCompatActivity implements HuongDanInterface {
   Button btnThoat;
HuongDanPrecenter pre;
ActivityHuongDanBinding huongDanBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan);
        huongDanBinding =  DataBindingUtil.setContentView(HuongDanActivity.this, R.layout.activity_huong_dan);
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
