package com.google.filestonghop;

public class ThietBi {
    private String name;

    private String gia;
    private int hinh;

    public ThietBi(String name,  String gia, int hinh) {
        this.name = name;

        this.gia = gia;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setTenmon(String name) {
        this.name = name;
    }



    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
