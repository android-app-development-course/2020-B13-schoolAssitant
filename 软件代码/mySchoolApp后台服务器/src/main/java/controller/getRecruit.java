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

import bean.Recruit_list;
import service.PageServiceImp;

public class getRecruit extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		 response.setHeader("content-type", "text/html;charset=UTF-8");
        String data;
        PageServiceImp login=new PageServiceImp();
        List<Recruit_list> list =login.getRecruit();
		data=JSON.toJSONString(list);
		PrintWriter writer=response.getWriter();
		writer.write(data);
		writer.flush();
		writer.close();
	}

}
