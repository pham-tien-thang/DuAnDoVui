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

public class QuanLyTaiKhoanActivity extends AppCompatActivity {
   ListView lvTaiKhoan;
   Button btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tài khoản");
        setContentView(R.layout.activity_quan_ly_tai_khoan);
        lvTaiKhoan = (ListView) findViewById(R.id.lvTaiKhoan);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();
            }
        });
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
