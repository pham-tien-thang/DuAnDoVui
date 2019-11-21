package com.example.duandovui.model;

public class CauHoi {
    String noidung;
    String dapandung;
    String dapan2;
    String dapan3;
    String dapan4;




    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getDapandung() {
        return dapandung;
    }

    public void setDapandung(String dapandung) {
        this.dapandung = dapandung;
    }

    public String getDapan2() {
        return dapan2;
    }

    public void setDapan2(String dapan2) {
        this.dapan2 = dapan2;
    }

    public String getDapan3() {
        return dapan3;
    }

    public void setDapan3(String dapan3) {
        this.dapan3 = dapan3;
    }

    public String getDapan4() {
        return dapan4;
    }

    public void setDapan4(String dapan4) {
        this.dapan4 = dapan4;
    }

    public CauHoi( String noidung, String dapandung, String dapan2, String dapan3, String dapan4) {

        this.noidung = noidung;
        this.dapandung = dapandung;
        this.dapan2 = dapan2;
        this.dapan3 = dapan3;
        this.dapan4 = dapan4;
    }

    public CauHoi() {
    }


}


