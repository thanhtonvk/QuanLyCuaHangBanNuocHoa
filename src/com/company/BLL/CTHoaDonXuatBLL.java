package com.company.BLL;

import com.company.DAL.CTHoaDonXuatDAL;
import com.company.Entities.CTHoaDonXuat;
import com.company.Entities.NuocHoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CTHoaDonXuatBLL {
    List<CTHoaDonXuat> cTHoaDonXuatList;
    CTHoaDonXuatDAL cTHoaDonXuatDAL;
    Random random;
    Scanner scanner;
    NuocHoaBLL nuocHoaBLL;
    public CTHoaDonXuatBLL() {
        cTHoaDonXuatDAL = new CTHoaDonXuatDAL();
        cTHoaDonXuatList = cTHoaDonXuatDAL.docDSCTHoaDonXuat();
        random = new Random();
        scanner = new Scanner(System.in);
        nuocHoaBLL = new NuocHoaBLL();
    }

    public void showCtHoaDon(CTHoaDonXuat cTHoaDonXuat, int i) {
        NuocHoa nuocHoa = nuocHoaBLL.nuocHoa(cTHoaDonXuat.getMaNuocHoa());
        if(nuocHoa!=null){
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", i, cTHoaDonXuat.getCtHDX(), cTHoaDonXuat.getMaHD(), cTHoaDonXuat.getMaNuocHoa(),nuocHoa.getTenNuocHoa(), cTHoaDonXuat.getSoLuong(),nuocHoa.getGiaBan(),  nuocHoa.getGiaBan() * cTHoaDonXuat.getSoLuong());
        }
    }

    public void hienDSCtHoaDon(String mahdn) {
        int tong = 0;
        List<CTHoaDonXuat> cTHoaDonXuatList = cTHoaDonXuatList(mahdn);
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "STT", "Mã CTHD", "Mã hóa đơn", "Mã nước hoa","Tên nước hoa","Số lượng",  "Giá bán","Thành tiền");
        for (CTHoaDonXuat cTHoaDonXuat : cTHoaDonXuatList
        ) {
            showCtHoaDon(cTHoaDonXuat, cTHoaDonXuatList.indexOf(cTHoaDonXuat));
            tong+=cTHoaDonXuat.getSoLuong()*nuocHoaBLL.nuocHoa(cTHoaDonXuat.getMaNuocHoa()).getGiaBan();
        }
        System.out.println("Tổng thanh toán là :"+tong);
    }

    public CTHoaDonXuat themCTHoaDon(String maHD) {
        CTHoaDonXuat cTHoaDonXuat = new CTHoaDonXuat();
        cTHoaDonXuat.setCtHDX(random.nextInt() + "");
        cTHoaDonXuat.setMaHD(maHD);
        System.out.println("Chọn nước hoa");
        nuocHoaBLL.hienDSNuocHoa();
        int chonuochoa = Integer.parseInt(scanner.nextLine());
        NuocHoa nuocHoa= nuocHoaBLL.nuocHoaList.get(chonuochoa);
        cTHoaDonXuat.setMaNuocHoa(nuocHoa.getMaNuocHoa());
        System.out.println("Nhập số lượng");
        cTHoaDonXuat.setSoLuong(Integer.parseInt(scanner.nextLine()));
        nuocHoaBLL.capNhapSoLuong(nuocHoa.getMaNuocHoa(),cTHoaDonXuat.getSoLuong());
        return cTHoaDonXuat;
    }

    public void nhapCTHoaDon(String maHD) {
        while (true) {
            cTHoaDonXuatList.add(themCTHoaDon(maHD));
            cTHoaDonXuatDAL.ghiFile(cTHoaDonXuatList);
            System.out.println("Bạn muốn nhập tiếp không?C/K");
            String chon = scanner.nextLine();
            if (chon.equalsIgnoreCase("k")) break;
        }
    }

    public List<CTHoaDonXuat> cTHoaDonXuatList(String mahdn) {
        List<CTHoaDonXuat> kq = new ArrayList<>();
        for (CTHoaDonXuat cTHoaDonXuat : cTHoaDonXuatList
        ) {
            if (cTHoaDonXuat.getMaHD().equalsIgnoreCase(mahdn)) kq.add(cTHoaDonXuat);
        }
        return kq;
    }
}
