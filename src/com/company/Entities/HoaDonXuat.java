package com.company.Entities;

public class HoaDonXuat {
    //Khai báo thuộc tính
    private String maHD,maNV,thoiGian,maKH;

    public HoaDonXuat() {

    }

    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maHD+"#"+maNV+"#"+thoiGian+"#"+maKH;
    }
    //Hàm set/get
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    //Phương thức khởi tạo
    public HoaDonXuat(String maHD, String maNV, String thoiGian, String maKH) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.thoiGian = thoiGian;
        this.maKH = maKH;
    }
}
