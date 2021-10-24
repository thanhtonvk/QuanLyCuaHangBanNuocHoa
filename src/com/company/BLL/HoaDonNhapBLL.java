package com.company.BLL;

import com.company.DAL.HoaDonNhapDAL;
import com.company.Entities.CTHoaDonNhap;
import com.company.Entities.HoaDonNhap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDonNhapBLL {
    List<HoaDonNhap> hoaDonNhapList;
    HoaDonNhapDAL hoaDonNhapDAL;
    Scanner scanner;
    KhoBLL khoBLL;
    NhanVienBLL nhanVienBLL;
    CTHoaDonNhapBLL ctHoaDonNhapBLL;

    public HoaDonNhapBLL() {
        hoaDonNhapDAL = new HoaDonNhapDAL();
        hoaDonNhapList = hoaDonNhapDAL.docDSHoaDonNhap();
        khoBLL = new KhoBLL();
        ctHoaDonNhapBLL = new CTHoaDonNhapBLL();
        nhanVienBLL = new NhanVienBLL();
        scanner = new Scanner(System.in);
    }

    public HoaDonNhap nhapHoaDonNhap() {
        HoaDonNhap hoaDonNhap = new HoaDonNhap();
        System.out.print("Nhập mã hóa đơn: ");
        hoaDonNhap.setMaHDN(scanner.nextLine());
        khoBLL.hienDSKho();
        System.out.println("Chọn kho: ");
        int chonkho = Integer.parseInt(scanner.nextLine());
        hoaDonNhap.setMaKho(khoBLL.khoList.get(chonkho).getMaKho());
        System.out.print("Nhập tên nhà cung cấp: ");
        hoaDonNhap.setTenNCC(scanner.nextLine());
        System.out.print("Nhập địa chỉ nhà cung cấp");
        hoaDonNhap.setDiaChiNCC(scanner.nextLine());
        System.out.println("Nhập SĐT: ");
        hoaDonNhap.setSDT(scanner.nextLine());
        System.out.println("Nhập ngày nhập: ");
        hoaDonNhap.setNgayNhap(scanner.nextLine());
        nhanVienBLL.hienDSNhanVien();
        System.out.println("Chọn nhân viên: ");
        int chonnv = Integer.parseInt(scanner.nextLine());
        hoaDonNhap.setMaNV(nhanVienBLL.nhanVienList.get(chonnv).getMaNV());
        return hoaDonNhap;
    }

    public void showHoaDonNhap(HoaDonNhap hoaDonNhap, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, hoaDonNhap.getMaHDN(), hoaDonNhap.getMaKho(), hoaDonNhap.getTenNCC(), hoaDonNhap.getDiaChiNCC(), hoaDonNhap.getSDT(), hoaDonNhap.getNgayNhap(), hoaDonNhap.getMaNV());
    }

    public void hienDSHoaDonNhap() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã HDN", "Mã kho", "Tên NCC", "Địa chỉ NCC", "SĐT", "Ngày nhập", "Mã nhân viên");
        for (HoaDonNhap hoaDonNhap : hoaDonNhapList
        ) {
            showHoaDonNhap(hoaDonNhap, hoaDonNhapList.indexOf(hoaDonNhap));
        }
        System.out.println("Chọn hóa đơn muốn xem (Nhập -1 để bỏ qua): ");
        int chon = Integer.parseInt(scanner.nextLine());
        if (chon > -1) {
            HoaDonNhap hoaDonNhap = hoaDonNhapList.get(0);
            ctHoaDonNhapBLL.hienDSCtHoaDon(hoaDonNhap.getMaHDN());
        }
    }

    public void themHoaDonNhap() {
        HoaDonNhap hoaDonNhap = nhapHoaDonNhap();
        hoaDonNhapList.add(hoaDonNhap);
        hoaDonNhapDAL.ghiFile(hoaDonNhapList);
        ctHoaDonNhapBLL.nhapCTHoaDon(hoaDonNhap.getMaHDN());
        System.out.println("Thông tin hóa đơn");
        showHoaDonNhap(hoaDonNhap,0);
        List<CTHoaDonNhap>ctHoaDonNhapList = ctHoaDonNhapBLL.ctHoaDonNhapList(hoaDonNhap.getMaHDN());
        for (CTHoaDonNhap ctHoaDonNhap:ctHoaDonNhapList
             ) {
            ctHoaDonNhapBLL.showCtHoaDon(ctHoaDonNhap,ctHoaDonNhapList.indexOf(ctHoaDonNhap));
        }

    }

    public List<HoaDonNhap> timHoaDonNhap(String tukhoa) {

        List<HoaDonNhap> kq = new ArrayList<>();
        for (HoaDonNhap hoaDonNhap : hoaDonNhapList
        ) {
            if (hoaDonNhap.getMaHDN().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonNhap.getMaKho().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonNhap.getTenNCC().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonNhap.getDiaChiNCC().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonNhap.getMaNV().toLowerCase().contains(tukhoa.toLowerCase())) {
                kq.add(hoaDonNhap);
            }
        }
        if (kq.size() > 0) {
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã HDN", "Mã kho", "Tên NCC", "Địa chỉ NCC", "SĐT", "Ngày nhập", "Mã nhân viên");
        } else {
            System.out.println("Không tìm thấy");
        }
        return kq;
    }

    public HoaDonNhap hoaDonNhap(String mahdn) {
        HoaDonNhap hdn = null;
        for (HoaDonNhap hoaDonNhap : hoaDonNhapList
        ) {
            if (hoaDonNhap.getMaHDN().equalsIgnoreCase(mahdn)) hdn = hoaDonNhap;
        }
        return hdn;
    }

}
