package com.example.duandovui.activity;

import android.content.Context;

import com.example.duandovui.database.MyDatabase;
import com.example.duandovui.model.NguoiDung;

public class ThemtkPresenter {
    ThemtkInterface itf ;
    MyDatabase myDatabase;
    NguoiDung nguoiDung;
    Context context;
    public  ThemtkPresenter(ThemtkInterface itf,Context context){
        this.itf = itf;
        this.context = context;
    }
    void them(String tk,String mk) {
        myDatabase = new MyDatabase(context);
        if (tk.isEmpty()) {
            itf.Checktknull();
        } else if (mk.isEmpty()) {
            itf.Checkmknull();
        } else {
            nguoiDung = new NguoiDung(tk, mk);
            if (myDatabase.insertnguoidung(nguoiDung)) {
                itf.inserttrue();
            } else {
                itf.insertffalse();
            }
        }
    }
}
