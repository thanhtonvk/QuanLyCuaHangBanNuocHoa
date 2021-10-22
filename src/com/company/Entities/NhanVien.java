package com.company.Entities;

public class NhanVien {
    //Khai báo thuộc tính
    private String maNV,hoTen,cMND,namSinh,gioiTinh,sDT,chucVu;

    public NhanVien() {

    }

    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maNV+"#"+hoTen+"#"+cMND+"#"+namSinh+"#"+gioiTinh+"#"+sDT+"#"+chucVu;
    }
    //Hàm set/get
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    //Phương thức khởi tạo
    public NhanVien(String maNV, String hoTen, String cMND, String namSinh, String gioiTinh, String sDT, String chucVu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.cMND = cMND;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.sDT = sDT;
        this.chucVu = chucVu;
    }
}
