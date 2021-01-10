package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserServiceImp;

public class Login extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{

       request.setCharacterEncoding("UTF-8");
       response.setHeader("content-type", "text/html;charset=UTF-8");
       String account=request.getParameter("account").trim();
       String password=request.getParameter("password").trim();
       UserServiceImp service=new UserServiceImp();
       boolean result=service.login(account, password);
       PrintWriter writer=response.getWriter();
       if(result)
          writer.write("true");
       else
          writer.write("false");
          writer.flush();
          writer.close();
	}
}


