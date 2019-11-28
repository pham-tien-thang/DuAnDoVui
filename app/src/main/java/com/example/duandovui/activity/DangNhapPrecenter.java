package com.example.duandovui.activity;

public class DangNhapPrecenter {
    DangNhapInterface itf;
    public DangNhapPrecenter(
            DangNhapInterface itf
    ){
        this.itf = itf;
    }
    void login(){
        itf.login();
    }
}
