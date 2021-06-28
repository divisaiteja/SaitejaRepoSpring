package com.hrms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository

public class SalaryStatementDaoImpl implements SalaryStatementDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<Object, Object>> getsalarystatement(int division,int project,int month,int year) {
		
        final int numberofdays=getMonthDays( month,  year);
		
   String sql="select e.idno, e.empname,r.paiddays,r.lopdays,r.absdays,r.basic,r.da,r.hra,r.conveyance,r.otherearnings1,r.otherearnings2,r.grossearnings,r.salaryadvance,r.pfamount,r.mobilededuction ,r.otherdeduction1,r.ptax,r.salaryadvance,r.absamount,r.grossdeductions,r.netamount from hr_empmonthpay r join hr_empmaster e on r.idno=e.idno   where e.workingdivisionid="+division+" and e.project="+project+" and r.tmonth="+month+" and r.tyear="+year+"";		
		System.out.println("sql"+sql);
   return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Map<Object, Object>> list=new ArrayList<Map<Object, Object>>();
				int slno=0;
				while(rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					slno = slno + 1;
					map.put("slno", slno);
					map.put("idno", rs.getInt("idno"));
					map.put("empname", rs.getString("empname"));
					map.put("workingdays", numberofdays);
					map.put("presentdays", rs.getFloat("paiddays"));
					map.put("lopdayswithintimation", rs.getFloat("lopdays"));
					map.put("lopdayswithoutintimation",rs.getFloat("absdays") );
					map.put("basic", rs.getFloat("basic"));
					map.put("vda", rs.getString("da"));
					map.put("hra", rs.getFloat("hra"));
					map.put("ca", rs.getFloat("conveyance"));
					map.put("sa", rs.getFloat("otherearnings1"));
					map.put("leaveincentive", rs.getFloat("otherearnings2"));
					map.put("totalearnings", rs.getFloat("grossearnings"));
					map.put("salaryloan", "0");
					map.put("salaryadvance", rs.getFloat("salaryadvance"));
					map.put("pfamount", rs.getFloat("pfamount"));
					map.put("electricitycharges", rs.getFloat("mobilededuction"));
					map.put("hra1", rs.getFloat("otherdeduction1"));
					map.put("ptax", rs.getFloat("ptax"));
					map.put("salaryadvance1", rs.getFloat("salaryadvance"));
					map.put("salaryloan1", "0");
					map.put("leavepenalty", rs.getFloat("absamount"));
					map.put("totaldeduction", rs.getFloat("grossdeductions"));
					map.put("netsalary", rs.getFloat("netamount"));

			list.add(map);
				}
				
				return list ;
			}
		}) ;
	}
	
	public static int getMonthDays(int month, int year) {
	    int daysInMonth ;
	    if (month == 4 || month == 6 || month == 9 || month == 11) {
	        daysInMonth = 30;
	    }
	    else {
	        if (month == 2) {
	            daysInMonth = (year % 4 == 0) ? 29 : 28;
	        } else {
	            daysInMonth = 31;
	        }
	    }
	    return daysInMonth;
	}
}
