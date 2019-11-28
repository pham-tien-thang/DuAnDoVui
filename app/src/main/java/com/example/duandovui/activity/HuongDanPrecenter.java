package com.example.duandovui.activity;

public class HuongDanPrecenter {
    HuongDanInterface itf;
    public HuongDanPrecenter(
            HuongDanInterface itf
    ){
        this.itf =itf;
    }
    void  prethoat(){
        itf.thoat();
    }
}
