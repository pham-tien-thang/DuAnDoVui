package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.duandovui.R;
import com.example.duandovui.adapter.NguoiDungAdapter;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTaiKhoanActivity extends AppCompatActivity {
   ListView lvTaiKhoan;
   Button btnThoat;
NguoiDungAdapter nguoiDungAdapter;
MyDatabase myDatabase;
List<NguoiDung> listnguoidung = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tài khoản");
        setContentView(R.layout.activity_quan_ly_tai_khoan);
        lvTaiKhoan = (ListView) findViewById(R.id.lvTaiKhoan);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        myDatabase = new MyDatabase(this);
       listnguoidung=  myDatabase.getAllNguoiDung();
        nguoiDungAdapter = new NguoiDungAdapter(this,R.layout.item_nguoi_dung,listnguoidung);
        lvTaiKhoan.setAdapter(nguoiDungAdapter);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        listnguoidung.clear();
        listnguoidung.addAll(myDatabase.getAllNguoiDung());
        nguoiDungAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menutk, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemthem:
                Intent it = new Intent(this, ThemTKActivity.class);
                startActivity(it);
                break;
            case R.id.itemdoimatkhau:
                Intent it2 = new Intent(this, DoiMatKhauActivity.class);
                startActivity(it2);
                break;
            case R.id.itemdangxuat:
                Intent it3 = new Intent(this, DangNhapActivity.class);
                startActivity(it3);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
