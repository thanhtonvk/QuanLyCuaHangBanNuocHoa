package com.company.Entities;

public class CTHoaDonNhap {
    //Khai báo thuộc tính
    private String maCTHDN, maHDN, maNuocHoa;
    private int soLuong, giaNhap;

    public CTHoaDonNhap() {

    }

    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maCTHDN + "#" + maHDN + "#" + maNuocHoa + "#" + soLuong + "#" + giaNhap;
    }
    //Hàm set/get
    public String getMaCTHDN() {
        return maCTHDN;
    }

    public void setMaCTHDN(String maCTHDN) {
        this.maCTHDN = maCTHDN;
    }

    public String getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(String maHDN) {
        this.maHDN = maHDN;
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

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }
    //Phương thức khởi tạo
    public CTHoaDonNhap(String maCTHDN, String maHDN, String maNuocHoa, int soLuong, int giaNhap) {
        this.maCTHDN = maCTHDN;
        this.maHDN = maHDN;
        this.maNuocHoa = maNuocHoa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }
}
