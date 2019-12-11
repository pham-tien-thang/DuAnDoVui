package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.databinding.ActivityMainBinding;
import com.example.duandovui.model.NguoiDung;

import java.util.Random;

public class ChaoActivity extends AppCompatActivity implements Chaointerface {
Chaoprecenter chaoprecenter;
ActivityMainBinding mainBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
chaoprecenter = new Chaoprecenter(this);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(ChaoActivity.this, R.layout.activity_main);
chaoprecenter.chuyenmh();


    }

    @Override
    public void toMhchinh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new
                        Intent(getApplicationContext(), DangNhapActivity.class));
                finish();
            }
        }, 1500);

    }

    @Override
    public void dataBase() {
        MyDatabase myDatabase = new MyDatabase(ChaoActivity.this);
        myDatabase.createDataBase();
        myDatabase.taobang();
        if(myDatabase.getAllNguoiDung().size()<1){
            NguoiDung nd = new NguoiDung("thắng","1",999999);
            myDatabase.insertnguoidung(nd);
        }
        else {}
    }
}
