package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duandovui.R;

import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;
import com.example.duandovui.model.NguoiDung;
import  static com.example.duandovui.sharehelper.Share.USER;
public class DangNhapActivity extends AppCompatActivity implements  DangNhapInterface {
     EditText edtUser;
    EditText edtpassword;
    Button btnDangNhap;
DangNhapPrecenter pre;
String username;
String password;
MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dang_nhap);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
pre = new DangNhapPrecenter(this);
       btnDangNhap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              pre.login();
           }
       });
    }


    @Override
    public void login() {
        myDatabase = new MyDatabase(this);
        username = edtUser.getText().toString();
        password = edtpassword.getText().toString();
        if (username.isEmpty()){
            edtUser.setError("nhập tài khoản");
        }
        else if(password.isEmpty()){
            edtpassword.setError("nhập mật khẩu");
        }
        else {
            NguoiDung nguoiDung = new NguoiDung(username, password);
            boolean result = myDatabase.islogin(nguoiDung);
            if (result) {
                Toast.makeText(getApplicationContext(), "Đã đăng nhập", Toast.LENGTH_SHORT).show();
                USER = username;
                Intent intent = new Intent(DangNhapActivity.this, ManHinhChinhActivity.class);
                startActivity(intent);
            } else {
                startActivity(new Intent(DangNhapActivity.this, ManHinhChinhActivity.class));
                Toast.makeText(getApplicationContext(), "Nhập sai - nhưng vẫn cho vào :))", Toast.LENGTH_LONG).show();
            }
        }
    }
}
