package com.hrms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.LeaveBalanceDTO;
import com.hrms.dtos.LeaveTypeDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;
import com.hrms.utitlities.dateUtils;

@Repository
public class LeaveTypeDaoImpl implements LeaveTypeDao {
	@Autowired
	private JdbcTemplate template;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String date = dateFormat.format(new Date());
	float countOfLeavesDays = 0.0f;
	int noOfWeekDays=0;

        
	@Override
	public List<LeaveTypeDTO> getAllLeaveType() {

		return template.query("select transid,leavetype from hr_leavetypes",
				new ResultSetExtractor<List<LeaveTypeDTO>>() {
					@Override
					public List<LeaveTypeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<LeaveTypeDTO> listdto = new ArrayList<LeaveTypeDTO>();
						while (rs.next()) {
							LeaveTypeDTO dto = new LeaveTypeDTO();
							dto.setTransid(rs.getInt(1));

							dto.setLeavetype(rs.getString(2));

							listdto.add(dto);
						}
						return listdto;
					}

				});

	}

	@Override
	public List<LeaveTypeDTO> getAllLeavedebits( int idno) {

		return template.query(
				"select ld.transid,createdon,leavetype,fromdate,todate,noofdays,reasonforleave,docstatus from hr_leavedebits ld, hr_leavetypes lt where ld.leavetypeid=lt.transid and idno="
						+ idno,
				new ResultSetExtractor<List<LeaveTypeDTO>>() {
					@Override
					public List<LeaveTypeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<LeaveTypeDTO> listdto = new ArrayList<LeaveTypeDTO>();
						int no = 1;

						while (rs.next()) {
							LeaveTypeDTO dto = new LeaveTypeDTO();

							dto.setSno(no++);
							
							dto.setTransid(rs.getInt(1));
							dto.setCreatedon(rs.getDate(2));
							dto.setLeavetype(rs.getString(3));
							
							
							dto.setFromdate(rs.getString(4));
							dto.setTodate(rs.getString(5));
							dto.setNoofdays(rs.getFloat(6));
							dto.setReasonforleave(rs.getString(7));
							dto.setDocstatus(rs.getString(8));

							listdto.add(dto);
						}
						return listdto;
					}

				});

	}

	@Override
	public void addnewLeave(final LeaveTypeDTO leavetypeDTO) {
		
		float balance=getLeaveBalance(leavetypeDTO.getIdno(),leavetypeDTO.getLeavetypeid());
		if(leavetypeDTO.getNoofdays()<=balance) {
			 final String sql="insert into hr_leavedebits(idno,leavetypeid,fromdate,todate,noofdays,reasonforleave,fhalfday,thalfday,spanno,createdon,docstatus) values(?,?,?,?,?,?,?,?,?,?,?)";
				KeyHolder holder = new GeneratedKeyHolder();
				final String currentDateandTime=dateUtils.getCurrentDateAndtime();
				int resultentValue= template.update(new PreparedStatementCreator() {           

				                @Override
				                public PreparedStatement createPreparedStatement(Connection connection)
				                        throws SQLException {
				                    PreparedStatement ps = connection.prepareStatement(sql.toString(),
				                        Statement.RETURN_GENERATED_KEYS); 
				                    ps.setInt(1, leavetypeDTO.getIdno());
				                    ps.setInt(2, leavetypeDTO.getLeavetypeid());
				                    ps.setString(3, leavetypeDTO.getFromdate());
				                    ps.setString(4, leavetypeDTO.getTodate());
				                    ps.setFloat(5, leavetypeDTO.getNoofdays());
				                    ps.setString(6, leavetypeDTO.getReasonforleave());
				                    ps.setFloat(7, leavetypeDTO.getFhalfday());
				                    ps.setFloat(8, leavetypeDTO.getThalfday() );
									ps.setInt(9, 0);
									ps.setString(10, currentDateandTime);
									ps.setString(11, "FR");
				                    return ps;
				                }
				            }, holder);

				Integer newLeaveId = holder.getKey().intValue();
				System.out.println(">>>>>>>>>>>>"+newLeaveId);
		if(resultentValue==1) {
			
			AddLeavesToDocFlow(leavetypeDTO,newLeaveId);
		}
		}
		else {
			System.out.println("not updated");
		}
		
   

	}

	public void AddLeavesToDocFlow(final LeaveTypeDTO leavetypeDTO,final int newLeaveId) {
//		final int docMaxValue=getDocMaxValue();
		final String initiatedOn=dateUtils.getCurrentDateAndtime();
		final int passedtoIdno=constants.getPassedLevel1Idno(leavetypeDTO.getIdno(),16);
                String remarks="";
                
                            Connection con = DBUtil.getConnection();                                
                            try{    
        			Statement stm = con.createStatement();                		
                                ResultSet rs = stm.executeQuery("select e.idno,empname,desgn,gender from hr_empmaster e where e.idno="+leavetypeDTO.getIdno());
                                if (rs.next()) {
                                    remarks = remarks+""+rs.getInt("idno")+"-"+rs.getString("empname")+","+rs.getString("desgn")+"<br>";                                    
                                }                                
                                String lType=constants.getFieldValue("HRMS", "select leavedescription from hr_leavetypes where transid="+leavetypeDTO.getLeavetypeid(), 1);
                                remarks = remarks + " Applied <u><b>"+lType+"</u></b> from "+leavetypeDTO.getFromdate()+" to "+leavetypeDTO.getTodate()+" ["+leavetypeDTO.getNoofdays()+" day(s) for "+leavetypeDTO.getReasonforleave()+"";
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                final String remark=remarks;            
		String query="insert into tran_docflow(docid,idno,remarks,docstatus,isactive,initiatedon,passedto,levelid,activityid,deligatedto,completedon,description)  values(?,?,?,?,?,?,?,?,?,?,?,?)";

		template.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, newLeaveId);
				ps.setInt(2, leavetypeDTO.getIdno());
				ps.setString(3, leavetypeDTO.getReasonforleave());
				ps.setString(4, "FR");
				ps.setInt(5, 1);
				ps.setString(6, initiatedOn);
				ps.setInt(7, passedtoIdno);
				ps.setInt(8, 1);
				ps.setInt(9, 16);
				ps.setInt(10, 0);
				ps.setString(11, initiatedOn);
                                ps.setString(12, remark);
				return ps.execute();
			}
		});
	}
	
//	public int getDocMaxValue() {
//		int docMaxValue=1;
//		try {
//		
//		Connection con=DBUtil.getConnection();
//		Statement stm=con.createStatement();
//		String sql="select max(docid) from  tran_docflow";
//		ResultSet rs=stm.executeQuery(sql);
//		if(rs.next()) {
//			docMaxValue=rs.getInt(1)+1;
//		}
//		con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return docMaxValue;
//	}
//	
//	public int getPassedLevel1Idno(int idno) {
//		int level1id=0;
//		try {
//			
//			Connection con=DBUtil.getConnection();
//			Statement stm=con.createStatement();
//			String sql="select level1 from  user_menuaccessrights where idno="+idno+" and menuitemid=16";
//			ResultSet rs=stm.executeQuery(sql);
//			if(rs.next()) {
//				level1id=rs.getInt(1);
//			}
//			con.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		return level1id;
//		
//	}
        
	@Override
	public void editLeave(LeaveTypeDTO leavetypeDTO) {
		float balance=getLeaveBalance(leavetypeDTO.getIdno(),leavetypeDTO.getLeavetypeid());
		//String fromdate=convertDateToDBDate(leavetypeDTO.getFromdate());
		//String todate=convertDateToDBDate(leavetypeDTO.getTodate());
		if(leavetypeDTO.getNoofdays()<=balance) {
		String sql = "update hr_leavedebits set leavetypeid=" + leavetypeDTO.getLeavetypeid() + ",fromdate='"
				+ leavetypeDTO.getFromdate() + "'," + "todate='" + leavetypeDTO.getTodate() + "',noofdays="
				+ leavetypeDTO.getNoofdays() + ",reasonforleave='" + leavetypeDTO.getReasonforleave() + "',fhalfday="
				+ leavetypeDTO.getFhalfday() + ",thalfday='" + leavetypeDTO.getThalfday() + "' where transid='"
				+ leavetypeDTO.getTransid() + "'";

		template.update(sql);
		}
		else {
			System.out.println("not updated");
		}
	}

	@Override
	public void deleteLeave(final Integer transid) {
		String deleteQuery = "delete from hr_leavedebits where transid=?";

		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, transid);
				return ps.execute();
			}
		});

	}

	@Override
	public LeaveTypeDTO getLeavedebit(int transid) {

		return template.query(
				"select ld.transid,createdon,leavetype,fromdate,todate,noofdays,reasonforleave,docstatus, ld.leavetypeid, ld.idno from hr_leavedebits ld, hr_leavetypes lt where ld.leavetypeid=lt.transid and ld.transid="
						+ transid ,
				new ResultSetExtractor<LeaveTypeDTO>() {
					@Override
					public LeaveTypeDTO extractData(ResultSet rs) throws SQLException, DataAccessException {

						int no = 1;
						rs.next();
						LeaveTypeDTO dto = new LeaveTypeDTO();

						dto.setSno(no++);
						dto.setTransid(rs.getInt(1));
						dto.setCreatedon(rs.getDate(2));
						dto.setLeavetype(rs.getString(3));
					//String fromdate=convertDBDateToFormDate(rs.getString(4));
						dto.setFromdate(rs.getString(4));
					//String todate=convertDBDateToFormDate(rs.getString(5));
						dto.setTodate(rs.getString(5));
						dto.setNoofdays(rs.getFloat(6));
						dto.setReasonforleave(rs.getString(7));
						dto.setDocstatus(rs.getString(8));
						dto.setLeavetypeid(rs.getInt(9));
						dto.setIdno(rs.getInt(10));
						return dto;
					}

				});

	}
	
	
	public String convertDBDateToFormDate(String date) {
		
		//actual formate we are gring like this 2019-05-02
		
		String filter=date.substring(5,7)+"/"+date.substring(8,10)+"/"+date.substring(0,4);
		
		return filter;
		
	}
	
	public String convertDateToDBDate(String date) {
		
		//actual formate we are gring like this 2019-05-02
		
		String filter=date.substring(6,10)+"-"+date.substring(0,2)+"-"+date.substring(3,5);
		
		return filter;
		
		}

	@SuppressWarnings("deprecation")
	@Override
	public float getHolidayCount(String fromdate, String todate, int fhalfday, int thalfday, int idno) {
		final int idnumber=idno;
		String fdate = fromdate;
		String tdate = todate;
		String fDate = fdate.substring(6, 10) + "-" + fdate.substring(3, 5) + "-" + fdate.substring(0, 2);
		String tDate = tdate.substring(6, 10) + "-" + tdate.substring(3, 5) + "-" + tdate.substring(0, 2);
		System.out.println(">>>>>>>>>>>fDate"+fDate+""+tDate);
		countOfLeavesDays = dateUtils.calculateDifferenceBTWNDates(fromdate, todate);
		String weekday=getDay(idnumber);
		noOfWeekDays=dateUtils.getWeekDaysFunction(fromdate, todate,weekday);
		
		System.out.println(noOfWeekDays+">>>>>>>>>>>>>>>>>>>>>>>");
		if (fhalfday > 0) {
			countOfLeavesDays -= 0.5;
		}
		if (thalfday > 0) {
			countOfLeavesDays -= 0.5;
		}

		String sql = "select count(tranid) from hr_holidays where infodate between '" + fromdate + "' and '" + todate + "'";
		// return template.update(sql);
		System.out.println(sql);
		return template.query(sql, new ResultSetExtractor<Float>() {
			@Override
			public Float extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				float val = countOfLeavesDays -= rs.getFloat(1);				
				return val- noOfWeekDays;
			}

		});
		
		
			
			
	}

	private String getDay(int idno) {
		Calendar c1;
		// TODO Auto-generated method stub
		String returnWeekDay="";
		try {
			Connection con = DBUtil.getConnection();
			//PreparedStatement psToGetWeekDays=null;
		PreparedStatement psToGetWeekDays = con.prepareStatement("select * from hr_empshiftschedule where idno='"+idno+"'");
		ResultSet rst1 = psToGetWeekDays.executeQuery();
		ResultSetMetaData rsmds = rst1.getMetaData();
		if(rst1.next()) {
			System.out.println(rst1.getString(1)+">>");
			System.out.println(rsmds.getColumnCount()+">>>");
			//rsmds.getColumnCount();
			int colcount=1;
			//int i=1
			int j=1;
			for(int i=3;i<=9;i++) {
				if(rst1.getString(i).equalsIgnoreCase("5")) {
					
					System.out.println(rst1.getString(i));
					System.out.println(rsmds.getColumnName(i));
					returnWeekDay=rsmds.getColumnName(i);
				}
			}
			
		}
		
		
		con.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		return returnWeekDay;
	}

	@Override
	public List<LeaveTypeDTO> getLeaveBalances() {
		String lb1="select * from  hr_leavetypes where isdisplay=1";
		return template.query(lb1, new ResultSetExtractor<List<LeaveTypeDTO>>() {
			@Override
			public List<LeaveTypeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				
				List list= new ArrayList<>();

				while (rs.next()) {
					
					list.add(rs.getInt(1));
					list.add(rs.getString(2));
					list.add(rs.getString(3));
					list.add(rs.getInt(4));

					//listdto.add(dto);
				}
				return list;
			}

		});

	}
	
        
		public float getLeaveBalance(int idno,int leavetypeid) {
		float sumofdebits=0;
		float sumofCredits=0;
		float balance=0f;
		try {
		Connection con=DBUtil.getConnection();
		Statement stm=con.createStatement();
		String DebitSql="select sum(noofdays) from hr_leavedebits where idno="+idno+" and leavetypeid="+leavetypeid+" and docstatus<>'RJ'";
		ResultSet sumOfDebitResult=stm.executeQuery(DebitSql);
		if(sumOfDebitResult.next()) {
			sumofdebits=sumOfDebitResult.getFloat(1);
		}
		String CreditSql="select sum(noofdays) from hr_leavecredits where idno="+idno+" and leavetypeid="+leavetypeid+"";
		ResultSet sumOfCreditResult=stm.executeQuery(CreditSql);
		if(sumOfCreditResult.next()) {
			sumofCredits=sumOfCreditResult.getFloat(1);
		}
		balance=sumofCredits-sumofdebits;
	//return	balance;
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return balance;
	}

	
		@Override
		public List<LeaveTypeDTO> getBalance(int idno) {
			
			
			float cl=getLeaveBalance(idno,1);
			float sl=getLeaveBalance(idno,2);
			float el=getLeaveBalance(idno,3);

			float co=getLeaveBalance(idno,4);

			List li=new ArrayList();
			li.add(cl);
			li.add(sl);
			li.add(el);
			li.add(co);

			return li;
		}

		
//		public void insertNewTrandocFlow(final int docid,final String docStatus,final int employeeid,final String initiatedon,final int levelspassedid,final int lvlid,final int activityid,final int deligatedto) {
//			try {
//				String currentdate=dateUtils.getCurrentDateAndtime();
//				Connection con=DBUtil.getConnection();
//				PreparedStatement pstm=con.prepareStatement("insert into tran_docflow(docid,idno,remarks,docstatus,isactive,initiatedon,passedto,levelid,activityid,deligatedto,completedon)  values(?,?,?,?,?,?,?,?,?,?,?)");
//				pstm.setInt(1, docid);
//				pstm.setInt(2, employeeid);
//				if(docStatus=="RJ") {
//					pstm.setString(3, "Your Leave Rejectd Please contact: "+levelspassedid+".");
//				}else{
//					pstm.setString(3, "updated by "+levelspassedid+".");
//				}
//				
//				pstm.setString(4, docStatus);
//				if(docStatus=="RJ") {
//					pstm.setInt(5, -1);
//				}
//				else {
//					pstm.setInt(5, 1);
//				}
//				pstm.setString(6, initiatedon);
//				pstm.setInt(7, levelspassedid);
//				pstm.setInt(8, lvlid);
//				pstm.setInt(9, activityid);
//				pstm.setInt(10, deligatedto);
//				pstm.setString(11, currentdate);
//				int rst=pstm.executeUpdate();
//				if(rst>0) {
//					//sucessmessage shoud write here
//					System.out.println("upated");
//					//now going to update leavedebits table
//				}
//				con.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		public void updateLeaveDebitsStatus(String docstatus,int tranid) {
//			
//			try {
//				Connection con=DBUtil.getConnection();
//			    
//				PreparedStatement pstm=con.prepareStatement("update hr_leavedebits set docstatus=? where transid=?");
//				pstm.setString(1, docstatus);
//				pstm.setInt(2, tranid);
//				int rst=pstm.executeUpdate();
//				if(rst>0) {
//					//sucessmessage shoud write here
//					System.out.println("upated");
//					//now going to update leavedebits table
//				}
//				con.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
//		
//		public int getLevel2ForEmployeeid(int employeeid,int passedtoid) {
//			int level2passedid=0;
//			int l2=0;
//			int l3=0;
//			try {
//				Connection con=DBUtil.getConnection();
//				Statement stm=con.createStatement();
//				String sql="select level2,level3 from user_menuaccessrights where idno="+employeeid;
//				ResultSet rs=stm.executeQuery(sql);
//				if(rs.next()) {
//					l2=rs.getInt(1);
//					l3=rs.getInt(2);
//					List<Integer> li=new ArrayList<>();
//					li.add(l2);
//					li.add(l3);
//					for(int i=0;i<li.size();i++) {
//						
//						if(passedtoid!=li.get(i)) {
//							level2passedid=li.get(i);
//							break;
//						}			
//					}
//					
//					//level2passedid=rs.getInt(1);
//				}
//				con.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			return level2passedid;
//			
//		}
//
//
//		private void insertAndUpdateRejectedLeave(Map<String, Object> dataMap) {
//			try {
//				int tranid = 0,docid = 0,employeeid = 0,passedto = 0;
//				String initiatedon = null;
//				for(Map.Entry<String, Object> hm:dataMap.entrySet()) {
//					if(hm.getKey()=="tranid") {
//						tranid=(int) hm.getValue();
//					}
//					if(hm.getKey()=="docid") {
//						docid=(int) hm.getValue();
//					}
//					if(hm.getKey()=="employeeid") {
//						employeeid=(int) hm.getValue();
//					}
//					if(hm.getKey()=="initiatedon") {
//						initiatedon=(String) hm.getValue();
//					}
//					if(hm.getKey()=="passedto") {
//						passedto=(int) hm.getValue();
//					}
//				}
//				updateLeaveDebits(docid);
//				insertTranDocFlow(tranid,docid,employeeid,initiatedon,passedto);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
//
//		private void updateLeaveDebits(int docid) {
//			try {
//				Connection con=DBUtil.getConnection();
//				PreparedStatement pstm=con.prepareStatement("update hr_leavedebits set docstatus=? where transid=?");
//				pstm.setString(1, "RJ");
//				pstm.setInt(2, docid);
//				int rs=pstm.executeUpdate();
//				con.close();
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		private void insertTranDocFlow(int tranid,int docid, int employeeid, String initiatedon, int passedto) {
//			insertNewTrandocFlow(docid,"RJ",employeeid,initiatedon,passedto,1,16,0);
//			try {
//				Connection con=DBUtil.getConnection();
//				PreparedStatement pstm=con.prepareStatement("update tran_docflow set passedto=? where tranid=?");
//				pstm.setInt(1, 0);
//				pstm.setInt(2, tranid);
//				int rs=pstm.executeUpdate();
//				con.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}

    @Override
    public String saveLeaveCreditDetails(int idno, int cl, int sl, int el, String remarks) {
		String resultMessage = "";
		String sql = "insert into hr_leavecredits( idno,leavetypeid,year,remarks,isactive,docstatus,noofdays,createdon)values("
				+ idno + ",1,year(sysdate()),'" + remarks + "',1,'AU',"+cl+",sysdate());";
                String sql1 = "insert into hr_leavecredits( idno,leavetypeid,year,remarks,isactive,docstatus,noofdays,createdon)values("
				+ idno + ",2,2019,'" + remarks + "',1,'AU',"+sl+",sysdate());";
                String sql2 = "insert into hr_leavecredits( idno,leavetypeid,year,remarks,isactive,docstatus,noofdays,createdon)values("
				+ idno + ",3,2019,'" + remarks + "',1,'AU',"+el+",sysdate());";
                                

		int result = template.update(sql);
                 result = template.update(sql1);
                 result = template.update(sql2);
		resultMessage = result > 0 ? HrmsMessageConstants.Success
				: HrmsMessageConstants.Fail;
		return resultMessage;                        
    }

    @Override
    public String saveLeaveProcessFlow(int idno, int level1, int level2, int level3, int level4) {
		String resultMessage = "";
		String sql = "update user_menuaccessrights set level1="+level1+",level2="+level2+",level3="+level3+",level4="+level4+" where idno="+idno+" and menuitemid=16 and tranid>0";
                              
		int result = template.update(sql);
		resultMessage = result > 0 ? HrmsMessageConstants.Success
				: HrmsMessageConstants.Fail;
		return resultMessage;                        
    }

    @Override
    public List<Map<String, Object>> getLevelIds(int idno, int activityid) {
		Connection connection=null;
		Statement statement=null;
		ResultSet rs =null;
		connection = DBUtil.getConnection();
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		try {
			 statement = connection.createStatement();
			 String sql = "select * from user_menuaccessrights where idno="+idno+" and menuitemid="+activityid;
			 rs = statement.executeQuery(sql);
			 int level1=0;
                         int level2=0;
                         int level3=0;
                         int level4=0;
			 if(rs.next()) {
                             	 Map<String, Object> map1 = new HashMap<String, Object>();
				                 map1.put("level1", rs.getInt("level1"));
                                 map1.put("level2", rs.getInt("level2"));
                                 map1.put("level3", rs.getInt("level3"));
                                 map1.put("level4", rs.getInt("level4"));				 
				                    map.add(map1);
			 }else {
				 Map<String, Object> map1 = new HashMap<String, Object>();
                 map1.put("level1", level1);
                 map1.put("level2",level2);
                 map1.put("level3", level3);
                 map1.put("level4", level4);				 
                  map.add(map1); 
			 }
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("access level ids getting error" + e);
		}

        return map;
    }


    
    
}
