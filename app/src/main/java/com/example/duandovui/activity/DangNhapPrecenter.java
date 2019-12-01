package com.example.duandovui.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

import static com.example.duandovui.sharehelper.Share.USER;

public class DangNhapPrecenter {
    DangNhapInterface itf;
    Context context;
    MyDatabase myDatabase;
    public DangNhapPrecenter(
            DangNhapInterface itf,Context context
    ){
        this.context = context;
        this.itf = itf;
    }
    void login(String us ,String pw){

        if (us.isEmpty()){
            itf.checkus();
        }
        else if(pw.isEmpty()){
            itf.checkpass();
        }
        else {
            myDatabase = new MyDatabase(context);

            NguoiDung nguoiDung = new NguoiDung(us,pw);
            boolean result = myDatabase.islogin(nguoiDung);
            if (result) {
                itf.login();
            } else {
               itf.loginfalse();
            }
            }
        }
    }


