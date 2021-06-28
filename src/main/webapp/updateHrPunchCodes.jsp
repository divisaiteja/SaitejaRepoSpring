<%@page import="com.hrms.utitlities.DBUtil,java.sql.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.*" %>
<%@page import ="java.util.Date"%>



<%
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

int tranid=Integer.parseInt(request.getParameter("tranid"));
int modifyType=Integer.parseInt(request.getParameter("modifyType"));
String attdate=request.getParameter("attdate");
Calendar cal = Calendar.getInstance();
Date date = formatter.parse(attdate);
try {
  System.out.println(formatter.format(date));
  cal.setTime ( date ); // convert your date to Calendar object
} catch (Exception e) {
    e.printStackTrace();
}

Connection con=DBUtil.getConnection();
int rs=0;
if(modifyType==10){// where 10 is nothing but visilence
	String sql="update hr_punches set ioflag='V' where tranid="+tranid;
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeUpdate();	
}
if(modifyType==11){
	
	System.out.println("move to previous date");
	 int daysToDecrement = -1;
	    cal.add(Calendar.DATE, daysToDecrement);
	    date = cal.getTime();
	   
	    String updatedDate=formatter.format(date);
	    System.out.println(updatedDate+">>>>>>>>>>>");
	    String sql="update hr_punches set attdate='"+updatedDate+"' where tranid="+tranid;
		PreparedStatement pstm=con.prepareStatement(sql);
		rs=pstm.executeUpdate();   
}

if(modifyType==12){
	
	System.out.println("move to next date");
	 int daysToIncrement = +1;
	    cal.add(Calendar.DATE, daysToIncrement);
	    date = cal.getTime();
	   
	    String updatedDate=formatter.format(date);
	    System.out.println(updatedDate+">>>>>>>>>>>");
	    String sql="update hr_punches set attdate='"+updatedDate+"' where tranid="+tranid;
		PreparedStatement pstm=con.prepareStatement(sql);
		rs=pstm.executeUpdate();   
}

if(modifyType==13){
	String sql="update hr_punches set ioflag='I' where tranid="+tranid;
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeUpdate();	
}

if(modifyType==14){
	String sql="update hr_punches set ioflag='O' where tranid="+tranid;
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeUpdate();	
}
if(modifyType==15){
	String sql="update hr_punches set ioflag='M' where tranid="+tranid;
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeUpdate();	
}
if(modifyType==16){

	String sql="update hr_punches set punchstatus='DL' where tranid="+tranid;
	PreparedStatement pstm=con.prepareStatement(sql);
	rs=pstm.executeUpdate();	
}
if(rs>0){
	out.println("updatedsucess");
}
else{
	out.println("notdone");
}

out.println("hi");
con.close();
%>