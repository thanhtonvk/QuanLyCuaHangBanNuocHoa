package com.company.BLL;

import com.company.DAL.NhanVienDAL;
import com.company.Entities.NhanVien;

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
        System.out.println("Nhập CMND: ");
        nhanVien.setcMND(scanner.nextLine());
        System.out.println("Nhập năm sinh: ");
        nhanVien.setNamSinh(scanner.nextLine());
        System.out.println("Nhập giới tính");
        nhanVien.setGioiTinh(scanner.nextLine());
        System.out.println("Nhập SĐT: ");
        nhanVien.setGioiTinh(scanner.nextLine());
        System.out.println("Nhập chức vụ: ");
        nhanVien.setChucVu(scanner.nextLine());
        return nhanVien;
    }

    public void themNhanVien() {
        while (true) {
            NhanVien nhanVien = nhapNhanVien();
            nhanVienList.add(nhanVien);
            System.out.println("Bạn muốn nhập tiếp không?Y/N");
            String chon = scanner.nextLine();
            if (chon == "n" || chon == "N") break;
        }
    }
}
