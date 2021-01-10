package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserServiceImp;

public class UserDelBook extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        UserServiceImp user=new UserServiceImp();
		String idStr=request.getParameter("id");
		System.out.println(idStr);
		int id=Integer.parseInt(idStr);
		boolean result=user.DelBook(id);
		System.out.println(result);
		PrintWriter writer=response.getWriter();
		if(result)
			writer.write("true");
		else 
			writer.write("false");
			writer.flush();
			writer.close();
	}

}
