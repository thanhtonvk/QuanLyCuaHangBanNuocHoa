package com.company.DAL;

import com.company.Entities.KhachHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAL {
    //tạo file
    File file = new File("KhachHang.txt");
    //đọc file từ file txt
    public List<KhachHang> docDSKhachHang(){
        //tạo mới danh sách mảng lưu
        List<KhachHang>khachHangList = new ArrayList<>();
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
                    KhachHang khachHang = new KhachHang(arr[0],arr[1],arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),Integer.parseInt(arr[6]));
                    khachHangList.add(khachHang);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return khachHangList;
    }
    public void ghiFile(List<KhachHang>khachHangList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (KhachHang khachHang:khachHangList
            ) {
                //ghi từng dòng
                fileWriter.write(khachHang.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
