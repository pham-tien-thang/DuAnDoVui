package com.example.duandovui.activity;

import android.content.Context;

import com.example.duandovui.database.MyDatabase;
import static com.example.duandovui.sharehelper.Share.*;
public class DoiMatKhauPresenter {

        DoimatkhauInterface itf;
        Context context;
        MyDatabase myDatabase;
        public DoiMatKhauPresenter(
                DoimatkhauInterface itf,Context context
        ){
            this.context = context;
            this.itf = itf;
        }

        void dmk(String mkcu, String mkmoi){
            myDatabase = new MyDatabase(context);
            myDatabase.openDataBase();
            if (mkcu.isEmpty()){
                itf.checkMkCuRong();
            }
            else if (mkmoi.isEmpty()){
                itf.checkMkMoiRong();
            }
            else if (!mkcu.equals(PASSWORD)){
                itf.checkSaiMkCu();
            }
            else if (mkmoi.equals(mkcu)){
                itf.checkTrungMatKhau();
            }
            else {
                if (myDatabase.updatematkhau(USER,mkmoi)){
                    itf.doithanhcong();
                }
                else {
                    itf.doithatbai();
                }
            }
        }
}
