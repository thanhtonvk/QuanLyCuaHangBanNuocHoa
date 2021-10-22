package com.company.DAL;

import com.company.Entities.CTHoaDonNhap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CTHoaDonNhapDAL {
    //tạo file
    File file = new File("CTHoaDonNhap.txt");
    //đọc file từ file txt
    public List<CTHoaDonNhap> docDSCTHoaDonNhap(){
        //tạo mới danh sách mảng lưu
        List<CTHoaDonNhap>cTHoaDonNhapList = new ArrayList<>();
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
                    CTHoaDonNhap cTHoaDonNhap = new CTHoaDonNhap(arr[0],arr[1],arr[2],Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
                    cTHoaDonNhapList.add(cTHoaDonNhap);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cTHoaDonNhapList;
    }
    public void ghiFile(List<CTHoaDonNhap>cTHoaDonNhapList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (CTHoaDonNhap cTHoaDonNhap:cTHoaDonNhapList
            ) {
                //ghi từng dòng
                fileWriter.write(cTHoaDonNhap.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
