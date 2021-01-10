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
		    String account=request.getParameter("account");
	        List<Book_list> list=user.getMyBook(account);
	        String data=JSON.toJSONString(list);
		    PrintWriter writer=response.getWriter();
		    writer.write(data);
			writer.flush();
			writer.close();
		%>