package com.company.GUI;

import com.company.BLL.HoaDonNhapBLL;
import com.company.Entities.HoaDonNhap;

import java.util.List;
import java.util.Scanner;

public class QuanLyHoaDonNhap {
    public void menu() {
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                        QUẢN LÝ HÓA ĐƠN NHẬP                   ║");
        System.out.println("                            ║═══════════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        1. THÊM HÓA ĐƠN NHẬP                   ║");
        System.out.println("                            ║                        2. HIỂN THỊ DANH SÁCH HÓA ĐƠN          ║");
        System.out.println("                            ║                        3. TÌM KIẾM                            ║");
        System.out.println("                            ║                        0. THOÁT                               ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }

    public void run() {
        HoaDonNhapBLL hoaDonNhapBLL = new HoaDonNhapBLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Chon: ");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    hoaDonNhapBLL.themHoaDonNhap();
                    break;
                case 2:
                    hoaDonNhapBLL.hienDSHoaDonNhap();
                    break;
                case 3:
                    System.out.println("Nhập hóa đơn nhập cần tìm: ");
                    String str = scanner.nextLine();
                    List<HoaDonNhap> hoaDonNhapList = hoaDonNhapBLL.timHoaDonNhap(str);
                    for (HoaDonNhap hoaDonNhap : hoaDonNhapList
                    ) {
                        hoaDonNhapBLL.showHoaDonNhap(hoaDonNhap, hoaDonNhapList.indexOf(hoaDonNhap));
                    }
                    break;
                default:
                    break;
            }
            if (chon == 0) break;
        }
    }
}
