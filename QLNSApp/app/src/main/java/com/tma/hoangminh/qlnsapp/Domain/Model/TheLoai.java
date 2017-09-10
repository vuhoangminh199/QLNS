package com.tma.hoangminh.qlnsapp.Domain.Model;

public class TheLoai {
    String matheloai;
    String tentheloai;

    public TheLoai(String matheloai, String tentheloai) {
        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }
}
