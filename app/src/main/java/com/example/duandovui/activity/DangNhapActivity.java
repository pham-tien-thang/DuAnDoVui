package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.duandovui.R;

public class DangNhapActivity extends AppCompatActivity {
     EditText edtUser;
    EditText edtpassword;
    Button btnDangNhap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dang_nhap);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
       btnDangNhap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity( new Intent(DangNhapActivity.this,ManHinhChinhActivity.class));
           }
       });
    }
}
