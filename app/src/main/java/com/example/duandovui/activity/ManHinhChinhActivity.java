package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duandovui.R;

public class ManHinhChinhActivity extends AppCompatActivity {
     Button btnTaiKhoan;
    Button btnChoiGame;
    Button btnHuongDan;
    Button btnDiemCao;
     Button btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        btnTaiKhoan = (Button) findViewById(R.id.btnTaiKhoan);
        btnChoiGame = (Button) findViewById(R.id.btnChoiGame);
        btnHuongDan = (Button) findViewById(R.id.btnHuongDan);
        btnDiemCao = (Button) findViewById(R.id.btnDiemCao);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManHinhChinhActivity.this,QuanLyTaiKhoanActivity.class));
            }
        });
        btnHuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManHinhChinhActivity.this,HuongDanActivity.class));
            }
        });
        btnDiemCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(ManHinhChinhActivity.this,DiemCaoActivity.class));
            }
        });
        btnChoiGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManHinhChinhActivity.this,ChoiGameActivity.class));
            }
        });
    }
}
