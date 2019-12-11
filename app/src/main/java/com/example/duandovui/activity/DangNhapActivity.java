package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duandovui.R;

import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.databinding.ActivityDangNhapBinding;
import com.example.duandovui.model.NguoiDung;
import com.example.duandovui.model.NguoiDung;
import  static com.example.duandovui.sharehelper.Share.*;
public class DangNhapActivity extends AppCompatActivity implements  DangNhapInterface {

    Button btnDangNhap;
DangNhapPrecenter pre;

ActivityDangNhapBinding dangNhapBinding;
NguoiDung nd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dang_nhap);
dangNhapBinding = DataBindingUtil.setContentView(DangNhapActivity.this, R.layout.activity_dang_nhap);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
pre = new DangNhapPrecenter(this,this);
        nd = new NguoiDung("","");
        dangNhapBinding.setUser(nd);
       btnDangNhap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               pre.login(dangNhapBinding.getUser().getUsername(),dangNhapBinding.getUser().getPassword());
           }
       });
    }


    @Override
    public void login() {

                Toast.makeText(getApplicationContext(), "Đã đăng nhập", Toast.LENGTH_SHORT).show();
                USER = dangNhapBinding.getUser().getUsername();
                PASSWORD = dangNhapBinding.getUser().getPassword();
                Intent intent = new Intent(DangNhapActivity.this, ManHinhChinhActivity.class);
                startActivity(intent);


    }

    @Override
    public void checkus() {
        dangNhapBinding.edtUser.setError("nhập tài khoản");
    }

    @Override
    public void checkpass() {
        dangNhapBinding.edtpassword.setError("nhập mật khẩu");
    }

    @Override
    public void loginfalse() {

                Toast.makeText(getApplicationContext(), "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_LONG).show();
    }
}
