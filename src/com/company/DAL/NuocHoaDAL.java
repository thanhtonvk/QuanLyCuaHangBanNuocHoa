package com.company.DAL;

import com.company.Entities.NuocHoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NuocHoaDAL {
    //tạo file
    File file = new File("NuocHoa.txt");
    //đọc file từ file txt
    public List<NuocHoa>docDSNuocHoa(){
        //tạo mới danh sách mảng lưu
        List<NuocHoa>nuocHoaList = new ArrayList<>();
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
                    NuocHoa nuocHoa = new NuocHoa(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]),Integer.parseInt(arr[5]));
                    nuocHoaList.add(nuocHoa);
                }
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nuocHoaList;
    }
    public void ghiFile(List<NuocHoa>nuocHoaList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (NuocHoa nuocHoa:nuocHoaList
                 ) {
                fileWriter.write(nuocHoa.toString()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
