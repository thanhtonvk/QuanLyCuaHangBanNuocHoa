package com.company.Entities;

public class HoaDonNhap {
    //Khai báo thuộc tính
    private String maHDN, maKho,tenNCC,diaChiNCC, SDT,ngayNhap,maNV;
    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maHDN+"#"+maKho+"#"+tenNCC+"#"+diaChiNCC+"#"+SDT+"#"+ngayNhap+"#"+maNV;
    }
    //Hàm set/get
    public String getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(String maHDN) {
        this.maHDN = maHDN;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }

    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    //Phương thức khởi tạo
    public HoaDonNhap(String maHDN, String maKho, String tenNCC, String diaChiNCC, String SDT, String ngayNhap, String maNV) {
        this.maHDN = maHDN;
        this.maKho = maKho;
        this.tenNCC = tenNCC;
        this.diaChiNCC = diaChiNCC;
        this.SDT = SDT;
        this.ngayNhap = ngayNhap;
        this.maNV = maNV;
    }
}
