package com.example.duandovui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.duandovui.R;

public class ThemTKActivity extends AppCompatActivity {
     EditText edtThemtk;
   EditText edtThemmk;
   Button btnluu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tk);
        edtThemtk = (EditText) findViewById(R.id.edtThemtk);
        edtThemmk = (EditText) findViewById(R.id.edtThemmk);
        btnluu = (Button) findViewById(R.id.btnluu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
