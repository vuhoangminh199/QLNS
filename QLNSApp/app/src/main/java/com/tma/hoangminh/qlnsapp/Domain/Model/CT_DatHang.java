package com.tma.hoangminh.qlnsapp.Domain.Model;

public class CT_DatHang {
    String madathang, masach, timedel;
    int soluongdat, dongia, thanhtien, delflag;

    public CT_DatHang(String madathang, String masach, String timedel, int soluongdat, int dongia, int thanhtien, int delflag) {
        this.madathang = madathang;
        this.masach = masach;
        this.timedel = timedel;
        this.soluongdat = soluongdat;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.delflag = delflag;
    }

    public String getMadathang() {
        return madathang;
    }

    public void setMadathang(String madathang) {
        this.madathang = madathang;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTimedel() {
        return timedel;
    }

    public void setTimedel(String timedel) {
        this.timedel = timedel;
    }

    public int getSoluongdat() {
        return soluongdat;
    }

    public void setSoluongdat(int soluongdat) {
        this.soluongdat = soluongdat;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }
}