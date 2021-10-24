package com.company.GUI;

import com.company.BLL.HoaDonXuatBLL;
import com.company.Entities.HoaDonXuat;

import java.util.List;
import java.util.Scanner;

public class QuanLyHoaDonXuat {
    public void menu() {
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                        QUẢN LÝ HÓA ĐƠN XUẤT                   ║");
        System.out.println("                            ║═══════════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        1. THÊM HÓA ĐƠN XUẤT                   ║");
        System.out.println("                            ║                        2. HIỂN THỊ DANH SÁCH HÓA ĐƠN          ║");
        System.out.println("                            ║                        3. TÌM KIẾM                            ║");
        System.out.println("                            ║                        0. THOÁT                               ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }

    public void run() {
        HoaDonXuatBLL HoaDonXuatBLL = new HoaDonXuatBLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Chon: ");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    HoaDonXuatBLL.themHoaDonXuat();
                    break;
                case 2:
                    HoaDonXuatBLL.hienDSHoaDonXuat();
                    break;
                case 3:
                    System.out.println("Nhập HÓA ĐƠN XUẤT cần tìm: ");
                    String str = scanner.nextLine();
                    List<HoaDonXuat> HoaDonXuatList = HoaDonXuatBLL.timHoaDonXuat(str);
                    for (HoaDonXuat HoaDonXuat : HoaDonXuatList
                    ) {
                        HoaDonXuatBLL.showHoaDonXuat(HoaDonXuat, HoaDonXuatList.indexOf(HoaDonXuat));
                    }
                    break;
                default:
                    break;
            }
            if (chon == 0) break;
        }
    }
}
