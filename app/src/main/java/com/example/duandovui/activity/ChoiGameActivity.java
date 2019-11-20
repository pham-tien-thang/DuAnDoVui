package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duandovui.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
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
    }
}
