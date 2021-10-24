package com.company.GUI;

import com.company.BLL.NhanVienBLL;
import com.company.Entities.NhanVien;

import java.util.List;
import java.util.Scanner;

public class QuanLyNhanVien {
    public void menu() {
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                        QUẢN LÝ NHÂN VIÊN                      ║");
        System.out.println("                            ║═══════════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        1. THÊM NHÂN VIÊN                      ║");
        System.out.println("                            ║                        2. HIỂN THỊ DANH SÁCH NV               ║");
        System.out.println("                            ║                        3. TÌM KIẾM                            ║");
        System.out.println("                            ║                        4. CẬP NHẬT THÔNG TIN                  ║");
        System.out.println("                            ║                        5. XÓA NHÂN VIÊN                       ║");
        System.out.println("                            ║                        0. THOÁT                               ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }

    public void run() {
        NhanVienBLL nhanVienBLL = new NhanVienBLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Chon: ");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    nhanVienBLL.themNhanVien();
                    break;
                case 2:
                    nhanVienBLL.hienDSNhanVien();
                    break;
                case 3:
                    System.out.println("Nhập nhân viên cần tìm: ");
                    String str = scanner.nextLine();
                    List<NhanVien> nhanVienList = nhanVienBLL.timNhanVien(str);
                    for (NhanVien nhanVien : nhanVienList
                    ) {
                        nhanVienBLL.showNhanVien(nhanVien, nhanVienList.indexOf(nhanVien));
                    }
                    break;
                case 4:
                    nhanVienBLL.capNhatThongTin();
                    break;
                case 5:
                    nhanVienBLL.xoaThongTin();
                    break;
                default:
                    break;
            }
            if(chon==0) break;
        }
    }
}
