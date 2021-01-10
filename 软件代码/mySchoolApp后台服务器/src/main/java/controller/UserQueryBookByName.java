package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Book_list;
import service.UserServiceImp;

public class UserQueryBookByName extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		   request.setCharacterEncoding("UTF-8");
		   response.setCharacterEncoding("UTF-8");
           UserServiceImp user=new UserServiceImp();
		    String name=request.getParameter("name");
	        List<Book_list> list=user.QueryBookByName(name);
	        String data=JSON.toJSONString(list);
		    PrintWriter writer=response.getWriter();
		    if(list!=null)
		    writer.write(data);
		    else
		    writer.write("没有搜索到！！！");
			writer.flush();
			writer.close();
	}

}
