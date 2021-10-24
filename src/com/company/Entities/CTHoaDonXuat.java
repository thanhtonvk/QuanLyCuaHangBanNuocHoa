package com.company.Entities;

public class CTHoaDonXuat {
    //Khai báo thuộc tính
    private String ctHDX,maHD,maNuocHoa;
    private int soLuong;

    public CTHoaDonXuat() {

    }

    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return ctHDX+"#"+maHD+"#"+maNuocHoa+"#"+soLuong;
    }
    //Hàm set/get
    public String getCtHDX() {
        return ctHDX;
    }

    public void setCtHDX(String ctHDX) {
        this.ctHDX = ctHDX;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNuocHoa() {
        return maNuocHoa;
    }

    public void setMaNuocHoa(String maNuocHoa) {
        this.maNuocHoa = maNuocHoa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    //Phương thức khởi tạo
    public CTHoaDonXuat(String ctHDX, String maHD, String maNuocHoa, int soLuong) {
        this.ctHDX = ctHDX;
        this.maHD = maHD;
        this.maNuocHoa = maNuocHoa;
        this.soLuong = soLuong;
    }
}
