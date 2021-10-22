package com.company.DAL;

import com.company.Entities.CTHoaDonXuat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CTHoaDonXuatDAL {
    //tạo file
    File file = new File("CTHoaDonXuat.txt");
    //đọc file từ file txt
    public List<CTHoaDonXuat> docDSCTHoaDonXuat(){
        //tạo mới danh sách mảng lưu
        List<CTHoaDonXuat>cTHoaDonXuatList = new ArrayList<>();
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
                    CTHoaDonXuat cTHoaDonXuat = new CTHoaDonXuat(arr[0],arr[1],arr[2],Integer.parseInt(arr[3]));
                    cTHoaDonXuatList.add(cTHoaDonXuat);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cTHoaDonXuatList;
    }
    public void ghiFile(List<CTHoaDonXuat>cTHoaDonXuatList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (CTHoaDonXuat cTHoaDonXuat:cTHoaDonXuatList
            ) {
                //ghi từng dòng
                fileWriter.write(cTHoaDonXuat.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
