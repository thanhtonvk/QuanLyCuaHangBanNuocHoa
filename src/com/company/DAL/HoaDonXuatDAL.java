package com.company.DAL;

import com.company.Entities.HoaDonXuat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonXuatDAL {
    //tạo file
    File file = new File("HoaDonXuat.txt");
    //đọc file từ file txt
    public List<HoaDonXuat> docDSHoaDonXuat(){
        //tạo mới danh sách mảng lưu
        List<HoaDonXuat>hoaDonXuatList = new ArrayList<>();
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
                    HoaDonXuat hoaDonXuat = new HoaDonXuat(arr[0],arr[1],arr[2],arr[3]);
                    hoaDonXuatList.add(hoaDonXuat);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hoaDonXuatList;
    }
    public void ghiFile(List<HoaDonXuat>hoaDonXuatList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (HoaDonXuat hoaDonXuat:hoaDonXuatList
            ) {
                //ghi từng dòng
                fileWriter.write(hoaDonXuat.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
