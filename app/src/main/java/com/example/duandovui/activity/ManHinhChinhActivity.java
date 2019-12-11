package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duandovui.R;
import com.example.duandovui.databinding.ActivityManHinhChinhBinding;

public class ManHinhChinhActivity extends AppCompatActivity implements ManHinhchinhInterface {
     Button btnTaiKhoan;
    Button btnChoiGame;
    Button btnHuongDan;
    Button btnDiemCao;
     Button btnThoat;
ActivityManHinhChinhBinding manHinhChinhBinding;
ManHinhChinhPrecenter pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        manHinhChinhBinding = DataBindingUtil.setContentView(ManHinhChinhActivity.this, R.layout.activity_man_hinh_chinh);
        pre = new ManHinhChinhPrecenter(this);
        btnTaiKhoan = (Button) findViewById(R.id.btnTaiKhoan);
        btnChoiGame = (Button) findViewById(R.id.btnChoiGame);
        btnHuongDan = (Button) findViewById(R.id.btnHuongDan);
        btnDiemCao = (Button) findViewById(R.id.btnDiemCao);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               pre.toThoat();
            }
        });
        btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre.toTaikhoan();
            }
        });
        btnHuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre.toHuongDan();
            }
        });
        btnDiemCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre.toDiemCao();
            }
        });
        btnChoiGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              pre.toChoiGame();
            }
        });
    }

    @Override
    public void toTaiKhoan() {
        startActivity(new Intent(ManHinhChinhActivity.this,QuanLyTaiKhoanActivity.class));
    }

    @Override
    public void toChoiGame() {
        startActivity(new Intent(ManHinhChinhActivity.this,ChoiGameActivity.class));
    }

    @Override
    public void tohuongdan() {
        startActivity(new Intent(ManHinhChinhActivity.this,HuongDanActivity.class));
    }

    @Override
    public void toDiemcao() {
        startActivity( new Intent(ManHinhChinhActivity.this,DiemCaoActivity.class));
    }

    @Override
    public void toThoat() {
        finish();
    }
}
