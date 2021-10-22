package com.company.Entities;

public class NuocHoa {
    //Khai báo thuộc tính
    private String maNuocHoa;
    private String tenNuocHoa, loaiNuocHoa, xuatXu;
    private int soluong;
    private int giaBan;

    //Phương thức khởi tạo
    public NuocHoa(String maNuocHoa, String tenNuocHoa, String loaiNuocHoa, String xuatXu, int soluong, int giaBan) {
        this.maNuocHoa = maNuocHoa;
        this.tenNuocHoa = tenNuocHoa;
        this.loaiNuocHoa = loaiNuocHoa;
        this.xuatXu = xuatXu;
        this.soluong = soluong;
        this.giaBan = giaBan;
    }

    public NuocHoa() {

    }

    //Hàm set/get
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMaNuocHoa() {
        return maNuocHoa;
    }

    public void setMaNuocHoa(String maNuocHoa) {
        this.maNuocHoa = maNuocHoa;
    }

    public String getTenNuocHoa() {
        return tenNuocHoa;
    }

    public void setTenNuocHoa(String tenNuocHoa) {
        this.tenNuocHoa = tenNuocHoa;
    }

    public String getLoaiNuocHoa() {
        return loaiNuocHoa;
    }

    public void setLoaiNuocHoa(String loaiNuocHoa) {
        this.loaiNuocHoa = loaiNuocHoa;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    //Hàm toString phục vụ việc đọc ghi file,các thuộc tính cách nhau bới dấu #
    @Override
    public String toString() {
        return maNuocHoa + "#" + tenNuocHoa + "#" + loaiNuocHoa + "#" + xuatXu + "#" + soluong + "#" + giaBan;
    }
}
