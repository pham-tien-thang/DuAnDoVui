package com.example.duandovui.activity;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duandovui.R;
import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.CauHoi;
import com.example.duandovui.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChoiGameActivity extends AppCompatActivity {
     TextView tvDiem;
    TextView tvCuuTro;
     TextView tv50;
    TextView tvDoiCauHoi;
     TextView tvSoCauHoi;
  LinearLayout linearLayout;
    TextView tvCauHoi;
     TextView tvA;
    TextView tvB;
    TextView tvC;
    TextView tvD;
    int socauhoi=0;
    int number;
    public  List<CauHoi> Listcauhoi = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
        MyDatabase myDatabase = new MyDatabase(ChoiGameActivity.this);
        myDatabase.createDataBase();
        myDatabase.openDataBase();
        Listcauhoi=myDatabase.laycauhoi();
        tvDiem = (TextView) findViewById(R.id.tvDiem);
        tvCuuTro = (TextView) findViewById(R.id.tvCuuTro);
        tv50 = (TextView) findViewById(R.id.tv50);
        tvDoiCauHoi = (TextView) findViewById(R.id.tvDoiCauHoi);
        tvSoCauHoi = (TextView) findViewById(R.id.tvSoCauHoi);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        tvCauHoi = (TextView) findViewById(R.id.tvCauHoi);
        tvA = (TextView) findViewById(R.id.tvA);
        tvB = (TextView) findViewById(R.id.tvB);
        tvC = (TextView) findViewById(R.id.tvC);
        tvD = (TextView) findViewById(R.id.tvD);
   hienthi();
   tvA.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           tvA.setBackgroundColor(getResources().getColor(R.color.xam));
           tvB.setBackgroundColor(getResources().getColor(R.color.trang));
           tvD.setBackgroundColor(getResources().getColor(R.color.trang));
           tvC.setBackgroundColor(getResources().getColor(R.color.trang));
           if(tvA.getText().equals(Listcauhoi.get(number).getDapandung())){
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       hienthi();
                   }
               }, 500);
           }
       }
   });
        tvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvB.setBackgroundColor(getResources().getColor(R.color.xam));
                tvA.setBackgroundColor(getResources().getColor(R.color.trang));
                tvD.setBackgroundColor(getResources().getColor(R.color.trang));
                tvC.setBackgroundColor(getResources().getColor(R.color.trang));
                if(tvB.getText().equals(Listcauhoi.get(number).getDapandung())){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hienthi();
                        }
                    }, 500);
                }
            }
        });
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvB.setBackgroundColor(getResources().getColor(R.color.trang));
                tvA.setBackgroundColor(getResources().getColor(R.color.trang));
                tvD.setBackgroundColor(getResources().getColor(R.color.trang));
                tvC.setBackgroundColor(getResources().getColor(R.color.xam));
                if(tvC.getText().equals(Listcauhoi.get(number).getDapandung())){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hienthi();
                        }
                    }, 500);

                }
            }
        });
        tvD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvB.setBackgroundColor(getResources().getColor(R.color.trang));
                tvA.setBackgroundColor(getResources().getColor(R.color.trang));
                tvC.setBackgroundColor(getResources().getColor(R.color.trang));
                tvD.setBackgroundColor(getResources().getColor(R.color.xam));
                if(tvD.getText().equals(Listcauhoi.get(number).getDapandung())){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hienthi();
                        }
                    }, 500);
                }
            }
        });
    }
    public  void  hienthi(){
        socauhoi++;
        Random rd = new Random();   // khai báo 1 đối tượng Random
         number = rd.nextInt(50);
        Random rd2 = new Random();   // khai báo 1 đối tượng Random
        int number2 = rd.nextInt(4)+1;
        tvSoCauHoi.setText("Câu số :"+socauhoi);
        tvDiem.setText(socauhoi+"");
        tvCauHoi.setText(Listcauhoi.get(number).getNoidung());
        tvB.setBackgroundColor(getResources().getColor(R.color.trang));
        tvA.setBackgroundColor(getResources().getColor(R.color.trang));
        tvD.setBackgroundColor(getResources().getColor(R.color.trang));
        tvC.setBackgroundColor(getResources().getColor(R.color.trang));
        if(number2==1){
            tvA.setText(Listcauhoi.get(number).getDapandung());
            tvB.setText(Listcauhoi.get(number).getDapan2());
            tvC.setText(Listcauhoi.get(number).getDapan3());
            tvD.setText(Listcauhoi.get(number).getDapan4());
        }
        else if (number2==2){
            tvA.setText(Listcauhoi.get(number).getDapan2());
            tvB.setText(Listcauhoi.get(number).getDapandung());
            tvC.setText(Listcauhoi.get(number).getDapan4());
            tvD.setText(Listcauhoi.get(number).getDapan3());
        }
        else if (number2==3){
            tvA.setText(Listcauhoi.get(number).getDapan2());
            tvB.setText(Listcauhoi.get(number).getDapan3());
            tvC.setText(Listcauhoi.get(number).getDapandung());
            tvD.setText(Listcauhoi.get(number).getDapan4());
        }
        else if (number2==4){
            tvA.setText(Listcauhoi.get(number).getDapan2());
            tvB.setText(Listcauhoi.get(number).getDapan3());
            tvC.setText(Listcauhoi.get(number).getDapan4());
            tvD.setText(Listcauhoi.get(number).getDapandung());
        }

    }
}
