package com.example.duandovui.activity;

public class ChoiGamePrecenter {
    ChoiGameInterface itf;
    public ChoiGamePrecenter (ChoiGameInterface itf){
        this.itf = itf;
    }
    void showcuutro(){
        itf.showtrogiup3();
    }
    void cuutro1(){
        itf.trogiup1();
    }
    void trogiup2(){
        itf.trogiup2();
    }
    void doicauhoi(){
        itf.trogiup3();
    }
void showover(){
        itf.showgameover();
}
void showfalse(){
        itf.showfalse();
}
void hienthi(){
        itf.hienthi();
}
}
