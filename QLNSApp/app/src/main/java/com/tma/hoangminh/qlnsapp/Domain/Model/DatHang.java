package com.tma.hoangminh.qlnsapp.Domain.Model;

public class DatHang {
    String madathang, makh, sdt, diachi, ngaydat, ngaygiao;
    int tongdonhang;
    boolean tinhtrang;

    public DatHang() {
    }

    public DatHang(String madathang, String makh, String sdt, String diachi, String ngaydat, String ngaygiao, int tongdonhang, boolean tinhtrang) {
        this.madathang = madathang;
        this.makh = makh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ngaydat = ngaydat;
        this.ngaygiao = ngaygiao;
        this.tongdonhang = tongdonhang;
        this.tinhtrang = tinhtrang;
    }

    public String getMadathang() {
        return madathang;
    }

    public void setMadathang(String madathang) {
        this.madathang = madathang;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(String ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public int getTongdonhang() {
        return tongdonhang;
    }

    public void setTongdonhang(int tongdonhang) {
        this.tongdonhang = tongdonhang;
    }

    public boolean isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
