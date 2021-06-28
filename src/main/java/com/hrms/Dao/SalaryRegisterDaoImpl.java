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
public class SalaryRegisterDaoImpl implements SalaryRegisterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<Object, Object>> GetSalaryRegister(int year,int month) {
		String sql="select e.idno,e.empname,e.desgn,m.rbasic,m.rda,m.rconveyance,m.otherearnings1,m.basic,m.da,m.conveyance,m.paiddays,m.grossearnings,m.otherearnings2,m.netamount,m.pfamount,m.esiamount,m.ptax,m.mobilededuction,m.salaryadvance,m.hra  from hr_empmaster e join hr_empmonthpay m on e.idno=m.idno  where tmonth="+month+" and tyear="+year+" order by e.idno";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object,Object>> list = new ArrayList<Map<Object, Object>>();
				 int slno=0;
				 Float basic=0f;
				 Float rbasic=0f;
				 Float totaldeduction=0f;
				while(rs.next()) {
					Map<Object,Object> map = new HashMap<Object,Object>();
				 slno=slno+1;
				 map.put("slno", slno);
				 map.put("idno", rs.getInt("idno"));
				 map.put("empname", rs.getString("empname"));
				 map.put("Father", "0");
				 map.put("desgn", rs.getString("desgn"));
				 rbasic=rs.getFloat("rbasic")+rs.getFloat("rda")+rs.getFloat("rconveyance");
				 map.put("basic",basic );
				 map.put("allowance1", rs.getFloat("otherearnings1"));
				 basic=rs.getFloat("basic")+rs.getFloat("da")+rs.getFloat("conveyance");
				 map.put("rbasic",rbasic );
				 map.put("allowance2", rs.getFloat("otherearnings1"));
				 map.put("presentdays", rs.getFloat("paiddays"));
				 map.put("earnedmoney", rs.getFloat("grossearnings"));
				 map.put("additonalworkingdays", rs.getFloat("otherearnings2"));
				 map.put("netsalary", rs.getFloat("netamount"));
				 map.put("pfamount", rs.getFloat("pfamount"));
				 map.put("esiamount", rs.getFloat("esiamount"));
				 map.put("ptax", rs.getFloat("ptax"));
				 map.put("mobilededuction", rs.getFloat("mobilededuction"));
				 map.put("salaryadvance", rs.getFloat("salaryadvance"));
				 map.put("hra", rs.getFloat("hra"));
				 totaldeduction=rs.getFloat("pfamount")+rs.getFloat("esiamount")+ rs.getFloat("ptax")+rs.getFloat("mobilededuction")+rs.getFloat("salaryadvance")+rs.getFloat("hra");
				 map.put("total", totaldeduction);
				 map.put("gross", rs.getFloat("grossearnings"));
				 map.put("payslipdate","payslipdate");
				 map.put("salarydate","salarydate");
				 map.put("signature","");
				 list.add(map);
				}
				return list;
			}
		});
	}

}
