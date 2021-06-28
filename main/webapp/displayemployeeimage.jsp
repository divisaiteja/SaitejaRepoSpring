<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

int idno=Integer.parseInt(request.getParameter("idno"));
Connection con=DBUtil.getConnection();
Statement stm=con.createStatement();
String sql="select empid,photo from hr_employeephotos where empid="+idno+" order by id desc";		        	

ResultSet rs=stm.executeQuery(sql);

%>
<%if(rs.next()){ %>
<%out.println("<img width='120' id='profileimg' class=' center-block' height='100' src=display?empid=" + rs.getInt(1) + "> </img><p/>"); %>
<%} %>
</body>
</html>