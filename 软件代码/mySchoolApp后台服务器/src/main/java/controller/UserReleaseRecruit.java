package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Recruit_list;
import service.UserServiceImp;

public class UserReleaseRecruit extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		   request.setCharacterEncoding("UTF-8");
		   response.setCharacterEncoding("UTF-8");
	       UserServiceImp user=new UserServiceImp();
			String recruitStr=request.getParameter("recruit");
			Recruit_list getRecruit=JSON.parseObject(recruitStr,Recruit_list.class);
			System.out.println( getRecruit);
			int result=user.Recruitment(getRecruit);
			PrintWriter writer=response.getWriter();
			if(result>0)
				writer.write(String.valueOf(result));
			else 
				writer.write("0");
		
				writer.flush();
				writer.close();
	}

}
