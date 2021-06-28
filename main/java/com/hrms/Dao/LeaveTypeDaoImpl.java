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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.LeaveBalanceDTO;
import com.hrms.dtos.LeaveTypeDTO;
import com.hrms.utitlities.DBUtil;
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
	public void addnewLeave(LeaveTypeDTO leavetypeDTO) {
		
		float balance=getLeaveBalance(leavetypeDTO.getIdno(),leavetypeDTO.getLeavetypeid());
		if(leavetypeDTO.getNoofdays()<=balance) {
			String insertQuery = "insert into hr_leavedebits(idno,leavetypeid,fromdate,todate,noofdays,reasonforleave,fhalfday,thalfday,spanno,createdon,docstatus)values("
					+ leavetypeDTO.getIdno() + "," + leavetypeDTO.getLeavetypeid() + ",'" + leavetypeDTO.getFromdate()
					+ "','" + leavetypeDTO.getTodate() + "'," + leavetypeDTO.getNoofdays() + ",'"
					+ leavetypeDTO.getReasonforleave() + "'," + leavetypeDTO.getFhalfday() + ","
					+ leavetypeDTO.getThalfday() + ",0,'" + date + "','FR')";
			template.update(insertQuery);
		}
		else {
			System.out.println("not updated");
		}
		

		

	}

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
		String DebitSql="select sum(noofdays) from hr_leavedebits where idno="+idno+" and leavetypeid="+leavetypeid+"";
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
	 
}
