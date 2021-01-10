<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="bean.User_list" %>
    <%@page import="service.UserServiceImp" %>
    <%@page import="java.util.List" %>
    <%@page import="com.alibaba.fastjson.JSON" %>
    <%@page import="java.io.PrintWriter"%>
    
    <% 
   
       request.setCharacterEncoding("UTF-8");
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
		%>