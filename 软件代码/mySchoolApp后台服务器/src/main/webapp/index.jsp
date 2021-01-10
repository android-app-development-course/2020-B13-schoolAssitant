  <%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.io.ByteArrayOutputStream" %>
    <%@page import="javax.imageio.stream.FileImageInputStream" %>
    <%@page import="javax.imageio.stream.FileImageOutputStream" %>
    <%@page import="com.alibaba.fastjson.JSON" %>
    <%@page import="java.io.PrintWriter"%>
    <%@page import="service.MyImage"%>
    <%@page import="java.util.List"%>
    <%@page import="bean.*"%>
    <%@page import="service.*"%>
    
    
<% 

	       request.setCharacterEncoding("UTF-8");
	       MyImage x=new MyImage();
	       response.setHeader("content-type", "text/html;charset=UTF-8");
	       //PictureServiceImp p=new PictureServiceImp();
	       //List<Picture_list> map=p.getAllBookPicture("D://数据文件/myeclipseWorkplace/mySchoolApp/image/book_picture");
	       //System.out.println(map);
           //String data=JSON.toJSONString(map);
          // System.out.println("------------------------------>");
          // System.out.println(data);
          // PrintWriter writer=response.getWriter();
		  // writer.write(data);
		  // writer.flush();
		 //  writer.close();
		 // PictureServiceImp p=new PictureServiceImp();
       //List<Picture_list> result=p.getAllBookPicture("D://pictureApp");
       //for(Picture_list b :result) {
    	//   response.getOutputStream().write(b.getData());
        //   response.getOutputStream().flush(); 
        //    System.out.println("--------------->>>>>"+b.getData().length);
         //    System.out.println(b.getName());
       //  System.out.println("成功");
      // }
      // response.getOutputStream().flush(); 
      // response.getOutputStream().close();
		 request.setCharacterEncoding("UTF-8");
       String account=request.getParameter("account");
       String password=request.getParameter("password");
       UserServiceImp service=new UserServiceImp();
       boolean result=service.login(account, password);
       System.out.println(result);
       PrintWriter writer=response.getWriter();
       if(result)
          writer.write("true");
       else
          writer.write("false");
          writer.flush();
          writer.close();
    
%>
