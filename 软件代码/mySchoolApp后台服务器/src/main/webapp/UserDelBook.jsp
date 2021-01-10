<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="bean.Order_list" %>
    <%@page import="service.UserServiceImp" %>
    <%@page import="java.util.List" %>
    <%@page import="com.alibaba.fastjson.JSON" %>
    <%@page import="java.io.PrintWriter"%>
    
    <% 
        request.setCharacterEncoding("UTF-8");
        UserServiceImp user=new UserServiceImp();
		String idStr=request.getParameter("id");
		int id=Integer.parseInt(idStr);
		boolean result=user.DelBook(id);
		PrintWriter writer=response.getWriter();
		if(result)
			writer.write("true");
		else 
			writer.write("false");
			writer.flush();
			writer.close();
		%>