package controller;

import static org.junit.jupiter.api.Assertions.assertTimeout;

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
import service.PageServiceImp;

public class getBook extends HttpServlet{

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        String data;
        PageServiceImp login=new PageServiceImp();
        List<Book_list> list =login.getBook();
		data=JSON.toJSONString(list);
		System.out.println(data);
		PrintWriter writer=response.getWriter();
		writer.write(data);
		writer.flush();
		writer.close();
	}

}
