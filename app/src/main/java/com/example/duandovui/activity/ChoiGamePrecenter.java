package com.example.duandovui.activity;
import static com.example.duandovui.activity.ChoiGameActivity.*;
import android.os.Handler;
import android.widget.Toast;

import java.util.Random;

public class ChoiGamePrecenter {
    ChoiGameInterface itf;
    public ChoiGamePrecenter (ChoiGameInterface itf){
        this.itf = itf;
    }
    void showcuutro(){
        itf.showtrogiup3();
    }
    void cuutro1(){
        if (trogiup1>0){
            Boolean chonnv = false;
            trogiup1--;
            itf.showtrogiup3();
        }
        else {
            itf.hettrogiup1();
        }
    }
    void trogiup2(String a,String b,String c,String d, String dapandung){
        if (trogiup2>0) {
            trogiup2--;
            if (a.equals(dapandung)){
                Random rd50 = new Random();   // khai báo 1 đối tượng Random
                int random50 = rd50.nextInt(3)+1;
                if(random50==1){
                    itf.XoaBC();
                }
                else if(random50==2){
                   itf.XoaBD();
                }
                else if(random50==3){
                   itf.XoaDC();
                }
            }
            else if (b.equals(dapandung)){
                Random rd50 = new Random();   // khai báo 1 đối tượng Random
                int random50 = rd50.nextInt(3)+1;
                if(random50==1){
                    itf.XoaAC();
                }
                else if(random50==2){
                    itf.XoaAD();
                }
                else if(random50==3){
                    itf.XoaDC();
                }
            }
            else if (c.equals(dapandung)){
                Random rd50 = new Random();   // khai báo 1 đối tượng Random
                int random50 = rd50.nextInt(3)+1;
                if(random50==1){
                    itf.xoaAB();
                }
                else if(random50==2){
                    itf.XoaAD();
                }
                else if(random50==3){
                    itf.XoaBD();
                }
            }
            else if (d.equals(dapandung)){
                Random rd50 = new Random();   // khai báo 1 đối tượng Random
                int random50 = rd50.nextInt(3)+1;
                if(random50==1){
                    itf.xoaAB();
                }
                else if(random50==2){
                    itf.XoaAC();
                }
                else if(random50==3){
                    itf.XoaBC();
                }
            }
        }
        else {
            itf.hettrogiup2();
        }


    }

    void doicauhoi(){
        if (trogiup3>0){
            trogiup3--;
            itf.trogiup3();
           hienthi();
        }
        else {
            itf.hettrogiup3();
        }
    }
void hienthi(){
        itf.hienthi();
}
void viewclick(String abcd,String dapanchon, String dapandung){
if (abcd.equals("a")){
        itf.setbackgroundA();}
else if (abcd.equals("b")){
    itf.setbackgroundb();
}
else if (abcd.equals("c")){
    itf.setbackgroundc();

}
else if (abcd.equals("d")){
    itf.setbackgroundd();
}
    if(dapanchon.equals(dapandung)){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hienthi();
            }
        }, 500);
    }
    else{
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (somang>0){
                    somang--;
                    itf.showfalse();}
                else {itf.showgameover();}
            }
        }, 500);
    }
}
}
