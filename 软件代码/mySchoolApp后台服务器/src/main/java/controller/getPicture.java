package controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.PictureServiceImp;

public class getPicture extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		 request.setCharacterEncoding("UTF-8");
		 response.setHeader("content-type", "text/html;charset=UTF-8");
		String url=request.getParameter("url");
		String name=request.getParameter("name");
        PictureServiceImp p=new PictureServiceImp();
        byte[] result=p.getPicture(url, name);
        response.getOutputStream().write(result);
        response.getOutputStream().flush(); 
        response.getOutputStream().close();
	}
}
