package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.duandovui.R;

public class DiemCaoActivity extends AppCompatActivity {
  ListView lvDiemCao;
     Button btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_cao);
        lvDiemCao = (ListView) findViewById(R.id.lvDiemCao);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
