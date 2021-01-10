package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.User_list;
import service.UserServiceImp;

public class getUser extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{

       request.setCharacterEncoding("UTF-8");
       response.setHeader("content-type", "text/html;charset=UTF-8");
       String account=request.getParameter("account").trim();
       UserServiceImp service=new UserServiceImp();
        User_list list=service.getUser(account);
        String data;
        data=JSON.toJSONString(list);
		PrintWriter writer=response.getWriter();
		writer.write(data);
		writer.flush();
		writer.close();
	}
}
