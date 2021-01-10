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

public class Register extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
        String user=request.getParameter("user");
        User_list getUser=JSON.parseObject(user,User_list.class);
        System.out.println(getUser);
        UserServiceImp service=new UserServiceImp();
        boolean result=service.register(getUser);
        PrintWriter writer=response.getWriter();
        if(result)
        writer.write("true");
        else
        writer.write("false");
        writer.flush();
        writer.close();
	}

}
