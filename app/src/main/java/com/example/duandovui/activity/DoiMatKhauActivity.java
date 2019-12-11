package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.databinding.ActivityDoiMatKhauBinding;

import  static  com.example.duandovui.sharehelper.Share.*;
public class DoiMatKhauActivity extends AppCompatActivity implements  DoimatkhauInterface{
     Button btnluu;
    MyDatabase myDatabase;
    DoiMatKhauPresenter pre;
    ActivityDoiMatKhauBinding doiMatKhauBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        doiMatKhauBinding = DataBindingUtil.setContentView(DoiMatKhauActivity.this, R.layout.activity_doi_mat_khau);
        myDatabase = new MyDatabase(this);
        pre = new DoiMatKhauPresenter(this,this);
        btnluu = (Button) findViewById(R.id.btnluu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
pre.dmk(doiMatKhauBinding.edtMkCu.getText().toString(),doiMatKhauBinding.edtMkMoi.getText().toString());
            }
        });
    }

    @Override
    public void checkMkCuRong() {
        doiMatKhauBinding.edtMkCu.setError("Mật khẩu cũ rỗng");
    }

    @Override
    public void checkMkMoiRong() {
        doiMatKhauBinding.edtMkMoi.setError("mật khảu mới rỗng");
    }

    @Override
    public void checkSaiMkCu() {
        doiMatKhauBinding.edtMkCu.setError("Mật khẩu cũ không đúng");
    }

    @Override
    public void checkTrungMatKhau() {
        doiMatKhauBinding.edtMkMoi.setError("Không được trùng");
    }

    @Override
    public void doithanhcong() {
        Toast.makeText(getApplicationContext(),"Mật khẩu mới là: "+doiMatKhauBinding.edtMkMoi.getText().toString(),Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void doithatbai() {
        Toast.makeText(getApplicationContext(),"lỗi",Toast.LENGTH_SHORT).show();
    }
}
