package com.tma.hoangminh.qlnsapp.Domain.Model;

public class KhachHang {
    String makh, tenkh, diachi, sodienthoai, email, matkhaukh;

    public KhachHang(String makh, String tenkh, String diachi, String sodienthoai, String email, String matkhaukh) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.matkhaukh = matkhaukh;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhaukh() {
        return matkhaukh;
    }

    public void setMatkhaukh(String matkhaukh) {
        this.matkhaukh = matkhaukh;
    }
}
