package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.duandovui.R;
import com.example.duandovui.dao.NguoiDungDao;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

public class ChaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyDatabase myDatabase = new MyDatabase(ChaoActivity.this);
        myDatabase.createDataBase();
        myDatabase.taobang();
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new
                        Intent(getApplicationContext(), DangNhapActivity.class));
                finish();
            }
        }, 1500);
        if(myDatabase.getAllNguoiDung().size()<1){
            NguoiDung nd = new NguoiDung("thắng","1",999999);
            myDatabase.insertnguoidung(nd);
        }
        else {}

    }
}
