<%@page import="service.UserServiceImp"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="bean.Recruit_list" %>
    <%@page import="service.PageServiceImp" %>
    <%@page import="java.util.List" %>
    <%@page import="com.alibaba.fastjson.JSON" %>
    <%@page import="java.io.PrintWriter"%>
    <% 
    
       request.setCharacterEncoding("UTF-8");
        String idStr=request.getParameter("id");
        int id=Integer.parseInt(idStr);
        UserServiceImp service=new UserServiceImp();
        boolean result=service.DelRecruit(id);
		PrintWriter writer=response.getWriter();
		if(result)
			writer.write("true");
		else 
			writer.write("false");
		writer.flush();
		writer.close();
		%>

