<%-- <%@page import="com.hrms.utitlities.DBUtil,java.sql.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.*" %>
<%@page import ="java.util.Date"%>


<%

int idno=Integer.parseInt(request.getParameter("idno"));
String date=request.getParameter("date");
int punchtypes=Integer.parseInt(request.getParameter("punchtypes"));
//out.println("response");
Connection con=DBUtil.getConnection();
int rs=0;
if(punchtypes==3){
	String sql="select hs.starttime from hr_muster h join  hr_shifts hs on"+
			" h.attendid=hs.shiftid where h.idno="+idno+" and h.attdate='"+date+"'";
	
	System.out.println(sql);
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	if(result.next()){
		
		time=result.getString(1);
	}
	
	String AddingDateWithTime=date+" "+time;
	//out.println(AddingDateWithTime);
	String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
	"values("+idno+",'"+AddingDateWithTime+"','I',9,9,'"+date+"','FR')";
	PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
	rs=pstm.executeUpdate();
}
if(punchtypes==4){
	String sql="select hs.endtime,hs.endtime-hs.starttime as difftime from hr_muster h join  hr_shifts hs on"+
			" h.attendid=hs.shiftid where h.idno="+idno+" and h.attdate='"+date+"'";
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	int differenceTime=0;
	if(result.next()){
		time=result.getString(1);
		differenceTime=result.getInt(2);
	}
	System.out.println(differenceTime);
	String updatedDate="";
	if(differenceTime<0){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date incdate = formatter.parse(date);
		try {
			  cal.setTime ( incdate );
			  int daysToIncrement = +1;
			    cal.add(Calendar.DATE, daysToIncrement);
			    incdate = cal.getTime();
			   updatedDate=formatter.format(incdate);
			    System.out.println(updatedDate+">>>>>>>>>>>");
			    
			    
			// convert your date to Calendar object
			} catch (Exception e) {
			    e.printStackTrace();
			}
	}else{
		updatedDate=date;
			
	}
	
	
	
	String AddingDateWithTime=updatedDate+" "+time;
	out.println(AddingDateWithTime);
	String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
	"values("+idno+",'"+AddingDateWithTime+"','O',9,9,'"+date+"','FR')";
	PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
	rs=pstm.executeUpdate();
}
if(punchtypes==5){
	String sql="select hs.lunchintime from hr_muster h join  hr_shifts hs on"+
			" h.attendid=hs.shiftid where h.idno="+idno+" and h.attdate='"+date+"'";
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	if(result.next()){
		
		time=result.getString(1);
	}
	
	if(time!=null ){
		System.out.println("cond satisfied");
		String AddingDateWithTime=date+" "+time;
		//out.println(AddingDateWithTime);
		String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
		"values("+idno+",'"+AddingDateWithTime+"','I',9,9,'"+date+"','FR')";
		PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
		rs=pstm.executeUpdate();
	}
	
}
if(punchtypes==6){
	String sql="select hs.lunchouttime from hr_muster h join  hr_shifts hs on"+
			" h.attendid=hs.shiftid where h.idno="+idno+" and h.attdate='"+date+"'";
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	if(result.next()){
		
		time=result.getString(1);
	}
	if(time!=null ){
	String AddingDateWithTime=date+" "+time;
	//out.println(AddingDateWithTime);
	String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
	"values("+idno+",'"+AddingDateWithTime+"','O',9,9,'"+date+"','FR')";
	PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
	rs=pstm.executeUpdate();
	}
	else{
		out.println("invalid input");
	}
}

if(punchtypes==7){
	String sql="select hs.starttime,(hs.duration/2) as diff from hr_shifts hs";
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	int minutes=0;
	int hours=0;
	if(result.next()){
		time=result.getString(1);
		minutes=result.getInt(2);
		hours=minutes/60;
	}
	
	String AddingDateWithTime=time+" "+hours;
 	System.out.println(AddingDateWithTime);
// 	String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
// 	"values("+idno+",'"+AddingDateWithTime+"','I',9,9,'"+date+"','FR')";
// 	PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
// 	rs=pstm.executeUpdate();
}
if(punchtypes==8){
	String sql="select hs.endtime,hs.endtime-hs.starttime as difftime from hr_muster h join  hr_shifts hs on"+
			" h.attendid=hs.shiftid where h.idno="+idno+" and h.attdate='"+date+"'";
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	int differenceTime=0;
	if(result.next()){
		time=result.getString(1);
		differenceTime=result.getInt(2);
	}
	System.out.println(differenceTime);
	String updatedDate="";
	if(differenceTime<0){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date incdate = formatter.parse(date);
		try {
			  cal.setTime ( incdate );
			  int daysToIncrement = +1;
			    cal.add(Calendar.DATE, daysToIncrement);
			    incdate = cal.getTime();
			   updatedDate=formatter.format(incdate);
			    System.out.println(updatedDate+">>>>>>>>>>>");
			    
			    
			// convert your date to Calendar object
			} catch (Exception e) {
			    e.printStackTrace();
			}
	}else{
		updatedDate=date;
			
	}
	
	
	
	String AddingDateWithTime=updatedDate+" "+time;
	out.println(AddingDateWithTime);
	String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
	"values("+idno+",'"+AddingDateWithTime+"','O',9,9,'"+date+"','FR')";
	PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
	rs=pstm.executeUpdate();
}

/*
if(punchtypes==9){
	String sql="select hs.endtime,hs.endtime-hs.starttime as difftime from hr_muster h join  hr_shifts hs on"+
			" h.attendid=hs.shiftid where h.idno="+idno+" and h.attdate='"+date+"'";
	Statement stm=con.createStatement();
	ResultSet result=stm.executeQuery(sql);
	String time="";
	int differenceTime=0;
	if(result.next()){
		time=result.getString(1);
		differenceTime=result.getInt(2);
	}
	System.out.println(differenceTime);
	String updatedDate="";
	if(differenceTime<0){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date incdate = formatter.parse(date);
		try {
			  cal.setTime ( incdate );
			  int daysToIncrement = +1;
			    cal.add(Calendar.DATE, daysToIncrement);
			    incdate = cal.getTime();
			   updatedDate=formatter.format(incdate);
			    System.out.println(updatedDate+">>>>>>>>>>>");
			    
			    
			// convert your date to Calendar object
			} catch (Exception e) {
			    e.printStackTrace();
			}
	}else{
		updatedDate=date;
			
	}
	
	
	
	String AddingDateWithTime=updatedDate+" "+time;
	out.println(AddingDateWithTime);
	String insertQueryToHrPunches="insert into hr_punches(idno,punchtime,ioflag,machineid,punchtype,attdate,punchstatus) "+
	"values("+idno+",'"+AddingDateWithTime+"','O',9,9,'"+date+"','FR')";
	PreparedStatement pstm=con.prepareStatement(insertQueryToHrPunches);
	rs=pstm.executeUpdate();
}
*/
if(rs>0){
	out.println("updatedsucess");
}
else{
	out.println("invalid data");
}

con.close();

%> --%>