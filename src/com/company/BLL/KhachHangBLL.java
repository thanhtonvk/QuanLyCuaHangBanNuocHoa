package com.company.BLL;

import com.company.DAL.KhachHangDAL;
import com.company.Entities.KhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhachHangBLL {
    List<KhachHang> khachHangList;
    KhachHangDAL khachHangDAL;
    Scanner scanner;

    public KhachHangBLL() {
        khachHangDAL = new KhachHangDAL();
        khachHangList = khachHangDAL.docDSKhachHang();
        scanner = new Scanner(System.in);
    }

    public KhachHang nhapKhachHang() {
        KhachHang khachHang = new KhachHang();
        System.out.print("Nhập mã khách hàng: ");
        khachHang.setMaKH(scanner.nextLine());
        System.out.print("Nhập họ tên: ");
        khachHang.setHoTen(scanner.nextLine());
        System.out.print("Nhập địa chỉ");
        khachHang.setDiaChi(scanner.nextLine());
        System.out.print("Nhập SĐT: ");
        khachHang.setsDT(scanner.nextLine());
        System.out.print("Nhập CMND: ");
        khachHang.setcMND(scanner.nextLine());
        return khachHang;
    }

    public void showKhachHang(KhachHang khachHang, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getDiaChi(), khachHang.getsDT(), khachHang.getcMND(), khachHang.getSoLanGheTham(), khachHang.getCapDo());
    }

    public void hienDSKhachHang() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã khách hàng", "Họ tên", "Địa chỉ", "SĐT", "CMND", "Số lần ghé thăm", "Cấp độ");
        for (KhachHang khachHang : khachHangList
        ) {
            showKhachHang(khachHang, khachHangList.indexOf(khachHang));
        }
    }

    public void themKhachHang() {
        while (true) {
            KhachHang khachHang = nhapKhachHang();
            khachHangList.add(khachHang);
            khachHangDAL.ghiFile(khachHangList);
            System.out.println("Bạn muốn nhập tiếp không?Y/N");
            String chon = scanner.nextLine();
            if (chon.equals("n") || chon.equals("N")) break;
        }
    }

    public List<KhachHang> timKhachHang(String tukhoa) {

        List<KhachHang> kq = new ArrayList<>();
        for (KhachHang khachHang : khachHangList
        ) {
            if (khachHang.getMaKH().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    khachHang.getHoTen().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    khachHang.getsDT().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    khachHang.getDiaChi().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    khachHang.getcMND().toLowerCase().contains(tukhoa.toLowerCase())) {
                kq.add(khachHang);
            }
        }
        if(kq.size()>0){
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã khách hàng", "Họ tên", "Địa chỉ", "SĐT", "CMND", "Số lần ghé thăm", "Cấp độ");
        }else{
            System.out.println("Không tìm thấy");
        }
        return kq;
    }

    public void capNhatThongTin() {
        hienDSKhachHang();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        KhachHang khachHang = khachHangList.get(chon);
        if (chon < 0 || chon > khachHangList.size() - 1) {
            System.out.println("Chọn khách hàng không hợp lệ");
        } else {
            System.out.print("Nhập họ tên: ");
            khachHang.setHoTen(scanner.nextLine());
            System.out.print("Nhập địa chỉ");
            khachHang.setDiaChi(scanner.nextLine());
            System.out.print("Nhập SĐT: ");
            khachHang.setsDT(scanner.nextLine());
            System.out.print("Nhập CMND: ");
            khachHang.setcMND(scanner.nextLine());
            khachHangList.set(chon, khachHang);
            System.out.println("Cập nhật thành công");
            khachHangDAL.ghiFile(khachHangList);
        }
    }
    public void xoaThongTin(){
        hienDSKhachHang();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        KhachHang khachHang = khachHangList.get(chon);
        if (chon < 0 || chon > khachHangList.size() - 1) {
            System.out.println("Chọn khách hàng không hợp lệ");
        } else {
            khachHangList.remove(chon);
            System.out.println("Xóa thành công");
            khachHangDAL.ghiFile(khachHangList);
        }
    }
    public KhachHang khachHang(String makh){
        KhachHang kh = null;
        for (KhachHang khachHang:khachHangList
             ) {
            if(khachHang.getMaKH().equalsIgnoreCase(makh)) kh = khachHang;
        }
        return kh;
    }
    public void updateSoLanDen(KhachHang khachHang,int i){
        khachHang.setSoLanGheTham(khachHang.getSoLanGheTham()+1);
        khachHangList.set(i,khachHang);
        khachHangDAL.ghiFile(khachHangList);
    }
}
