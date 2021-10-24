package com.company.GUI;

import com.company.BLL.KhachHangBLL;
import com.company.Entities.KhachHang;

import java.util.List;
import java.util.Scanner;

public class QuanLyKhachHang {
    public void menu() {
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                        QUẢN LÝ KHÁCH HÀNG                     ║");
        System.out.println("                            ║═══════════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        1. THÊM KHÁCH HÀNG                     ║");
        System.out.println("                            ║                        2. HIỂN THỊ DANH SÁCH KH               ║");
        System.out.println("                            ║                        3. TÌM KIẾM                            ║");
        System.out.println("                            ║                        4. CẬP NHẬT THÔNG TIN                  ║");
        System.out.println("                            ║                        5. XÓA KHÁCH HÀNG                      ║");
        System.out.println("                            ║                        0. THOÁT                               ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }

    public void run() {
        KhachHangBLL khachHangBLL = new KhachHangBLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Chon: ");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    khachHangBLL.themKhachHang();
                    break;
                case 2:
                    khachHangBLL.hienDSKhachHang();
                    break;
                case 3:
                    System.out.println("Nhập kh cần tìm: ");
                    String str = scanner.nextLine();
                    List<KhachHang> khachHangList = khachHangBLL.timKhachHang(str);
                    for (KhachHang khachHang : khachHangList
                    ) {
                        khachHangBLL.showKhachHang(khachHang, khachHangList.indexOf(khachHang));
                    }
                    break;
                case 4:
                    khachHangBLL.capNhatThongTin();
                    break;
                case 5:
                    khachHangBLL.xoaThongTin();
                    break;
                default:
                    break;
            }
            if(chon==0) break;
        }
    }
}
