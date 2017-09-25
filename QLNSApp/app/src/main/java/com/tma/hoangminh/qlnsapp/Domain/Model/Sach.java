package com.tma.hoangminh.qlnsapp.Domain.Model;

public class Sach {
    String masach, tensach, matheloai, anhbia, mota, nhaxuatban, tacgia, ngayxuatban;
    int dongiaban, luotmua, khuyenmai, soluongton, delflag;
    Boolean tinhtrang;

    public Sach() {

    }

    public Sach(String masach, String tensach, String matheloai, String anhbia, String mota, String nhaxuatban, String tacgia, String ngayxuatban, int dongiaban, int luotmua, int khuyenmai, int soluongton, int delflag, Boolean tinhtrang) {
        this.masach = masach;
        this.tensach = tensach;
        this.matheloai = matheloai;
        this.anhbia = anhbia;
        this.mota = mota;
        this.nhaxuatban = nhaxuatban;
        this.tacgia = tacgia;
        this.ngayxuatban = ngayxuatban;
        this.dongiaban = dongiaban;
        this.luotmua = luotmua;
        this.khuyenmai = khuyenmai;
        this.soluongton = soluongton;
        this.delflag = delflag;
        this.tinhtrang = tinhtrang;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getAnhbia() {
        return anhbia;
    }

    public void setAnhbia(String anhbia) {
        this.anhbia = anhbia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNgayxuatban() {
        return ngayxuatban;
    }

    public void setNgayxuatban(String ngayxuatban) {
        this.ngayxuatban = ngayxuatban;
    }

    public int getDongiaban() {
        return dongiaban;
    }

    public void setDongiaban(int dongiaban) {
        this.dongiaban = dongiaban;
    }

    public int getLuotmua() {
        return luotmua;
    }

    public void setLuotmua(int luotmua) {
        this.luotmua = luotmua;
    }

    public int getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(int khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
