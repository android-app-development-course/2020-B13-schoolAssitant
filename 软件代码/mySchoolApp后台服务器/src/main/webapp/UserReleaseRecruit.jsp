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
       UserServiceImp user=new UserServiceImp();
		String recruitStr=request.getParameter("recruit");
		Recruit_list getRecruit=JSON.parseObject(recruitStr,Recruit_list.class);
		int result=user.Recruitment(getRecruit);
		PrintWriter writer=response.getWriter();
		if(result>0)
			writer.write("true");
		else 
			writer.write("false");
	
			writer.flush();
			writer.close();
		%>