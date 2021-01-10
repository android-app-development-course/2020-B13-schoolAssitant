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
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        UserServiceImp service=new UserServiceImp();
        boolean result=service.login(account, password);
        PrintWriter writer=response.getWriter();
        if(result)
        writer.write("true");
        else
        writer.write("false");
        writer.flush();
        writer.close();
		%>

