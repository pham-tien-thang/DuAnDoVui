package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.duandovui.R;
import com.example.duandovui.adapter.DiemCaoAdapter;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class DiemCaoActivity extends AppCompatActivity {
  ListView lvDiemCao;
     Button btnThoat;
MyDatabase myDatabase;
DiemCaoAdapter diemCaoAdapter;
List<NguoiDung> listop = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_cao);
        lvDiemCao = (ListView) findViewById(R.id.lvDiemCao);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        myDatabase = new MyDatabase(this);
        listop = myDatabase.getTopNguoiDung();
        Log.d("ssas",listop.size()+"");
        diemCaoAdapter = new DiemCaoAdapter(this,R.layout.item_diem_cao,listop);
        lvDiemCao.setAdapter(diemCaoAdapter);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
