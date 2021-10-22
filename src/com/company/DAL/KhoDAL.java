package com.company.DAL;

import com.company.Entities.Kho;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KhoDAL {
    //tạo file
    File file = new File("Kho.txt");
    //đọc file từ file txt
    public List<Kho> docDSKho(){
        //tạo mới danh sách mảng lưu
        List<Kho>khoList = new ArrayList<>();
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
                    Kho kho = new Kho(arr[0],arr[1],arr[2],arr[3]);
                    khoList.add(kho);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return khoList;
    }
    public void ghiFile(List<Kho>khoList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            //duyệt danh sách
            for (Kho kho:khoList
            ) {
                //ghi từng dòng
                fileWriter.write(kho.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
