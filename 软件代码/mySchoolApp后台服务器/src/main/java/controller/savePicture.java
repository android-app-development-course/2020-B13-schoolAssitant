package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PictureServiceImp;
public class savePicture extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String url=request.getParameter("url");
		String name=request.getParameter("name");
		
       InputStream in=request.getInputStream();
       byte[] a=in.readAllBytes();
       PictureServiceImp p=new PictureServiceImp();
       Boolean result=p.SavePicture(url, name,a);
       PrintWriter writer=response.getWriter();
       in.close();
       if(result)
			writer.write("true");
		else 
			writer.write("false");
	}
	
}
