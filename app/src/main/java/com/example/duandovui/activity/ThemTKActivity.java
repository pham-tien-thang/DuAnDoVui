package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.databinding.ActivityDangNhapBinding;
import com.example.duandovui.databinding.ActivityThemTkBinding;
import com.example.duandovui.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ThemTKActivity extends AppCompatActivity implements ThemtkInterface {
   Button btnluu;
 ActivityThemTkBinding themTkBinding ;
NguoiDung nguoiDung;
ThemtkPresenter pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tk);
        themTkBinding = DataBindingUtil.setContentView(ThemTKActivity.this, R.layout.activity_them_tk);
        btnluu = (Button) findViewById(R.id.btnluu);
        nguoiDung = new NguoiDung("","");
        themTkBinding.setUser(nguoiDung);
        pre = new ThemtkPresenter(this,this);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String tk =  themTkBinding.getUser().getUsername();
           String mk  = themTkBinding.getUser().getPassword();
               pre.them(tk,mk);


            }
        });
    }

    @Override
    public void inserttrue() {
        Toast.makeText(getApplicationContext(),"đã thêm",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void insertffalse() {
        Toast.makeText(getApplicationContext(),"chưa thêm",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Checktknull() {
        themTkBinding.edtThemtk.setError("không được để trống");
    }

    @Override
    public void Checkmknull() {
        themTkBinding.edtThemmk.setError("không được để trống");
    }
}
