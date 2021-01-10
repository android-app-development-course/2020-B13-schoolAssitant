<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="bean.Book_list" %>
    <%@page import="service.UserServiceImp" %>
    <%@page import="java.util.List" %>
    <%@page import="com.alibaba.fastjson.JSON" %>
    <%@page import="java.io.PrintWriter"%>
    
    <% 
           UserServiceImp user=new UserServiceImp();
		    String type=request.getParameter("type");
	        List<Book_list> list=user.QueryBookByType(type);
	        String data=JSON.toJSONString(list);
		    PrintWriter writer=response.getWriter();
		    if(list!=null)
		    writer.write(data);
		    else
		    writer.write("没有搜索到！！！");
			writer.flush();
			writer.close();
		%>