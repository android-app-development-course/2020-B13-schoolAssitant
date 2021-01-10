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

public class UserModifyInformation extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        UserServiceImp user=new UserServiceImp();
		String userStr=request.getParameter("user");
		User_list getUser=JSON.parseObject(userStr,User_list.class);
		boolean result=user.ModifyInformation(getUser);
		PrintWriter writer=response.getWriter();
		if(result)
			writer.write("true");
		else 
			writer.write("false");
			writer.flush();
			writer.close();
	}

}
