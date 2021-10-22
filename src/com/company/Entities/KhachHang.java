package com.company.Entities;

public class KhachHang {
    //Khai báo thuộc tính
    private String maKH,hoTen,diaChi,sDT,cMND;
    private int soLanGheTham;
    private int capDo;
    //Hàm set/get
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }

    public int getSoLanGheTham() {
        return soLanGheTham;
    }

    public void setSoLanGheTham(int soLanGheTham) {
        this.soLanGheTham = soLanGheTham;
    }

    public int getCapDo() {
        return capDo;
    }

    public void setCapDo(int capDo) {
        this.capDo = capDo;
    }
    //Phương thức khởi tạo
    public KhachHang(String maKH, String hoTen, String diaChi, String sDT, String cMND, int soLanGheTham, int capDo) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.cMND = cMND;
        this.soLanGheTham = soLanGheTham;
        this.capDo = capDo;
    }
    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maKH+"#"+hoTen+"#"+diaChi+"#"+sDT+"#"+cMND+"#"+soLanGheTham+"#"+capDo;
    }
}
