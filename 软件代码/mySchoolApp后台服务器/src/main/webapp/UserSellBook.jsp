<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="bean.Book_list" %>
    <%@page import="service.UserServiceImp" %>
    <%@page import="java.util.List" %>
    <%@page import="com.alibaba.fastjson.JSON" %>
    <%@page import="java.io.PrintWriter"%>
    
    <% 
        request.setCharacterEncoding("UTF-8");
        UserServiceImp user=new UserServiceImp();
		String bookStr=request.getParameter("book");
		Book_list getbook=JSON.parseObject(bookStr,Book_list.class);
		int result=user.SellBook(getbook);
		System.out.println(getbook);
		PrintWriter writer=response.getWriter();
		if(result>0)
			writer.write("true");
		else 
			writer.write("false");
			writer.flush();
			writer.close();
		%>