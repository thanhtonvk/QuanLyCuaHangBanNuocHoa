package com.company.Entities;

public class Kho {
    //Khai báo thuộc tính
    private String maKho,viTri,tinhTrang,maNV;

    public Kho() {

    }

    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maKho+"#"+viTri+"#"+tinhTrang+"#"+maNV;
    }

    //Hàm set/get
    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    //Phương thức khởi tạo
    public Kho(String maKho, String viTri, String tinhTrang, String maNV) {
        this.maKho = maKho;
        this.viTri = viTri;
        this.tinhTrang = tinhTrang;
        this.maNV = maNV;
    }
}
