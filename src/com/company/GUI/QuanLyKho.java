package com.company.GUI;

import com.company.BLL.KhoBLL;
import com.company.Entities.Kho;

import java.util.List;
import java.util.Scanner;

public class QuanLyKho {
    public void menu() {
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                        QUẢN LÝ KHO                            ║");
        System.out.println("                            ║═══════════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        1. THÊM KHO                            ║");
        System.out.println("                            ║                        2. HIỂN THỊ DANH SÁCH KHO              ║");
        System.out.println("                            ║                        3. TÌM KIẾM                            ║");
        System.out.println("                            ║                        4. CẬP NHẬT THÔNG TIN                  ║");
        System.out.println("                            ║                        5. XÓA KHO                             ║");
        System.out.println("                            ║                        0. THOÁT                               ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }

    public void run() {
        KhoBLL khoBLL = new KhoBLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Chon: ");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    khoBLL.themKho();
                    break;
                case 2:
                    khoBLL.hienDSKho();
                    break;
                case 3:
                    System.out.println("Nhập kho cần tìm: ");
                    String str = scanner.nextLine();
                    List<Kho> khoList = khoBLL.timKho(str);
                    for (Kho kho : khoList
                    ) {
                        khoBLL.showKho(kho, khoList.indexOf(kho));
                    }
                    break;
                case 4:
                    khoBLL.capNhatThongTin();
                    break;
                case 5:
                    khoBLL.xoaThongTin();
                    break;
                default:
                    break;
            }
            if (chon == 0) break;
        }
    }
}
