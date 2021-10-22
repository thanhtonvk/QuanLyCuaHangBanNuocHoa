package com.company.DAL;

import com.company.Entities.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAL {
    //tạo file
    File file = new File("NhanVien.txt");
    //đọc file từ file txt
    public List<NhanVien> docDSNhanVien(){
        //tạo mới danh sách mảng lưu
        List<NhanVien>nhanVienList = new ArrayList<>();
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
                    NhanVien nhanVien = new NhanVien(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
                    nhanVienList.add(nhanVien);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nhanVienList;
    }
    public void ghiFile(List<NhanVien>nhanVienList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (NhanVien nhanVien:nhanVienList
            ) {
                //ghi từng dòng
                fileWriter.write(nhanVien.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
