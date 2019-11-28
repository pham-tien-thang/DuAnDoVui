package com.example.duandovui.activity;

public class ManHinhChinhPrecenter {
    ManHinhchinhInterface itf;
    public ManHinhChinhPrecenter(ManHinhchinhInterface itf){
        this.itf = itf;
    }
    void toThoat(){
        itf.toThoat();
    }
    void toTaikhoan(){
        itf.toTaiKhoan();
    }
    void toChoiGame(){
        itf.toChoiGame();
    }
    void  toHuongDan(){
        itf.tohuongdan();
    }
    void toDiemCao(){
        itf.toDiemcao();
    }
}
