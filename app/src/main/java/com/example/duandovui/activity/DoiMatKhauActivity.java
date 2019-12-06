package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import  static  com.example.duandovui.sharehelper.Share.*;
public class DoiMatKhauActivity extends AppCompatActivity implements  DoimatkhauInterface{
     EditText edtMkCu;
     EditText edtMkMoi;
     Button btnluu;
    MyDatabase myDatabase;
    DoiMatKhauPresenter pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        myDatabase = new MyDatabase(this);
        edtMkCu = (EditText) findViewById(R.id.edtMkCu);
        edtMkMoi = (EditText) findViewById(R.id.edtMkMoi);
        pre = new DoiMatKhauPresenter(this,this);
        btnluu = (Button) findViewById(R.id.btnluu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
pre.dmk(edtMkCu.getText().toString(),edtMkMoi.getText().toString());
            }
        });
    }

    @Override
    public void checkMkCuRong() {
        edtMkCu.setError("Mật khẩu cũ rỗng");
    }

    @Override
    public void checkMkMoiRong() {
        edtMkMoi.setError("mật khảu mới rỗng");
    }

    @Override
    public void checkSaiMkCu() {
        edtMkCu.setError("Mật khẩu cũ không đúng");
    }

    @Override
    public void checkTrungMatKhau() {
        edtMkMoi.setError("Không được trùng");
    }

    @Override
    public void doithanhcong() {
        Toast.makeText(getApplicationContext(),"Mật khẩu mới là: "+edtMkMoi.getText().toString(),Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void doithatbai() {
        Toast.makeText(getApplicationContext(),"lỗi",Toast.LENGTH_SHORT).show();
    }
}
