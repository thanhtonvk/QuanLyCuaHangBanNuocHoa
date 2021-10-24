package com.company.BLL;

import com.company.DAL.CTHoaDonNhapDAL;
import com.company.Entities.CTHoaDonNhap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CTHoaDonNhapBLL {
    List<CTHoaDonNhap> ctHoaDonNhapList;
    CTHoaDonNhapDAL ctHoaDonNhapDAL;
    Random random;
    Scanner scanner;
    NuocHoaBLL nuocHoaBLL;
    public CTHoaDonNhapBLL() {
        ctHoaDonNhapDAL = new CTHoaDonNhapDAL();
        ctHoaDonNhapList = ctHoaDonNhapDAL.docDSCTHoaDonNhap();
        nuocHoaBLL = new NuocHoaBLL();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void showCtHoaDon(CTHoaDonNhap ctHoaDonNhap, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, ctHoaDonNhap.getMaCTHDN(), ctHoaDonNhap.getMaHDN(), ctHoaDonNhap.getMaNuocHoa(), ctHoaDonNhap.getSoLuong(), ctHoaDonNhap.getGiaNhap(), ctHoaDonNhap.getGiaNhap() * ctHoaDonNhap.getSoLuong());
    }

    public void hienDSCtHoaDon(String mahdn) {
        int tong = 0;
        List<CTHoaDonNhap> ctHoaDonNhapList = ctHoaDonNhapList(mahdn);
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã CTHDN", "Mã HĐN", "Mã nước hoa", "Số lượng", "Giá nhập", "Thành tiền");
        for (CTHoaDonNhap ctHoaDonNhap : ctHoaDonNhapList
        ) {
            showCtHoaDon(ctHoaDonNhap, ctHoaDonNhapList.indexOf(ctHoaDonNhap));
            tong+=ctHoaDonNhap.getSoLuong()*ctHoaDonNhap.getGiaNhap();
        }
        System.out.println("Tổng thanh toán là: "+tong);
    }

    public void hienDSNuocHoa() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã nước hoa", "Số lượng", "Giá nhập");
        for (CTHoaDonNhap ctHoaDonNhap : ctHoaDonNhapList
        ) {
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|\n", ctHoaDonNhapList.indexOf(ctHoaDonNhap), ctHoaDonNhap.getMaNuocHoa(),ctHoaDonNhap.getSoLuong(),ctHoaDonNhap.getGiaNhap());
        }
    }
    public CTHoaDonNhap themCTHoaDon(String maHD) {
        CTHoaDonNhap ctHoaDonNhap = new CTHoaDonNhap();
        ctHoaDonNhap.setMaCTHDN(random.nextInt() + "");
        ctHoaDonNhap.setMaHDN(maHD);
        System.out.println("Nhập mã nước hoa");
        ctHoaDonNhap.setMaNuocHoa(scanner.nextLine());
        System.out.println("Nhập số lượng");
        ctHoaDonNhap.setSoLuong(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập giá nhập: ");
        ctHoaDonNhap.setGiaNhap(Integer.parseInt(scanner.nextLine()));
        nuocHoaBLL.capNhapSoLuong(ctHoaDonNhap.getMaNuocHoa(),-ctHoaDonNhap.getSoLuong());
        return ctHoaDonNhap;
    }

    public void nhapCTHoaDon(String maHD) {
        while (true) {
            ctHoaDonNhapList.add(themCTHoaDon(maHD));
            ctHoaDonNhapDAL.ghiFile(ctHoaDonNhapList);
            System.out.println("Bạn muốn nhập tiếp không?C/K");
            String chon = scanner.nextLine();
            if (chon.equalsIgnoreCase("k")) break;
        }
    }

    public List<CTHoaDonNhap> ctHoaDonNhapList(String mahdn) {
        List<CTHoaDonNhap> kq = new ArrayList<>();
        for (CTHoaDonNhap ctHoaDonNhap : ctHoaDonNhapList
        ) {
            if (ctHoaDonNhap.getMaHDN().equalsIgnoreCase(mahdn)) kq.add(ctHoaDonNhap);
        }
        return kq;
    }
}
