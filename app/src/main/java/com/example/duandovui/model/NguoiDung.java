package com.example.duandovui.model;

public class NguoiDung {
    String username;
    String password;
    int diemcao;

    public NguoiDung(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDiemcao() {
        return diemcao;
    }

    public void setDiemcao(int diemcao) {
        this.diemcao = diemcao;
    }

    public NguoiDung() {
    }

    public NguoiDung(String username, String password, int diemcao) {
        this.username = username;
        this.password = password;
        this.diemcao = diemcao;
    }
}
