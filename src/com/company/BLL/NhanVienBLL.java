package com.company.BLL;

import com.company.DAL.NhanVienDAL;
import com.company.Entities.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienBLL {
    List<NhanVien> nhanVienList;
    NhanVienDAL nhanVienDAL;
    Scanner scanner;

    public NhanVienBLL() {
        nhanVienDAL = new NhanVienDAL();
        nhanVienList = nhanVienDAL.docDSNhanVien();
        scanner = new Scanner(System.in);
    }

    public NhanVien nhapNhanVien() {
        NhanVien nhanVien = new NhanVien();
        System.out.print("Nhập mã nhân viên: ");
        nhanVien.setMaNV(scanner.nextLine());
        System.out.print("Nhập họ tên: ");
        nhanVien.setHoTen(scanner.nextLine());
        System.out.print("Nhập CMND: ");
        nhanVien.setcMND(scanner.nextLine());
        System.out.print("Nhập năm sinh: ");
        nhanVien.setNamSinh(scanner.nextLine());
        System.out.print("Nhập giới tính");
        nhanVien.setGioiTinh(scanner.nextLine());
        System.out.print("Nhập SĐT: ");
        nhanVien.setGioiTinh(scanner.nextLine());
        System.out.print("Nhập chức vụ: ");
        nhanVien.setChucVu(scanner.nextLine());
        return nhanVien;
    }

    public void showNhanVien(NhanVien nhanVien, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, nhanVien.getMaNV(), nhanVien.getHoTen(), nhanVien.getcMND(), nhanVien.getNamSinh(), nhanVien.getGioiTinh(), nhanVien.getsDT(), nhanVien.getChucVu());
    }

    public void hienDSNhanVien() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã nhân viên", "Họ tên", "CMND", "Năm sinh", "Giới tính", "SĐT", "Chức vụ");
        for (NhanVien nhanVien : nhanVienList
        ) {
            showNhanVien(nhanVien, nhanVienList.indexOf(nhanVien));
        }
    }

    public void themNhanVien() {
        while (true) {
            NhanVien nhanVien = nhapNhanVien();
            nhanVienList.add(nhanVien);
            nhanVienDAL.ghiFile(nhanVienList);
            System.out.println("Bạn muốn nhập tiếp không?Y/N");
            String chon = scanner.nextLine();
            if (chon.equals("n") || chon.equals("N")) break;
        }
    }

    public List<NhanVien> timNhanVien(String tukhoa) {

        List<NhanVien> kq = new ArrayList<>();
        for (NhanVien nhanVien : nhanVienList
        ) {
            if (nhanVien.getMaNV().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nhanVien.getHoTen().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nhanVien.getNamSinh().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nhanVien.getGioiTinh().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nhanVien.getChucVu().toLowerCase().contains(tukhoa.toLowerCase())) {
                kq.add(nhanVien);
            }
        }
        if(kq.size()>0){
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã nhân viên", "Họ tên", "CMND", "Năm sinh", "Giới tính", "SĐT", "Chức vụ");
        }else{
            System.out.println("Không tìm thấy");
        }
        return kq;
    }

    public void capNhatThongTin() {
        hienDSNhanVien();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        NhanVien nhanVien = nhanVienList.get(chon);
        if (chon < 0 || chon > nhanVienList.size() - 1) {
            System.out.println("Chọn nhân viên không hợp lệ");
        } else {
            System.out.print("Nhập họ tên: ");
            nhanVien.setHoTen(scanner.nextLine());
            System.out.print("Nhập CMND: ");
            nhanVien.setcMND(scanner.nextLine());
            System.out.print("Nhập năm sinh: ");
            nhanVien.setNamSinh(scanner.nextLine());
            System.out.print("Nhập giới tính");
            nhanVien.setGioiTinh(scanner.nextLine());
            System.out.print("Nhập SĐT: ");
            nhanVien.setGioiTinh(scanner.nextLine());
            System.out.print("Nhập chức vụ: ");
            nhanVien.setChucVu(scanner.nextLine());
            nhanVienList.set(chon, nhanVien);
            System.out.println("Cập nhật thành công");
            nhanVienDAL.ghiFile(nhanVienList);
        }
    }
    public void xoaThongTin(){
        hienDSNhanVien();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        NhanVien nhanVien = nhanVienList.get(chon);
        if (chon < 0 || chon > nhanVienList.size() - 1) {
            System.out.println("Chọn nhân viên không hợp lệ");
        } else {
            nhanVienList.remove(chon);
            System.out.println("Xóa thành công");
            nhanVienDAL.ghiFile(nhanVienList);
        }
    }
    public NhanVien nhanVien(String manv){
        NhanVien nv = null;
        for (NhanVien nhanVien:nhanVienList
             ) {
            if(nhanVien.getMaNV().equalsIgnoreCase(manv)){
                nv = nhanVien;
            }
        }
        return nv;
    }
}
