package com.hrms.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hrms.utitlities.DBUtil;


@Repository
public class MonthlyAttendenceDaoImpl implements MonthlyAttendenceDao {

	@Override
	public List<Map<Object, Object>> getMonthlyAttendence(int project, int division, int year, int month,String fromdate,String todate) {
		Connection connection = null;
		Statement statement = null;
		Statement statement1 = null;
		Statement statement2 = null;
		List<Map<Object,Object>> arrayList = new ArrayList<Map<Object,Object>>();

		
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs3 = null;
		String 	startdate="";
		String 	enddate="";
		int noofdays=0;
		int monthdate=0;
		int monthenddate=0;
	if(month>0) {
		 YearMonth yearMonth = YearMonth.of( year, month);  // January of 2015.
		 LocalDate firstOfMonth = yearMonth.atDay( 1 );
		 LocalDate last = yearMonth.atEndOfMonth();
		 	startdate=firstOfMonth.toString()  ;
		 	enddate=last.toString();
		System.out.println(startdate);
		System.out.println(enddate);
		monthdate= firstOfMonth.getDayOfMonth();
		monthenddate = last.getDayOfMonth();
		 noofdays= (monthenddate-monthdate)+1;
		System.out.println(">>>>>>noofdays>>>>>>>"+noofdays);
		}else {
			try {
				/*passing fromdate and todate*/
			        startdate=fromdate;
					enddate=todate;
			       Date sdate=new SimpleDateFormat("yyyy-MM-dd").parse(startdate);  
			       Date edate=new SimpleDateFormat("yyyy-MM-dd").parse(enddate);  
			      
			       ZoneId defaultZoneId = ZoneId.systemDefault();
					
			   	//Converting the date to Instant
			   	Instant instant = sdate.toInstant();
				Instant instant1 = edate.toInstant();	
			   	//Converting the Date to LocalDate
			   
				LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
				LocalDate localDate1 = instant1.atZone(defaultZoneId).toLocalDate();
				
				List<Date> dates=new ArrayList<Date>();
				
				DateFormat formater;
				formater=new SimpleDateFormat("yyyy-MM-dd");
				Date start = formater.parse(fromdate);
				Date end = formater.parse(todate);
				long interval = 24*1000 * 60 * 60; // 1 hour in millis
				long endTime =end.getTime() ; // create your endtime here, possibly using Calendar or Date
				long curTime = start.getTime();
				while (curTime <= endTime) {
				    dates.add(new Date(curTime));
				    curTime += interval;
				}
				for(int i=0;i<dates.size();i++){
				    Date lDate =(Date)dates.get(i);
				    String ds = formater.format(lDate);    
				    System.out.println(" Date is ..." + ds);
				    SimpleDateFormat inFormat1 = new SimpleDateFormat("yyyy-MM-dd");
				    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEE");
				    String dayName1=simpleDateFormat1.format(lDate);
				    LocalDate date = LocalDate.parse(ds);
				    int   date1= date.getDayOfMonth();
			        System.out.println("firstPartfirstP     "+date1);

				    String  dayname2=dayName1.toString();
				    String firstPart = dayname2.substring(0, 3);
				    Map<Object,Object> map1 = new HashMap<Object,Object>();	
				    map1.put("dayname", date1 +firstPart);
				    System.out.println("firstPartfirstPart"+firstPart);
				    arrayList.add(map1);
				}
				
				monthdate=localDate.getDayOfMonth();
				System.out.println("monthdate....."+monthdate);
				monthenddate=localDate1.getDayOfMonth();
				System.out.println("monthenddate....."+monthenddate);
				noofdays=(monthenddate-monthdate)+1;
				System.out.println(">>>>>>noofdays>>>>>>>"+noofdays);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		connection =DBUtil.getConnection();
		try {
			
			String ismanual="";
			int slno=0;
			statement=connection.createStatement();
			statement1=connection.createStatement();
			statement2=connection.createStatement();
			String sql="select e.empname,e.idno,e.desgn,sum(inpunchcount+outpunchcount) as pcount, sum(lop>0) as lopcount,sum(leaves>0) as leavecount from hr_muster h,hr_empmaster e where e.idno=h.idno  and   attdate>='"+startdate+"' and attdate<='"+enddate+"' and e.workingdivisionid="+division+" and e.project="+project+" group by e.empname,e.idno,e.desgn order by idno";
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			 while(rs.next()) {
				 Map<Object,Object> map = new HashMap<Object,Object>();
				 slno=slno+1;
				 String ltype="";
				 float tpre=0f;
				 map.put("slno", slno);
				 map.put("employeename", rs.getString("empname"));
				 map.put("idno", rs.getInt("idno"));
				 map.put("Father", "Father");
				 map.put("desgn",rs.getString("desgn"));
				 map.put("GroupNo", "0");
				 map.put("RelayNo", "0");
				 map.put("From", "0");
				 map.put("To", "0");
				 map.put("From", "0");
				 map.put("To", "0");
				 map.put("lopcount",rs.getFloat("lopcount") );
				 map.put("leavecount", rs.getFloat("leavecount"));
				String sql1="select *,day(attdate) as d,attdate from hr_muster h  where  attdate>='"+startdate+"' and attdate<='"+enddate+"' and h.idno="+rs.getInt("idno")+ " order by attdate";
				System.out.println(sql1);

				rs1=statement1.executeQuery(sql1);
				 int i=1;
				 int j=1;
				 while (rs1.next()) {
					j =rs1.getInt("d");
					Date date=rs1.getDate("attdate");
					SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
					// Date myDate = inFormat.parse(2020+"-"+3+"-"+31);
		    	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		    	       String dayName=simpleDateFormat.format(date);
		    	       System.out.println(dayName);
		    	    
		    	      
					System.out.println("j    "+j);
					if(i==31) {
						map.put("c"+i, "-");
						i=i+1;
						System.out.println("i    "+i);
					}
					
					if(j==i) {
						if(rs1.getInt("present")>0) {
							tpre=tpre+1;
						String	sql12="select count(*) as  pcount from hr_punches where attdate='"+rs1.getDate("attdate")+ "' and punchtype=9";
						  rs3 = statement2.executeQuery(sql12);
						  ismanual="";
						  if(rs3.next()) {
							  if(rs3.getInt("pcount")>0) {
								  ismanual="<span style='background-color:yellow;'>"; 
							  }
						  }rs3.close();
						  if(rs1.getInt("present")==1) {
							  map.put("c"+i, ismanual+"p");
						  }else {
							map.put("c"+i,ismanual+"p" );
						}
						}
						else if (rs1.getInt("lop")>0) {
							if(rs1.getInt("lop")==1) {
								if(rs.getInt("pcount")>0) {
									map.put("c"+i, "<font color='blue'>*</font>");
								}else {
									map.put("c"+i, "<font color='red'>A</font>");
								}
							}else {
								map.put("c"+i, "A/");
							}
						}
						//
						
						if(rs1.getInt("leaves")>0) {
							tpre=tpre+1;
							if(rs1.getInt("clcount")>0) {
								 ltype="CL"; 
							}else if(rs1.getInt("slcount")>0){
                                ltype="SL";
                            }else if(rs1.getInt("elcount")>0){
                                ltype="EL";
                            }else if(rs1.getInt("cocount")>0){
                                ltype="CO";
                            }
							map.put("C"+i, "<font color='lightgreen'>"+ltype+"</font>");
						}else if(rs1.getInt("wh")>0){
                            tpre=tpre+1;                                              
                          map.put("C"+i, "WO");
                      } else if(rs1.getInt("ph")>0){
                          tpre=tpre+1;                                              
                        map.put("C"+i, "PH");
                    } else if(rs1.getInt("od")>0){
                          tpre=tpre+1;                                              
                        map.put("C"+i, "OD");
                    }
					}
					 i=j+1;
					 System.out.println(">>>>>>>>>>>"+i);
				}
				 while(i==31){
                     map.put("C"+i, "-");
                     i=i+1;
                }
				 map.put("TPre",tpre);
				 map.put("rateofwages", "0");
				 map.put("gross", "0");
				 map.put("total", "0");
				 map.put("netamount", "0");
				 map.put("signature", "");
				 arrayList.add(map);
			 }
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return arrayList  ;

	}

	@Override
	public List<Object> getDateAndDayName(String fromdate,String todate)
	{
		List<Object> arrayList = new ArrayList<Object>();

		String 	startdate="";
		String 	enddate="";
		try {
			/*passing fromdate and todate*/
		        startdate=fromdate;
				enddate=todate;
		       Date sdate=new SimpleDateFormat("yyyy-MM-dd").parse(startdate);  
		       Date edate=new SimpleDateFormat("yyyy-MM-dd").parse(enddate);  
		      
		       ZoneId defaultZoneId = ZoneId.systemDefault();
				
		   	//Converting the date to Instant
		   	Instant instant = sdate.toInstant();
			Instant instant1 = edate.toInstant();	
		   	//Converting the Date to LocalDate
		   
			LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
			LocalDate localDate1 = instant1.atZone(defaultZoneId).toLocalDate();
			
			List<Date> dates=new ArrayList<Date>();
			
			DateFormat formater;
			formater=new SimpleDateFormat("yyyy-MM-dd");
			Date start = formater.parse(fromdate);
			Date end = formater.parse(todate);
			long interval = 24*1000 * 60 * 60; // 1 hour in millis
			long endTime =end.getTime() ; // create your endtime here, possibly using Calendar or Date
			long curTime = start.getTime();
			while (curTime <= endTime) {
			    dates.add(new Date(curTime));
			    curTime += interval;
			}
			for(int i=0;i<dates.size();i++){
			    Date lDate =(Date)dates.get(i);
			    String ds = formater.format(lDate);    
			    System.out.println(" Date is ..." + ds);
			    SimpleDateFormat inFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEE");
			    String dayName1=simpleDateFormat1.format(lDate);
			    LocalDate date = LocalDate.parse(ds);
			    int   date1= date.getDayOfMonth();
		        System.out.println("firstPartfirstP     "+date1);

			    String  dayname2=dayName1.toString();
			    String firstPart = dayname2.substring(0, 3);
			   /* Map<Object> map1 = new HashMap<Object>();	
			    map1.put( date1 +firstPart);*/
			    System.out.println("firstPartfirstPart"+firstPart);
			    arrayList.add(date1 +"<br>"+firstPart);
	}
		}catch (Exception e) {
		e.printStackTrace();
		}
			return arrayList ;		
}

	@Override
	public List<Object> GetCCount(int project, int division,String fromdate, String todate) {
		Connection connection = null;
		Statement statement = null;
		Statement statement1 = null;
		Statement statement2 = null;
		List<Object> arrayList = new ArrayList<Object>();
    	ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs3 = null;
		String 	startdate="";
		String 	enddate="";
			
				/*passing fromdate and todate*/
			        startdate=fromdate;
					enddate=todate;		      
		connection =DBUtil.getConnection();
		try {
			
			String ismanual="";
			int slno=0;
			statement=connection.createStatement();
			statement1=connection.createStatement();
			statement2=connection.createStatement();
			String sql="select e.empname,e.idno,e.desgn,sum(inpunchcount+outpunchcount) as pcount, sum(lop>0) as lopcount,sum(leaves>0) as leavecount from hr_muster h,hr_empmaster e where e.idno=h.idno  and   attdate>='"+startdate+"' and attdate<='"+enddate+"' and e.workingdivisionid="+division+" and e.project="+project+" group by e.empname,e.idno,e.desgn order by idno";
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			 while(rs.next()) {
				 Map<Object,Object> map = new HashMap<Object,Object>();
				 slno=slno+1;
				 String ltype="";
				 float tpre=0f;
				/* map.put("slno", slno);
				 map.put("employeename", rs.getString("empname"));
				 map.put("idno", rs.getInt("idno"));
				 map.put("Father", "Father");
				 map.put("desgn",rs.getString("desgn"));
				 map.put("GroupNo", "0");
				 map.put("RelayNo", "0");
				 map.put("From", "0");
				 map.put("To", "0");
				 map.put("From", "0");
				 map.put("To", "0");
				 map.put("lopcount",rs.getFloat("lopcount") );
				 map.put("leavecount", rs.getFloat("leavecount"));*/
				String sql1="select *,day(attdate) as d,attdate from hr_muster h  where  attdate>='"+startdate+"' and attdate<='"+enddate+"' and h.idno="+rs.getInt("idno")+ " order by attdate";
				//System.out.println(sql1);

				rs1=statement1.executeQuery(sql1);
				 int i=1;
				 int j=1;
				 while (rs1.next()) {
					j =rs1.getInt("d");
					/*Date date=rs1.getDate("attdate");
					SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
					// Date myDate = inFormat.parse(2020+"-"+3+"-"+31);
		    	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		    	       String dayName=simpleDateFormat.format(date);
		    	       System.out.println(dayName);
		    	    */
		    	      
					System.out.println("j    "+j);
					if(i==31) {
						map.put("c"+i, "-");
						i=i+1;
						System.out.println("i    "+i);
					}
					
					if(j==i) {
						if(rs1.getInt("present")>0) {
							tpre=tpre+1;
						String	sql12="select count(*) as  pcount from hr_punches where attdate='"+rs1.getDate("attdate")+ "' and punchtype=9";
						  rs3 = statement2.executeQuery(sql12);
						  ismanual="";
						  if(rs3.next()) {
							  if(rs3.getInt("pcount")>0) {
								  ismanual="<span style='background-color:yellow;'>"; 
							  }
						  }rs3.close();
						  if(rs1.getInt("present")==1) {
							  map.put("c"+i, ismanual+"p");
						  }else {
							map.put("c"+i,ismanual+"p" );
						}
						}
						else if (rs1.getInt("lop")>0) {
							if(rs1.getInt("lop")==1) {
								if(rs.getInt("pcount")>0) {
									map.put("c"+i, "<font color='blue'>*</font>");
								}else {
									map.put("c"+i, "<font color='red'>A</font>");
								}
							}else {
								map.put("c"+i, "A/");
							}
						}
						//
						
						if(rs1.getInt("leaves")>0) {
							tpre=tpre+1;
							if(rs1.getInt("clcount")>0) {
								 ltype="CL"; 
							}else if(rs1.getInt("slcount")>0){
                                ltype="SL";
                            }else if(rs1.getInt("elcount")>0){
                                ltype="EL";
                            }else if(rs1.getInt("cocount")>0){
                                ltype="CO";
                            }
							map.put("C"+i, "<font color='lightgreen'>"+ltype+"</font>");
						}else if(rs1.getInt("wh")>0){
                            tpre=tpre+1;                                              
                          map.put("C"+i, "WO");
                      } else if(rs1.getInt("ph")>0){
                          tpre=tpre+1;                                              
                        map.put("C"+i, "PH");
                    } else if(rs1.getInt("od")>0){
                          tpre=tpre+1;                                              
                        map.put("C"+i, "OD");
                    }
					}
					 i=j+1;
					 System.out.println(">>>>>>>>>>>"+i);
				}
				 while(i==31){
                     map.put("C"+i, "-");
                     i=i+1;
                }
				 map.put("TPre",tpre);
				// arrayList.add(map);
				//List<Object> arrayList2 = new ArrayList<Object>(map.keySet());
				List<Object> arrayList3 = new ArrayList<Object>(map.values());
				
				// arrayList.add(arrayList2);
				 arrayList.add(arrayList3);
				 System.out.println(">>>>>>>>>>>"+arrayList) ;
			 }
			 
			 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return arrayList  ;
	}
}
