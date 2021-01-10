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
       String account=request.getParameter("account");
        String data;
        UserServiceImp service=new UserServiceImp();
        List<Recruit_list> list =service.getMyRecruit(account);
		data=JSON.toJSONString(list);
		PrintWriter writer=response.getWriter();
		writer.write(data);
		writer.flush();
		writer.close();
		%>
