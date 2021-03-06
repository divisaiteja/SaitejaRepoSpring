package com.hrms.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hrms.utitlities.DBUtil;

public class LeaveCalculation {
    
		public static float getLeaveBalance(int idno,int leavetypeid) {
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
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return balance;
	}

public static Map<String,Object> getBalance(int idno) {
			float cl=getLeaveBalance(idno,1);
			float sl=getLeaveBalance(idno,2);
			float el=getLeaveBalance(idno,3);

			float co=getLeaveBalance(idno,4);
			 Map<String,Object> map = new HashMap<String, Object>();
			 map.put("cl", cl);
			 map.put("sl", sl);
			 map.put("el", el);
			 map.put("co", co);
			 
			  return map ;
		}

     
}
