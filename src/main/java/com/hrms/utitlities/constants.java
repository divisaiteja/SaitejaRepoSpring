package com.hrms.utitlities;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestParam;

public class constants {
	
	public static final String trues="true";
	public static final String Active="Active";
	public static final String InActive="inActive";
	public static final String yes="Yes";
	public static final String no="No";
	public static final String NotFound="notfound";
	public static final String Mail_Success_Message="true";
        public static final String getAccessRights(@RequestParam(value="loginId") String loginId,@RequestParam(value="selectedOption") String selectedOption,@RequestParam(value="activityId") int activityId){
                        String fltStr="";
                        // gathering allowed divisions for the logged user
                        if (!loginId.equalsIgnoreCase("admin") ){
                        try{
                            Connection con=DBUtil.getConnection();
                            Statement stm=con.createStatement();
                            String sql = "SELECT "+selectedOption+" as Result from user_menuaccessrights where menuitemid="+activityId+" and idno = "+loginId+"";
                            ResultSet rs=stm.executeQuery(sql);
                            if(rs.next()) {
                                if (selectedOption.equalsIgnoreCase("Divisions")){
                                fltStr=" and (divisionid in ("+rs.getString("Result")+")) ";
                                }
                                if (selectedOption.equalsIgnoreCase("Departments")){
                                fltStr=" and (deptid in ("+rs.getString("Result")+")) ";
                                }
                                if (selectedOption.equalsIgnoreCase("Projects")){
                                fltStr=" and (tranid in ("+rs.getString("Result")+")) ";
                                }
                                
                            }else{
                                fltStr=" and 1>1 ";
                            }
                            con.close();
                            } catch (SQLException e) {
                            e.printStackTrace();
                            }
                        } 
                        
                    return fltStr;
                  }

	public static final int getPassedLevel1Idno(int idno, int activityId) {
		int level1id=0;
		try {
			
			Connection con=DBUtil.getConnection();
			Statement stm=con.createStatement();
			String sql="select level1 from  user_menuaccessrights where idno="+idno+" and menuitemid="+activityId;
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				level1id=rs.getInt(1);
			}
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return level1id;
		
	}
        
        public static final String getFieldValue(String sConn,String vQry, int FieldNO){
                String sList="";

		try {
			
			Connection conX=DBUtil.getConnection();
			Statement stmX=conX.createStatement();
			ResultSet rsX=stmX.executeQuery(vQry);
			if(rsX.next()) {                            
				sList=rsX.getString(1);
			}
			conX.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

                return sList;

        }

    public static final String getPopList(String sConn, String vQry,Integer FieldNO, Integer FieldVal,String vDefa){
        String sList="";
        String sBool="";

		try {
			
			Connection conY=DBUtil.getConnection();
			Statement stmY=conY.createStatement();
			ResultSet rsY=stmY.executeQuery(vQry);
                        sList = "";
                        while(rsY.next()){
                            if((rsY.getString(FieldVal).trim() == vDefa.trim())){
                                sBool = "SELECTED";
                            }
                            else{
                                sBool = "";
                            }
                            sList = sList + "<OPTION VALUE = '" + rsY.getString(FieldVal) + "' " + sBool + " >";
                            sList = sList + rsY.getString(FieldNO) + "</OPTION>";
                        }
			conY.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

                return sList;

    }


        
    public static final String Decrypt(String str, String key) {
        int lenKey=0;
        int KeyPos=0;
        int LenStr=0;
        int x=0;
        String Newstr="";
        StringBuilder inputStr = new StringBuilder(); 
        StringBuilder outputStr = new StringBuilder(); 
        
        lenKey = key.length();
        KeyPos = 1;
        LenStr = str.length();
        inputStr.append(str);
        inputStr = inputStr.reverse();
                   
        try{
 
            for(x=LenStr;x>0;x--){
                Newstr = Newstr + (char)((int)(inputStr.charAt(x)) - (int)(key.charAt(KeyPos)));
                KeyPos = KeyPos + 1;
                if( KeyPos > lenKey){
                    KeyPos = 1;
                }
            }
            outputStr = outputStr.append(Newstr);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return outputStr.toString();
    }

    public static final String encrypt(String Str, String key){
        int lenKey=0;
        int KeyPos=0;
        int LenStr=0;
        int x=0;
        String Newstr="";
            lenKey = key.length();
            KeyPos = 1;
            LenStr = Str.length();
            StringBuilder inputStr = new StringBuilder(); 
            StringBuilder outputStr = new StringBuilder(); 
            inputStr.append(Str);            
            inputStr = inputStr.reverse();

        try{
            for( x = 1;x<=LenStr;x++){
                Newstr = Newstr + (char)((int)(inputStr.charAt(x)) - (int)(key.charAt(KeyPos)));
                KeyPos = KeyPos + 1;
                if(KeyPos > lenKey){
                    KeyPos = 1;
                }
        }
                        outputStr = outputStr.append(Newstr);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return outputStr.toString();
    }

        
        public static final String getMinutesIntoHours(int min){
                String sList="";

                if(min>0){
                    int h = min/60;
                    int m = min%60;
                    sList = "" + h + "h "+m+"m ";
                }
                return sList;

        }

        public static  BufferedImage resize(BufferedImage img, int height, int width) throws Exception {
    		Image tmp = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    		BufferedImage resized = new BufferedImage(width, height, BufferedImage.SCALE_DEFAULT);
    		Graphics2D g2d = resized.createGraphics();
    		g2d.drawImage(tmp, 0, 0, null);
    		g2d.dispose();
    		return resized;
    	}
        public static final String calculateTwoDate(String start, String end){
        	String myString;
        	// Custom date format
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

    		Date d1 = null;
    		Date d2 = null;
    		try {
    		    d1 = format.parse(start);
    		    d2 = format.parse(end);
    		} catch (ParseException e) {
    		    e.printStackTrace();
    		}    

    		// Get msec from each, and subtract.
    		long diff = d2.getTime() - d1.getTime();
    		//long diffSeconds = diff / 1000;         
    		long diffMinutes = diff / (60 * 1000);         
    		//long diffHours = diff / (60 * 60 * 1000);                      
    		//System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
    		//System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
    		//System.out.println("Time in hours: " + diffHours + " hours."); 
    		
    	/*	covert long to String*/
    		
    		myString= Long.toString(diffMinutes);
        	return myString;
    }
        
        public static final String StartDate(String startDate ){
        	 LocalDate MonthStartDate = LocalDate.now();
    		 LocalDate start = MonthStartDate.withDayOfMonth(1);
    		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
    		  return startDate = start.format(formatter);
    }
        public static final String EndDate(String EndDate ){
       	 LocalDate MonthEndDate = LocalDate.now();
   		 LocalDate End = MonthEndDate.withDayOfMonth(MonthEndDate.lengthOfMonth());
   		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
   		  return EndDate = End.format(formatter);
   }
    
    public static final Float getLeaveBalance(int idno,String chkdate,int leavetypeid){
        String sList="";
		float sumofdebits=0;
		float sumofCredits=0;
		float balance=0f;
        try {
	
        	Connection conX=DBUtil.getConnection();
        	Statement stmX=conX.createStatement();
    		String DebitSql="select sum(noofdays) from hr_leavedebits where idno="+idno+" and leavetypeid="+leavetypeid+" and fromdate<='"+chkdate+"'  and docstatus<>'RJ'";
    		ResultSet sumOfDebitResult=stmX.executeQuery(DebitSql);
    		if(sumOfDebitResult.next()) {
    			sumofdebits=sumOfDebitResult.getFloat(1);
    		}
    		String CreditSql="select sum(noofdays) from hr_leavecredits where idno="+idno+" and leavetypeid="+leavetypeid+" and year=year('"+chkdate+"')";
    		ResultSet sumOfCreditResult=stmX.executeQuery(CreditSql);
    		if(sumOfCreditResult.next()) {
    			sumofCredits=sumOfCreditResult.getFloat(1);
    		}
    		
    		balance=sumofCredits-sumofdebits;
	conX.close();
	}catch(Exception e) {
		e.printStackTrace();
	}

        return balance ;

}
        
}