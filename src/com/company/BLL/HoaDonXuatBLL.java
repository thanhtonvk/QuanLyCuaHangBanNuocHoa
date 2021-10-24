package com.company.BLL;

import com.company.DAL.HoaDonXuatDAL;
import com.company.Entities.CTHoaDonXuat;
import com.company.Entities.HoaDonXuat;
import com.company.Entities.KhachHang;
import com.company.Entities.NuocHoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoaDonXuatBLL {
    List<HoaDonXuat> hoaDonXuatList;
    HoaDonXuatDAL hoaDonXuatDAL;
    Scanner scanner;
    NuocHoaBLL nuocHoaBLL;
    NhanVienBLL nhanVienBLL;
    CTHoaDonXuatBLL ctHoaDonXuatBLL;
    KhachHangBLL khachHangBLL;

    public HoaDonXuatBLL() {
        hoaDonXuatDAL = new HoaDonXuatDAL();
        hoaDonXuatList = hoaDonXuatDAL.docDSHoaDonXuat();
        nuocHoaBLL = new NuocHoaBLL();
        ctHoaDonXuatBLL = new CTHoaDonXuatBLL();
        nhanVienBLL = new NhanVienBLL();
        khachHangBLL = new KhachHangBLL();
        scanner = new Scanner(System.in);
    }

    public HoaDonXuat nhapHoaDonXuat() {
        HoaDonXuat hoaDonXuat = new HoaDonXuat();
        System.out.print("Nhập mã hóa đơn: ");
        hoaDonXuat.setMaHD(scanner.nextLine());
        nhanVienBLL.hienDSNhanVien();
        System.out.println("Chọn nhân viên: ");
        int chonnv = Integer.parseInt(scanner.nextLine());
        hoaDonXuat.setMaNV(nhanVienBLL.nhanVienList.get(chonnv).getMaNV());
        System.out.println("Nhập ngày bán: ");
        hoaDonXuat.setThoiGian(scanner.nextLine());
        khachHangBLL.hienDSKhachHang();
        System.out.println("Chọn khách hàng: ");
        int chonkh = Integer.parseInt(scanner.nextLine());
        KhachHang khachHang = khachHangBLL.khachHangList.get(chonkh);
        hoaDonXuat.setMaNV(khachHang.getMaKH());
        khachHangBLL.updateSoLanDen(khachHang,chonkh);
        return hoaDonXuat;
    }

    public void showHoaDonXuat(HoaDonXuat hoaDonXuat, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, hoaDonXuat.getMaHD(), hoaDonXuat.getMaNV(), hoaDonXuat.getMaKH(), hoaDonXuat.getThoiGian());
    }

    public void hienDSHoaDonXuat() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã HDN", "Mã kho", "Tên NCC", "Địa chỉ NCC", "SĐT", "Ngày nhập", "Mã nhân viên");
        for (HoaDonXuat hoaDonXuat : hoaDonXuatList
        ) {
            showHoaDonXuat(hoaDonXuat, hoaDonXuatList.indexOf(hoaDonXuat));
        }
        System.out.println("Chọn hóa đơn muốn xem (Nhập -1 để bỏ qua): ");
        int chon = Integer.parseInt(scanner.nextLine());
        if (chon > -1) {
            HoaDonXuat hoaDonXuat = hoaDonXuatList.get(0);
            ctHoaDonXuatBLL.hienDSCtHoaDon(hoaDonXuat.getMaHD());
        }
    }

    public void themHoaDonXuat() {
        HoaDonXuat hoaDonXuat = nhapHoaDonXuat();
        hoaDonXuatList.add(hoaDonXuat);
        hoaDonXuatDAL.ghiFile(hoaDonXuatList);
        ctHoaDonXuatBLL.nhapCTHoaDon(hoaDonXuat.getMaHD());
        System.out.println("Thông tin hóa đơn");
        showHoaDonXuat(hoaDonXuat, 0);
        List<CTHoaDonXuat> ctHoaDonXuatList = ctHoaDonXuatBLL.cTHoaDonXuatList(hoaDonXuat.getMaHD());
        for (CTHoaDonXuat ctHoaDonXuat : ctHoaDonXuatList
        ) {
            ctHoaDonXuatBLL.showCtHoaDon(ctHoaDonXuat, ctHoaDonXuatList.indexOf(ctHoaDonXuat));
        }

    }

    public List<HoaDonXuat> timHoaDonXuat(String tukhoa) {

        List<HoaDonXuat> kq = new ArrayList<>();
        for (HoaDonXuat hoaDonXuat : hoaDonXuatList
        ) {
            if (hoaDonXuat.getMaHD().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonXuat.getMaNV().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonXuat.getMaKH().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    hoaDonXuat.getThoiGian().toLowerCase().contains(tukhoa.toLowerCase())
            ) {
                kq.add(hoaDonXuat);
            }
        }
        if (kq.size() > 0) {
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã HDN", "Mã kho", "Tên NCC", "Địa chỉ NCC", "SĐT", "Ngày nhập", "Mã nhân viên");
        } else {
            System.out.println("Không tìm thấy");
        }
        return kq;
    }

    public HoaDonXuat hoaDonXuat(String mahdn) {
        HoaDonXuat hdn = null;
        for (HoaDonXuat hoaDonXuat : hoaDonXuatList
        ) {
            if (hoaDonXuat.getMaHD().equalsIgnoreCase(mahdn)) hdn = hoaDonXuat;
        }
        return hdn;
    }

}
