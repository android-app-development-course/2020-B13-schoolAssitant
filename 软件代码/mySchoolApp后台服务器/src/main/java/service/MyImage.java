package service;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import bean.Book_list;
import bean.Picture_list;

public class MyImage {
	
	 //图片到byte数组
     public  byte[] image2byte(String path){
     byte[] data = null;
      FileImageInputStream input = null;
      try {
        input = new FileImageInputStream(new File(path));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
       while ((numBytesRead = input.read(buf)) != -1) {
       output.write(buf, 0, numBytesRead);
       }
       data = output.toByteArray();
       output.close();
       input.close();
     }
     catch (Exception e) {
      return null;
     }
     return data;
     }
     
     
     //保存图片
     public boolean byte2image(byte[] data,String path){
         if(data.length<3||path.equals("")) return false;
        try{
         FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
         imageOutput.write(data, 0, data.length);
         imageOutput.close();
         } catch(Exception e) {
         return false;
        }
        return true;
      }
     
     //删除图片
     public boolean delPicture(String path)
     {
    	 File file=new File(path);
    	 if(file.exists()&&file.delete())
    	    return true;
    	 else {
			return false;
		}
     }

 //遍历所有图片文件
     public List<Picture_list> getAllPicture(String path)
     {
    	 List<Picture_list> map=new ArrayList<Picture_list>();
    	 File file = new File(path);
 		 File[] fs = file.listFiles();
 		for (File f : fs) {
			String name=f.getName();
			String pername=name.substring(0,name.length()-4);
			Picture_list p=new Picture_list(pername,image2byte(path+"/"+name));
			map.add(p);
		}
 		return map;
   
     }
     
     
     
     
     
}