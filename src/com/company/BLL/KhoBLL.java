package com.company.BLL;

import com.company.DAL.KhoDAL;
import com.company.Entities.Kho;
import com.company.Entities.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhoBLL {
    List<Kho> khoList;
    KhoDAL khoDAL;
    Scanner scanner;
    NhanVienBLL nhanVienBLL;
    public KhoBLL() {
        khoDAL = new KhoDAL();
        nhanVienBLL = new NhanVienBLL();
        khoList = khoDAL.docDSKho();
        scanner = new Scanner(System.in);
    }

    public Kho nhapKho() {
        Kho kho = new Kho();
        System.out.print("Nhập mã kho: ");
        kho.setMaKho(scanner.nextLine());
        System.out.print("Nhập vị trí: ");
        kho.setViTri(scanner.nextLine());
        System.out.print("Nhập tình trạng");
        kho.setTinhTrang(scanner.nextLine());
        nhanVienBLL.hienDSNhanVien();
        System.out.print("Chọn nhân viên quản lý: ");
        int chon = Integer.parseInt(scanner.nextLine());
        if(chon<0||chon>nhanVienBLL.nhanVienList.size()-1){
            System.out.println("Nhân viên không tồn tại");
        }else{
            NhanVien nhanVien= nhanVienBLL.nhanVienList.get(chon);
            kho.setMaNV(nhanVien.getMaNV());
        }
        return kho;
    }

    public void showKho(Kho kho, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, kho.getMaKho(), kho.getViTri(), kho.getTinhTrang(), kho.getMaNV());
    }

    public void hienDSKho() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã kho", "Vị trí", "Tình trạng", "Mã nhân viên");
        for (Kho kho : khoList
        ) {
            showKho(kho, khoList.indexOf(kho));
        }
    }

    public void themKho() {
        while (true) {
            Kho kho = nhapKho();
            khoList.add(kho);
            khoDAL.ghiFile(khoList);
            System.out.println("Bạn muốn nhập tiếp không?Y/N");
            String chon = scanner.nextLine();
            if (chon.equals("n") || chon.equals("N")) break;
        }
    }

    public List<Kho> timKho(String tukhoa) {

        List<Kho> kq = new ArrayList<>();
        for (Kho kho : khoList
        ) {
            if (kho.getMaKho().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    kho.getViTri().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    kho.getTinhTrang().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    kho.getMaNV().toLowerCase().contains(tukhoa.toLowerCase())) {
                kq.add(kho);
            }
        }
        if(kq.size()>0){
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã kho", "Vị trí", "Tình trạng", "Mã nhân viên");
        }else{
            System.out.println("Không tìm thấy");
        }
        return kq;
    }

    public void capNhatThongTin() {
        hienDSKho();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        Kho kho = khoList.get(chon);
        if (chon < 0 || chon > khoList.size() - 1) {
            System.out.println("Chọn kho không hợp lệ");
        } else {
            System.out.print("Nhập vị trí: ");
            kho.setViTri(scanner.nextLine());
            System.out.print("Nhập tình trạng");
            kho.setTinhTrang(scanner.nextLine());
            nhanVienBLL.hienDSNhanVien();
            System.out.print("Chọn nhân viên quản lý: ");
            int index = Integer.parseInt(scanner.nextLine());
            if(index<0||index>nhanVienBLL.nhanVienList.size()-1){
                System.out.println("Nhân viên không tồn tại");
            }else{
                NhanVien nhanVien= nhanVienBLL.nhanVienList.get(chon);
                kho.setMaNV(nhanVien.getMaNV());
            }
            khoList.set(index, kho);
            System.out.println("Cập nhật thành công");
            khoDAL.ghiFile(khoList);
        }
    }
    public void xoaThongTin(){
        hienDSKho();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        Kho kho = khoList.get(chon);
        if (chon < 0 || chon > khoList.size() - 1) {
            System.out.println("Chọn kho không hợp lệ");
        } else {
            khoList.remove(chon);
            System.out.println("Xóa thành công");
            khoDAL.ghiFile(khoList);
        }
    }
    public Kho kho(String makho){
        Kho rs = null;
        for (Kho kho:khoList
             ) {
            if(kho.getMaKho().equalsIgnoreCase(makho)) rs = kho;
        }
        return rs;
    }
}
