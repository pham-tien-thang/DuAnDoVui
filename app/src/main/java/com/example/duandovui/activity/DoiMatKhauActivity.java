package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.duandovui.R;

public class DoiMatKhauActivity extends AppCompatActivity {
     EditText edtMkCu;
     EditText edtMkMoi;
     Button btnluu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        edtMkCu = (EditText) findViewById(R.id.edtMkCu);
        edtMkMoi = (EditText) findViewById(R.id.edtMkMoi);
        btnluu = (Button) findViewById(R.id.btnluu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
