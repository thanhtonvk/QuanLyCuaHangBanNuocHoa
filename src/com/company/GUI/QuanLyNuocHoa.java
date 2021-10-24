package com.company.GUI;

import com.company.BLL.NuocHoaBLL;
import com.company.Entities.NuocHoa;

import java.util.List;
import java.util.Scanner;

public class QuanLyNuocHoa {
    public void menu() {
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                        QUẢN LÝ NƯỚC HOA                       ║");
        System.out.println("                            ║═══════════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        1. THÊM NƯỚC HOA                       ║");
        System.out.println("                            ║                        2. HIỂN THỊ DANH SÁCH NH               ║");
        System.out.println("                            ║                        3. TÌM KIẾM                            ║");
        System.out.println("                            ║                        4. CẬP NHẬT THÔNG TIN                  ║");
        System.out.println("                            ║                        5. XÓA NƯỚC HOA                        ║");
        System.out.println("                            ║                        0. THOÁT                               ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }

    public void run() {
        NuocHoaBLL nuocHoaBLL = new NuocHoaBLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Chon: ");
            int chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1:
                    nuocHoaBLL.themNuocHoa();
                    break;
                case 2:
                    nuocHoaBLL.hienDSNuocHoa();
                    break;
                case 3:
                    System.out.println("Nhập nước hoa cần tìm: ");
                    String str = scanner.nextLine();
                    List<NuocHoa> nuocHoaList = nuocHoaBLL.timNuocHoa(str);
                    for (NuocHoa nuocHoa : nuocHoaList
                    ) {
                        nuocHoaBLL.showNuocHoa(nuocHoa, nuocHoaList.indexOf(nuocHoa));
                    }
                    break;
                case 4:
                    nuocHoaBLL.capNhatThongTin();
                    break;
                case 5:
                    nuocHoaBLL.xoaThongTin();
                    break;
                default:
                    break;
            }
            if (chon == 0) break;
        }
    }
}
