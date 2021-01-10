package controller;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Picture_list;
import service.PictureServiceImp;

public class getAllPicture extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String url=request.getParameter("url");
		String name=request.getParameter("name");
		System.out.println(url+"8888"+name);
		response.setHeader("content-type", "text/html;charset=UTF-8");
       InputStream in=request.getInputStream();
       byte[] a=new byte[5120];
       a=in.readAllBytes();
       url="D://pictureApp";
      // url="D://数据文件/myeclipseWorkplace/mySchoolApp/image/book_picture";
       PictureServiceImp p=new PictureServiceImp();
       List<Picture_list> result=p.getAllBookPicture(url);
       for(Picture_list b :result) {
    	   response.getOutputStream().write(b.getData());
    	   System.out.println(b.getData());
           //response.getOutputStream().flush(); 
         System.out.println("成功");
       }
       response.getOutputStream().close();
	}
}