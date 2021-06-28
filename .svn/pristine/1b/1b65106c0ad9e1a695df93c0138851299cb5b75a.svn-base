package com.hrms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.RequestApprovalDto;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.constants;
import com.hrms.utitlities.dateUtils;

@Repository
public class RequestApprovalDaoImpl implements RequestApprovalDao {
	@Autowired
	private JdbcTemplate template;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String date = dateFormat.format(new Date());
	public int getPassedLevel1Idno(int idno, int activityId) {
		int level1id = 0;
		try {

			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sql = "select level1 from  user_menuaccessrights where idno=" + idno + " and menuitemid="
					+ activityId;
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				level1id = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return level1id;

	}

	@Override
	public Integer getApprovalCount(int idno) {
		int countofResult = 0;
		try {
			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sql = "select count(idno) from tran_docflow where passedto='" + idno + "' and isactive=1";
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				countofResult = rs.getInt(1);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countofResult;
	}

	@Override
	public List<RequestApprovalDto> getApprovalData(int idno) {
		Map<String, Object> map = new HashMap<>();
		List<RequestApprovalDto> li = new ArrayList<>();

		try {

			Connection con = DBUtil.getConnection();
			Statement stm = con.createStatement();
			String sql = "select m.itemname,t.* from tran_docflow t,menu_master m where m.itemid=t.activityid and t.passedto='"
					+ idno + "' and t.isactive=1";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				RequestApprovalDto RequestApprovalDto = new RequestApprovalDto();
				RequestApprovalDto.setDocstatus(rs.getString("docstatus"));
				RequestApprovalDto.setDescription(rs.getString("description"));
				RequestApprovalDto.setInitiatedon(rs.getString("initiatedon"));
				RequestApprovalDto.setDocFlowTranid(rs.getInt("tranid"));
				RequestApprovalDto.setDocType(rs.getString("itemname"));
				li.add(RequestApprovalDto);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public void getNextLevel(int docFlowTranid, int isRejected) {
		try {
			Connection con = null;
			Statement stm = null;
			int employeeid = 0;
			int passedtoid = 0;
			int tranid = 0;
			int docid = 0;
			String docStatus = null;
			String oldDocStatus = null;
			String initiatedon = null;
			String description = null;
			int levelspassedid = 0;
			int lvlid = 0;
			int activityid = 0, deligatedto = 0;
			con = DBUtil.getConnection();
			stm = con.createStatement();
			String sql = "select idno,passedto,docstatus,docid,initiatedon,levelid,activityid,deligatedto,description from tran_docflow where tranid="
					+ docFlowTranid;
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				employeeid = rs.getInt(1);
				passedtoid = rs.getInt(2);
				docStatus = rs.getString(3);
				oldDocStatus = docStatus;
				docid = rs.getInt(4);
				initiatedon = rs.getString(5);
				lvlid = rs.getInt(6);
				activityid = rs.getInt(7);
				deligatedto = rs.getInt(8);
				description = rs.getString(9);
			}

			// check next level approval
			int levelsCompleted = Integer.valueOf(constants.getFieldValue("HRMS",
					"select count(*) from tran_docflow where activityId=" + activityid + " and docid=" + docid, 1));
			int tobeCompleted = 1;
			passedtoid = (-1) * 1;
			lvlid = passedtoid;
			if (levelsCompleted < 4) {
				sql = "select level2,level3,level4 from user_menuaccessrights where idno=" + employeeid
						+ " and menuitemid=" + activityid;
				ResultSet rs1 = stm.executeQuery(sql);
				if (rs1.next()) {
					if (rs1.getInt("level2") > 0) {
						tobeCompleted = tobeCompleted + 1;
					}
					if (rs1.getInt("level3") > 0) {
						tobeCompleted = tobeCompleted + 1;
					}
					if (rs1.getInt("level4") > 0) {
						tobeCompleted = tobeCompleted + 1;
					}
				}
			}
			tobeCompleted = tobeCompleted - levelsCompleted;
			switch (tobeCompleted) {
			case 3: {
				docStatus = "SU";
				lvlid = levelsCompleted + 1;
				break;
			}
			case 2: {
				docStatus = "FZ";
				lvlid = levelsCompleted + 1;
				break;
			}
			case 1: {
				docStatus = "AU";
				lvlid = levelsCompleted + 1;
				break;
			}
			default:
				break;
			}

			if (tobeCompleted <= 0) {
				docStatus = "AU";
				oldDocStatus = "AU";
				passedtoid = 0;
				lvlid = -1;
			}

			if (isRejected == 1) {
				docStatus = "RJ";
				oldDocStatus = "RJ";
				passedtoid = 0;
				lvlid = -1;
			}

			String completedon = dateUtils.getCurrentDateAndtime();

			PreparedStatement pstm = con.prepareStatement("update tran_docflow set isactive=?,completedon=? where tranid=?");
			pstm.setInt(1, 0);
			pstm.setString(2, completedon);
			pstm.setInt(3, docFlowTranid);
			int rst = pstm.executeUpdate();

			if (rst > 0) {
				try {
					pstm = con.prepareStatement("insert into tran_docflow(docid,idno,remarks,docstatus,isactive,initiatedon,passedto,levelid,activityid,deligatedto,completedon,description)  values(?,?,?,?,?,?,?,?,?,?,?,?)");
					pstm.setInt(1, docid);
					pstm.setInt(2, employeeid);
					pstm.setString(3, "updated by " + levelspassedid + ".");
					pstm.setString(4, docStatus);
					if (lvlid < 0) {
						pstm.setInt(5, 0);
					} else {
						pstm.setInt(5, 1);
					}
					pstm.setString(6, initiatedon);
					pstm.setInt(7, levelspassedid);
					pstm.setInt(8, lvlid);
					pstm.setInt(9, activityid);
					pstm.setInt(10, 0);
					pstm.setString(11, completedon);
					pstm.setString(12, description);
					int rst1 = pstm.executeUpdate();
					if (rst1 > 0) {
						String uSql = "";
						if (activityid == 14) {
							uSql = "update hr_increments set docstatus=? where tranid=?";
							if (oldDocStatus.equalsIgnoreCase("AU")) {
								updateRateofPay(docid, employeeid);
							}
						}
						if (activityid == 15) {
							uSql = "update hr_punches set punchstatus=? where tranid=?";
						}
						if (activityid == 16) {
							uSql = "update hr_leavedebits set docstatus=? where transid=?";
						}

						pstm = con.prepareStatement(uSql);
						pstm.setString(1, oldDocStatus);
						pstm.setInt(2, docFlowTranid);
						int rst2 = pstm.executeUpdate();
						if (rst2 > 0) {
							// sucessmessage shoud write here
							System.out.println("updated docflow...");
							// now going to update leavedebits table
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateRateofPay(int docid, int idno) {
		String uSql = "";

		try {
			uSql = "update hr_rateofpay r,hr_increments i set" + "r.wef=i.wef," + "r.basic=i.basic," + "r.da=i.da,"
					+ "r.hra=i.hra," + "r.conveyance=i.conveyance," + "r.others1=i.others1," + "r.others2=i.others2,"
					+ "r.lta=i.lta," + "r.medical=i.medical," + "r.bonus=i.bonus," + "r.grosssalary=i.grosssalary,"
					+ "r.ctc=i.ctc," + "r.pfpercentage=i.pfpercentage," + "r.pfamount=i.pfamount "
					+ " where i.idno=r.idno and i.tranid=?";
			Connection con = DBUtil.getConnection();
			PreparedStatement pstm = con.prepareStatement(uSql);
			pstm.setInt(1, docid);
			int rst = pstm.executeUpdate();
			if (rst > 0) {
				try {
					uSql = "update hr_empmaster r,hr_increments i set" + "r.workingdivisionid=i.divisioinid,"
							+ "r.cadreid=i.cadreid," + "r.jobstatus=i.jobstatusid," + "r.gradeid=i.gradeno,"
							+ "r.desgn=i.desgn " + " where i.idno=r.idno and i.tranid=? and r.idno=?";
					pstm = con.prepareStatement(uSql);
					pstm.setInt(1, docid);
					pstm.setInt(2, idno);
					int rst1 = pstm.executeUpdate();
					if (rst1 > 0) {
						// sucessmessage shoud write here
						System.out.println("updated increment in rateofpay...");
						// now going to update leavedebits table
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Override
	// public void rejectDocument(final int docFlowTranid) {
	// Map<String,Object> map=new HashMap<>();
	// try {
	// Connection con=DBUtil.getConnection();
	// Statement stm=con.createStatement();
	// String sql="select * from tran_docflow where tranid="+docFlowTranid;
	// ResultSet rs=stm.executeQuery(sql);
	// if(rs.next()) {
	// map.put("tranid", rs.getInt(1));
	// map.put("docid", rs.getInt(2));
	// map.put("employeeid", rs.getInt(3));
	// map.put("initiatedon", rs.getString("initiatedon"));
	// map.put("passedto", rs.getInt("passedto"));
	// //return listdto;
	// con.close();
	// }
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	//
	//
	//
	//
	// @Override
	// public void rejectDocument(final int docFlowTranid) {
	// Map<String,Object> map=new HashMap<>();
	// try {
	// Connection con=DBUtil.getConnection();
	// Statement stm=con.createStatement();
	// String sql="select * from tran_docflow where tranid="+docFlowTranid;
	// ResultSet rs=stm.executeQuery(sql);
	// if(rs.next()) {
	// map.put("tranid", rs.getInt(1));
	// map.put("docid", rs.getInt(2));
	// map.put("employeeid", rs.getInt(3));
	// map.put("initiatedon", rs.getString("initiatedon"));
	// map.put("passedto", rs.getInt("passedto"));
	// //return listdto;
	// con.close();
	// }
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	//
	//
	// insertAndUpdateRejectedLeave(map);
	// }
	//
	// private void insertAndUpdateRejectedLeave(Map<String, Object> dataMap) {
	// try {
	// int tranid = 0,docid = 0,employeeid = 0,passedto = 0;
	// String initiatedon = null;
	// for(Map.Entry<String, Object> hm:dataMap.entrySet()) {
	// if(hm.getKey()=="tranid") {
	// tranid=(int) hm.getValue();
	// }
	// if(hm.getKey()=="docid") {
	// docid=(int) hm.getValue();
	// }
	// if(hm.getKey()=="employeeid") {
	// employeeid=(int) hm.getValue();
	// }
	// if(hm.getKey()=="initiatedon") {
	// initiatedon=(String) hm.getValue();
	// }
	// if(hm.getKey()=="passedto") {
	// passedto=(int) hm.getValue();
	// }
	// }
	// updateLeaveDebits(docid);
	// insertTranDocFlow(tranid,docid,employeeid,initiatedon,passedto);
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// private void updateLeaveDebits(int docid) {
	// try {
	// Connection con=DBUtil.getConnection();
	// PreparedStatement pstm=con.prepareStatement("update hr_leavedebits set
	// docstatus=? where transid=?");
	// pstm.setString(1, "RJ");
	// pstm.setInt(2, docid);
	// int rs=pstm.executeUpdate();
	// con.close();
	//
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// private void insertTranDocFlow(int tranid,int docid, int employeeid, String
	// initiatedon, int passedto) {
	// insertNewTrandocFlow(docid,"RJ",employeeid,initiatedon,passedto,1,16,0,"");
	// try {
	// Connection con=DBUtil.getConnection();
	// PreparedStatement pstm=con.prepareStatement("update tran_docflow set
	// passedto=? where tranid=?");
	// pstm.setInt(1, 0);
	// pstm.setInt(2, tranid);
	// int rs=pstm.executeUpdate();
	// con.close();
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public int getLevel2ForEmployeeid(int employeeid,int passedtoid) {
	// int level2passedid=0;
	// int l2=0;
	// int l3=0;
	// try {
	// Connection con=DBUtil.getConnection();
	// Statement stm=con.createStatement();
	// String sql="select level2,level3 from user_menuaccessrights where
	// idno="+employeeid;
	// ResultSet rs=stm.executeQuery(sql);
	// if(rs.next()) {
	// l2=rs.getInt(1);
	// l3=rs.getInt(2);
	// List<Integer> li=new ArrayList<>();
	// li.add(l2);
	// li.add(l3);
	// for(int i=0;i<li.size();i++) {
	//
	// if(passedtoid!=li.get(i)) {
	// level2passedid=li.get(i);
	// break;
	// }
	// }
	//
	// //level2passedid=rs.getInt(1);
	// }
	// con.close();
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	//
	// return level2passedid;
	//
	// }
	//
	//

}
