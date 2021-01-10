package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Order_list;
import service.UserServiceImp;

public class UserOrderBook extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        UserServiceImp user=new UserServiceImp();
		String orderStr=request.getParameter("order");
		Order_list getOrder=JSON.parseObject(orderStr,Order_list.class);
		boolean result=user.OrderBook(getOrder);
		System.out.println(getOrder);
		PrintWriter writer=response.getWriter();
		if(result)
			writer.write("true");
		else 
			writer.write("false");
			writer.flush();
			writer.close();
	}

}
