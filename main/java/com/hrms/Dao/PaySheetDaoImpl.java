package com.hrms.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.hrms.dtos.EmployeeMonthPay;
import com.hrms.utitlities.DBUtil;

@Repository
public class PaySheetDaoImpl implements PaySheetDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EmployeeMonthPay> paysheetcaluculation(int division, int tmonth, int tyear) {
		insertDataToEmpMonthPay(division, tmonth, tyear);
		String sql = "select m.*,e.empname from hr_empmonthpay m join hr_empmaster e on e.idno=m.idno where m.tmonth="+tmonth+" and m.tyear="+tyear+" and e.workingdivisionid="+division;
		
		System.out.println(sql);
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeMonthPay>>() {

			@Override
			public List<EmployeeMonthPay> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EmployeeMonthPay> list = new ArrayList<EmployeeMonthPay>();
				while (rs.next()) {
					EmployeeMonthPay employeeMonthPay = new EmployeeMonthPay();
					employeeMonthPay.setTranid(rs.getInt("tranid"));
					employeeMonthPay.setIdno(rs.getInt("idno"));
					employeeMonthPay.setEmpname(rs.getString("empname"));
					//employeeMonthPay.setWorkdepartmentid(rs.getInt("workdeptid"));
					employeeMonthPay.setTmonth(rs.getInt("tmonth"));
					employeeMonthPay.setTyear(rs.getInt("tyear"));
					employeeMonthPay.setDesignation(rs.getString("designation"));
					employeeMonthPay.setGradeid(rs.getInt("gradeid"));
					employeeMonthPay.setCadreid(rs.getInt("cadreid"));
					employeeMonthPay.setJobstatusid(rs.getInt("jobstatusid"));
					employeeMonthPay.setBasic(rs.getFloat("basic"));
					employeeMonthPay.setDa(rs.getFloat("da"));
					employeeMonthPay.setHra(rs.getFloat("hra"));
					employeeMonthPay.setConveyance(rs.getFloat("conveyance"));
					employeeMonthPay.setOtherearnings1(rs.getFloat("otherearnings1"));
					employeeMonthPay.setOtherdeduction2(rs.getFloat("otherearnings2"));
					employeeMonthPay.setLta(rs.getFloat("lta"));
					employeeMonthPay.setMedical(rs.getFloat("medical"));
					employeeMonthPay.setBonus(rs.getFloat("bonus"));
					employeeMonthPay.setGrossearnings(rs.getFloat("grossearnings"));
					employeeMonthPay.setPfper(rs.getFloat("pfper"));
					employeeMonthPay.setPfamount(rs.getFloat("pfamount"));
					employeeMonthPay.setEsiper(rs.getFloat("esiper"));
					employeeMonthPay.setEsiamount(rs.getFloat("esiamount"));
					employeeMonthPay.setSalaryadvance(rs.getFloat("salaryadvance"));
					employeeMonthPay.setOtherdeduction1(rs.getFloat("otherdeduction1"));
					employeeMonthPay.setOtherdeduction2(rs.getFloat("otherdeduction2"));
					employeeMonthPay.setMobilededuction(rs.getFloat("mobilededuction"));
					employeeMonthPay.setMediclaim(rs.getFloat("mediclaim"));
					employeeMonthPay.setVpfper(rs.getFloat("vpfper"));
					employeeMonthPay.setVpfamount(rs.getFloat("vpfamount"));
					employeeMonthPay.setLic(rs.getFloat("lic"));
					employeeMonthPay.setLoanamount(rs.getFloat("loanamount"));
					employeeMonthPay.setPtax(rs.getFloat("ptax"));
					employeeMonthPay.setCanteencharges(rs.getFloat("canteencharges"));
					employeeMonthPay.setTouradvance(rs.getFloat("touradvance"));
					employeeMonthPay.setPowercharges(rs.getFloat("powercharges"));
					employeeMonthPay.setClubfund(rs.getFloat("clubfund"));
					employeeMonthPay.setUnionfund(rs.getFloat("unionfund"));
					employeeMonthPay.setPersonaltripcharges(rs.getFloat("personaltripcharges"));
					employeeMonthPay.setItax(rs.getFloat("itax"));
					employeeMonthPay.setWelfareallowance(rs.getFloat("welfareallowance"));
					employeeMonthPay.setMonthid(rs.getString("monthid"));
				    employeeMonthPay.setMondays(rs.getInt("mondays"));
					employeeMonthPay.setLopdays(rs.getFloat("lopdays"));
					employeeMonthPay.setPaiddays(rs.getFloat("paiddays"));
					employeeMonthPay.setWef(rs.getString("wef"));
					employeeMonthPay.setGrossdeductions(rs.getFloat("grossdeductions"));
					employeeMonthPay.setNetamount(rs.getFloat("netamount"));
					employeeMonthPay.setRbasic(rs.getFloat("rbasic"));
					employeeMonthPay.setRda(rs.getFloat("rda"));
					employeeMonthPay.setRhra(rs.getFloat("rhra"));
					employeeMonthPay.setRconveyance(rs.getFloat("rconveyance"));
					employeeMonthPay.setRlta(rs.getFloat("rlta"));
					employeeMonthPay.setRmedical(rs.getFloat("rmedical"));
					employeeMonthPay.setRotherallowance1(rs.getFloat("rotherallowance1"));
					employeeMonthPay.setRotherallowance2(rs.getFloat("rotherallowance2"));
					employeeMonthPay.setPfuanno(rs.getString("pfuanno"));
					employeeMonthPay.setIsarrearsrecord(rs.getInt("isarrearsrecord"));
					employeeMonthPay.setRemarks(rs.getString("remarks"));
					employeeMonthPay.setHr_empmonthpaycol(rs.getString("hr_empmonthpaycol"));
					list.add(employeeMonthPay);
				}
				return list;
			}
		});
		//return null;
	}

	private void insertDataToEmpMonthPay(int division, int tmonth, int tyear) {
		
		Connection con=DBUtil.getConnection();
		
		
		String query = "INSERT INTO hr_empmonthpay (idno, tmonth, tyear,designation,gradeid,cadreid,jobstatusid,rbasic,rda,"
				+ "rhra,rconveyance,rlta,rmedical,rotherallowance1,rotherallowance2,pfuanno,pfper,esiper,vpfper,wef) "
				+ " SELECT hr_empmaster.idno, "+tmonth+", "+tyear+",desgn,gradeid,cadreid,jobstatus,basic,da,hra,conveyance,lta,"
				+ "medical,others1,others2,uannumber,pfpercentage,esipercentage,vpfpercentage,wef"
				+ " FROM hr_empmaster,hr_rateofpay  where hr_empmaster.idno=hr_rateofpay.idno and empleft=0  and hr_empmaster.idno not in (select idno from hr_empmonthpay where tmonth="+tmonth+" and tyear="+tyear+")";
		System.out.println(query);
		jdbcTemplate.execute(query);
		
		Calendar calendar = Calendar.getInstance();
        int year = tyear;
        int month = tmonth-1;
        int date = 1;
        calendar.set(year, month, date);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Max Day: " + maxDay);
        String updateQuery="";
		updateQuery="update hr_empmonthpay set basic=0,da=0,hra=0,conveyance=0,otherearnings1=0,"
				+ " otherearnings2=0, lta=0,medical=0,bonus=0,grossearnings=0,pfamount=0,esiamount=0,salaryadvance=0,"
				+ "otherdeduction1=0,otherdeduction2=0,mobilededuction=0,mediclaim=0,vpfamount=0,lic=0,loanamount=0,"
				+ "ptax=0,canteencharges=0,touradvance=0,powercharges=0,clubfund=0,unionfund=0,personaltripcharges=0,"
				+ "itax=0,welfareallowance=0,monthid=0,mondays="+maxDay+",lopdays=0,paiddays=0,grossdeductions=0,netamount=0,"
				+ "isarrearsrecord=0,remarks=''";

		jdbcTemplate.execute(updateQuery);
		
		String checkDate=tyear+"-"+tmonth+"-"+maxDay;
		
		
		
		query = "update hr_empmonthpay m, hr_rateofpay r set rbasic=r.basic,rda=r.da,"
				+ "rhra=r.hra,rconveyance=r.conveyance,rlta=r.lta,rmedical=r.medical,rotherallowance1=r.others1,rotherallowance2=r.others2 "
				+ "  where m.idno=r.idno  and tmonth="+tmonth+" and tyear="+tyear+"";
		System.out.println(query);
		jdbcTemplate.execute(query);
		
		
		updateQuery="update hr_empmonthpay set lopdays = (select sum(lop) from hr_muster where hr_empmonthpay.idno=hr_muster.idno and hr_empmonthpay.tmonth=hr_muster.tmon and hr_empmonthpay.tyear=hr_muster.tyear) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		
		updateQuery="update hr_empmonthpay set paiddays = (mondays-lopdays) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay set basic = ROUND(((rbasic/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		//---
		updateQuery="update hr_empmonthpay set da = ROUND(((rda/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay set hra = ROUND(((rhra/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
	
		
		updateQuery="update hr_empmonthpay set conveyance = ROUND(((rconveyance/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		
		updateQuery="update hr_empmonthpay set lta = ROUND(((rlta/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay set medical = ROUND(((rmedical/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		
		
		updateQuery="update hr_empmonthpay set otherearnings1 = ROUND(((rotherallowance1/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay set otherearnings2 = ROUND(((rotherallowance2/mondays)*paiddays),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		
		updateQuery="update hr_empmonthpay set grossearnings = basic+da+hra+conveyance+lta+medical+otherearnings1+otherearnings2 where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		
		updateQuery="update hr_empmonthpay set pfamount = ROUND(((pfper/100)*basic),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		
		updateQuery="update hr_empmonthpay set esiamount = ROUND(((esiper/100)*grossearnings),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay set vpfamount = ROUND(((vpfper/100)*basic),0) where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay m ,hr_salarydeductions d set m.salaryadvance = d.salaryadvance,m.otherdeduction1=d.otherdeduction1,m.otherdeduction2=d.otherdeduction2,m.mobilededuction=d.mobilecharges where m.idno=d.idno and m.tmonth="+tmonth+" and m.tyear="+tyear+" and m.tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		try {
			Statement stm=con.createStatement();
			String sqlQuery="select * from hr_stddeductionfieldsmaster";
			ResultSet rs=stm.executeQuery(sqlQuery);
			while(rs.next()) {
				
				updateQuery="update hr_empmonthpay m ,hr_stdpaydeductons d set m."+rs.getString("fldname")+" = d.emiamount where m.idno=d.idno and m.tmonth="+tmonth+" and m.tyear="+tyear+" and m.tranid>0 and d.stdfldtype="+rs.getInt("tranid")+" and d.wet>='"+checkDate+"' and d.docstatus='AU'";
                System.out.println(updateQuery);
				jdbcTemplate.execute(updateQuery);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		updateQuery="update hr_empmonthpay set grossdeductions = pfamount+esiamount+salaryadvance+loanamount+lic+touradvance+otherdeduction1+otherdeduction2+mobilededuction where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
		updateQuery="update hr_empmonthpay set netamount = grossearnings-grossdeductions where hr_empmonthpay.tmonth="+tmonth+" and hr_empmonthpay.tyear="+tyear+" and tranid>0";

		jdbcTemplate.execute(updateQuery);
		
	}

}
