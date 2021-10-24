package com.company.BLL;

import com.company.DAL.NuocHoaDAL;
import com.company.DAL.NuocHoaDAL;
import com.company.Entities.CTHoaDonNhap;
import com.company.Entities.NuocHoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NuocHoaBLL {
    List<NuocHoa> nuocHoaList;
    NuocHoaDAL nuocHoaDAL;
    Scanner scanner;
    CTHoaDonNhapBLL ctHoaDonNhapBLL;

    public NuocHoaBLL() {
        nuocHoaDAL = new NuocHoaDAL();
        nuocHoaList = nuocHoaDAL.docDSNuocHoa();
        ctHoaDonNhapBLL = new CTHoaDonNhapBLL();
        scanner = new Scanner(System.in);
    }

    public NuocHoa nhapNuocHoa() {
        NuocHoa nuocHoa = new NuocHoa();
        ctHoaDonNhapBLL.hienDSNuocHoa();
        System.out.println("Chọn mã nước hoa: ");
        int chon = Integer.parseInt(scanner.nextLine());
        CTHoaDonNhap ctHoaDonNhap = ctHoaDonNhapBLL.ctHoaDonNhapList.get(chon);
        nuocHoa.setMaNuocHoa(ctHoaDonNhap.getMaNuocHoa());
        nuocHoa.setSoluong(ctHoaDonNhap.getSoLuong());
        System.out.println("Nhập tên nước hoa: ");
        nuocHoa.setTenNuocHoa(scanner.nextLine());
        System.out.println("Nhập loại nước hoa: ");
        nuocHoa.setLoaiNuocHoa(scanner.nextLine());
        System.out.println("Nhập xuất xứ: ");
        nuocHoa.setXuatXu(scanner.nextLine());
        System.out.println("Nhập giá bán: ");
        nuocHoa.setGiaBan(Integer.parseInt(scanner.nextLine()));
        return nuocHoa;
    }

    public void showNuocHoa(NuocHoa nuocHoa, int i) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, nuocHoa.getMaNuocHoa(), nuocHoa.getTenNuocHoa(), nuocHoa.getLoaiNuocHoa(), nuocHoa.getXuatXu(), nuocHoa.getSoluong(), nuocHoa.getGiaBan());
    }

    public void hienDSNuocHoa() {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã nước hoa", "Tên nước hoa", "Loại nước hoa", "Xuất xứ", "Số lượng", "Giá bán");
        for (NuocHoa nuocHoa : nuocHoaList
        ) {
            showNuocHoa(nuocHoa, nuocHoaList.indexOf(nuocHoa));
        }
    }

    public void themNuocHoa() {
        while (true) {
            NuocHoa nuocHoa = nhapNuocHoa();
            nuocHoaList.add(nuocHoa);
            nuocHoaDAL.ghiFile(nuocHoaList);
            System.out.println("Bạn muốn nhập tiếp không?Y/N");
            String chon = scanner.nextLine();
            if (chon.equals("n") || chon.equals("N")) break;
        }
    }

    public List<NuocHoa> timNuocHoa(String tukhoa) {

        List<NuocHoa> kq = new ArrayList<>();
        for (NuocHoa nuocHoa : nuocHoaList
        ) {
            if (nuocHoa.getTenNuocHoa().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nuocHoa.getLoaiNuocHoa().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nuocHoa.getXuatXu().toLowerCase().contains(tukhoa.toLowerCase()) ||
                    nuocHoa.getMaNuocHoa().toLowerCase().contains(tukhoa.toLowerCase())) {
                kq.add(nuocHoa);
            }
        }
        if (kq.size() > 0) {
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã nước hoa", "Tên nước hoa", "Loại nước hoa", "Xuất xứ", "Số lượng", "Giá bán");
        } else {
            System.out.println("Không tìm thấy");
        }
        return kq;
    }

    public void capNhatThongTin() {
        hienDSNuocHoa();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        NuocHoa nuocHoa = nuocHoaList.get(chon);
        if (chon < 0 || chon > nuocHoaList.size() - 1) {
            System.out.println("Chọn nước hoa không hợp lệ");
        } else {

            System.out.println("Nhập tên nước hoa: ");
            nuocHoa.setTenNuocHoa(scanner.nextLine());
            System.out.println("Nhập loại nước hoa: ");
            nuocHoa.setLoaiNuocHoa(scanner.nextLine());
            System.out.println("Nhập xuất xứ: ");
            nuocHoa.setXuatXu(scanner.nextLine());
            System.out.println("Nhập số lượng: ");
            nuocHoa.setSoluong(Integer.parseInt(scanner.nextLine()));
            System.out.println("Nhập giá bán: ");
            nuocHoa.setGiaBan(Integer.parseInt(scanner.nextLine()));
            nuocHoaList.set(chon, nuocHoa);
            System.out.println("Cập nhật thành công");
            nuocHoaDAL.ghiFile(nuocHoaList);
        }
    }

    public void capNhapSoLuong(String manuochoa,int sl){
        NuocHoa nuocHoa = nuocHoa(manuochoa);
        if(nuocHoa==null){

        }else{
            int index = nuocHoaList.indexOf(nuocHoa);
            nuocHoa.setSoluong(nuocHoa.getSoluong()-sl);
            nuocHoaList.set(index,nuocHoa);
            nuocHoaDAL.ghiFile(nuocHoaList);
        }


    }
    public void xoaThongTin() {
        hienDSNuocHoa();
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(scanner.nextLine());
        NuocHoa nuocHoa = nuocHoaList.get(chon);
        if (chon < 0 || chon > nuocHoaList.size() - 1) {
            System.out.println("Chọn nước hoa không hợp lệ");
        } else {
            nuocHoaList.remove(chon);
            System.out.println("Xóa thành công");
            nuocHoaDAL.ghiFile(nuocHoaList);
        }
    }
    public NuocHoa nuocHoa(String manh) {
        NuocHoa nh = null;
        for (NuocHoa nuocHoa : nuocHoaList
        ) {
            if (nuocHoa.getMaNuocHoa().equalsIgnoreCase(manh)) {
                nh = nuocHoa;
            }
        }
        return nh;
    }
}
