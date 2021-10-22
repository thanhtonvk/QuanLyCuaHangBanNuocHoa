package com.company.DAL;

import com.company.Entities.HoaDonNhap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonNhapDAL {
    //tạo file
    File file = new File("HoaDonNhap.txt");
    //đọc file từ file txt
    public List<HoaDonNhap> docDSHoaDonNhap(){
        //tạo mới danh sách mảng lưu
        List<HoaDonNhap>hoaDonNhapList = new ArrayList<>();
        //nếu file tồn tại thì mới cho đọc
        if(file.exists()){
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while((line= bufferedReader.readLine())!=null){
                    //tách chuỗi lưu vào mảng;
                    String[]arr = line.split("#");
                    HoaDonNhap hoaDonNhap = new HoaDonNhap(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
                    hoaDonNhapList.add(hoaDonNhap);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hoaDonNhapList;
    }
    public void ghiFile(List<HoaDonNhap>hoaDonNhapList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (HoaDonNhap hoaDonNhap:hoaDonNhapList
            ) {
                //ghi từng dòng
                fileWriter.write(hoaDonNhap.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
