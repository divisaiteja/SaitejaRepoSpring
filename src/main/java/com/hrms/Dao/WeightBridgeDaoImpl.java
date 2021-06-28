package com.hrms.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bridj.cpp.std.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hrms.dtos.WeightBridgeDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class WeightBridgeDaoImpl implements WeightBridgeDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public String newRegistration(final WeightBridgeDTO weightBridgeDTO) {
		String resultMessage = "";

		String sql = "insert into wb_inwardregister(truckno,itemcode,inwardtype,inwarddate)values(?,?,?,sysdate())";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, weightBridgeDTO.getTruckno());
				ps.setString(2, weightBridgeDTO.getItemcode());
				ps.setString(3, weightBridgeDTO.getInwardtype());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.New_Vehicle__Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.New_Vehicle__Details_NotSave;
		}

		return resultMessage;
	}

	@Override
	public List<WeightBridgeDTO> getEnquiryInfoBasedonInwardNumber(int inwardno) {
		return template.query("select * from wb_inwardregister where  inwardno=" + inwardno,
				new ResultSetExtractor<List<WeightBridgeDTO>>() {
					@Override
					public List<WeightBridgeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<WeightBridgeDTO> listdto = new ArrayList<WeightBridgeDTO>();
						if (rs.next()) {
							WeightBridgeDTO dto = new WeightBridgeDTO();

							dto.setOrderno(rs.getString("orderno"));
							dto.setOrderdate(rs.getString("orderdate"));
							dto.setSupcustname(rs.getString("supcustname"));
							dto.setMaterialname(rs.getString("materialname"));
							dto.setLrno(rs.getInt("lrno"));
							dto.setDcno(rs.getInt("dcno"));
							dto.setDCDate(rs.getString("DCDate"));
							dto.setDcqty(rs.getFloat("dcqty"));
							dto.setRefno(rs.getString("refno"));
							dto.setTransporter(rs.getString("transporter"));
							dto.setGrosswt(rs.getFloat("grosswt"));
							dto.setTarewt(rs.getFloat("tarewt"));
							dto.setNetwt(rs.getFloat("netwt"));
							listdto.add(dto);
						}
						return listdto;
					}

				});

	}

	@Override
	public String saveFirstWeight(final WeightBridgeDTO weightBridgeDTO) {

		String resultMessage = "";
		String sql = "update  wb_inwardregister set truckno=?,inwardtype=?,inwarddate=sysdate(),grosswt=?,tarewt=?,netwt=? where inwardno=? ";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, weightBridgeDTO.getTruckno());
				ps.setString(2, weightBridgeDTO.getInwardtype());
				ps.setFloat(3, weightBridgeDTO.getGrosswt());
				ps.setFloat(3, weightBridgeDTO.getTarewt());
				ps.setFloat(5, weightBridgeDTO.getNetwt());
				ps.setInt(6, weightBridgeDTO.getInwardno());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.First_Weight_Save;
		} else {
			resultMessage = HrmsMessageConstants.First_Weight_NotSave;
		}

		return resultMessage;
	}

	@Override
	public String saveSecondWeight(final WeightBridgeDTO weightBridgeDTO) {

		String resultMessage = "";

		String sql = "update  wb_inwardregister set truckno=?,inwardtype=?,inwarddate=sysdate(),grosswt=?,tarewt=?,netwt=?  where inwardno=?";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, weightBridgeDTO.getTruckno());
				ps.setString(2, weightBridgeDTO.getInwardtype());
				ps.setFloat(3, weightBridgeDTO.getGrosswt());
				ps.setFloat(3, weightBridgeDTO.getTarewt());
				ps.setFloat(5, weightBridgeDTO.getNetwt());
				ps.setInt(6, weightBridgeDTO.getInwardno());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Second_Weight_Save;
		} else {
			resultMessage = HrmsMessageConstants.Second_Weight_NotSave;
		}

		return resultMessage;
	}

	@Override
	public String saveEnquiry(final WeightBridgeDTO weightBridgeDTO) {

		String resultMessage = "";

		String sql = "update  wb_inwardregister set orderno=?,transporter=?,refno=?,dcqty=?,DCDate=?,dcno=?,lrno=?,materialname=?,supcustname=?,orderdate=?  where inwardno=?";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, weightBridgeDTO.getOrderno());
				ps.setString(2, weightBridgeDTO.getTransporter());
				ps.setString(3, weightBridgeDTO.getRefno());
				ps.setFloat(4, weightBridgeDTO.getDcqty());
				ps.setString(5, weightBridgeDTO.getDCDate());
				ps.setInt(6, weightBridgeDTO.getDcno());
				ps.setInt(7, weightBridgeDTO.getLrno());
				ps.setString(8, weightBridgeDTO.getMaterialname());
				ps.setString(9, weightBridgeDTO.getSupcustname());
				ps.setString(10, weightBridgeDTO.getOrderdate());
				ps.setFloat(11, weightBridgeDTO.getNetwt());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Enquiry_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Enquiry_Details_NotSave;
		}

		return resultMessage;

	}

	@Override
	public List<Map<Object, Object>> WeightBridgeTimeAnalysis( String Material,String Customer,String Transporter,String Sources) {
		//System.out.println("............"+Material+"..."+Customer+"....."+Transporter+"..."+Sources+"  ");
		String sql ;
		if (Material.isEmpty() || Customer.isEmpty() || Transporter.isEmpty()|| Sources.isEmpty() ) {
			sql = "select * from wb_inwardregister";
		} else{
			sql = "select * from wb_inwardregister where materialname='"+Material+"' and transporter='"+Transporter+"' and supcustname='"+Customer+"' and soudest='"+Sources+"' ";
		}
		
	//	System.out.println("sql>>>" + sql);
		return template.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				int sno = 0;
				String status = "";
				String calculate = "";
				String duration;
				Integer cal = 0;
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					sno = sno + 1;
					calculate = constants.calculateTwoDate(rs.getString("securityin"), rs.getString("securityout"));
					//System.out.println("calculate>>>>>>" + calculate);
					/*convert String calculate To Integer cal*/
					cal = Integer.parseInt(calculate);
					duration = constants.getMinutesIntoHours(cal);
					map.put("sno", sno);
					map.put("inwardno", rs.getInt("inwardno"));
					map.put("truckno", rs.getString("truckno"));
					map.put("netwt", rs.getFloat("netwt"));
					map.put("securityin", rs.getString("securityin"));
					map.put("securityout", rs.getString("securityout"));
					map.put("status", status);
					map.put("duration", duration);
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> WeightBridgeRegister() {
		String sql = "select inwardno,truckno,grosswt,tarewt,netwt,grossdt,taredt from wb_inwardregister";
		return template.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				int ReportNum = 0;
				String status = "";
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					ReportNum = ReportNum + 1;
					map.put("ReportNum", ReportNum);
					map.put("inwardno", rs.getInt("inwardno"));
					map.put("truckno", rs.getString("truckno"));
					map.put("grosswt", rs.getFloat("grosswt"));
					map.put("tarewt", rs.getFloat("tarewt"));
					map.put("netwt", rs.getFloat("netwt"));
					map.put("grossdt", rs.getString("grossdt"));
					map.put("taredt", rs.getString("taredt"));
					map.put("status", status);
					
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> FilterStringMaterial() {
		String sql = "select materialname from wb_inwardregister";
		return template.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("materialname", rs.getString("materialname"));
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> FilterStringCustomer() {

		String sql = "select supcustname from wb_inwardregister";
		return template.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("supcustname", rs.getString("supcustname"));
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> FilterStringTransporter() {

		String sql = "select transporter from wb_inwardregister";
		return template.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("transporter", rs.getString("transporter"));
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> FilterStringSource() {

		String sql = "select soudest from wb_inwardregister";
		return template.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				while (rs.next()) {
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("soudest", rs.getString("soudest"));
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> QualityReport(String infodate) {
		Connection connection=null;
		Statement statement=null;
		Statement statement1=null;
		Statement statement2=null;
		Statement statement3=null;
		Statement statement4=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		 connection = DBUtil.getConnection();
		 List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		try {
			 statement = connection.createStatement();	
			 statement1 = connection.createStatement();	
			 statement2 = connection.createStatement();	
			 statement3 = connection.createStatement();	
			 statement4 = connection.createStatement();	
			String sql="select orderno,inwardno,supcustname,inwarddate,netwt from wb_inwardregister where inwarddate=STR_TO_DATE('"+infodate+"','%d-%m-%Y') order by orderno,inwardno";
			//System.out.println("sql>>"+sql);
			rs = statement.executeQuery(sql);
			int rate=0;
			int lessamount=0;
			String signature="";
			while(rs.next()) {
				SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
				String inwarddate="";
				if(rs.getDate("inwarddate")!=null) {
					inwarddate=format.format(rs.getDate("inwarddate"));
				}
				Map<Object, Object> map = new HashMap<Object, Object>();
				map.put("orderno", rs.getString("orderno"));
				map.put("inwardno", rs.getInt("inwardno"));
				map.put("supcustname", rs.getString("supcustname"));
				map.put("inwarddate",inwarddate );
				map.put("netwt", rs.getFloat("netwt"));
				map.put("rate", rate);
				map.put("lessamount", lessamount);
				map.put("signature", signature);
				String sql1="select oil,ffa,moisture from qc_register where inwardno="+rs.getInt("inwardno")+" and usertype=1";
				//System.out.println("userType1  "+sql1);
				rs1 = statement1.executeQuery(sql1);
				Float flo=0.0f;
				String remarks="";
				if(rs1.next()) {
					map.put("preoil", rs1.getFloat("oil"));
					map.put("preffa", rs1.getFloat("ffa"));
					map.put("premoisture",rs1.getFloat("moisture"));
				}else {
					map.put("preoil", flo);
					map.put("preffa", flo);
					map.put("premoisture",flo);
				}
				String sql2="select oil,ffa,moisture,remarks from qc_register where inwardno="+rs.getInt("inwardno")+" and usertype=2";
				rs2 = statement2.executeQuery(sql2);
				if(rs2.next()) {
					map.put("weighbridgetoil", rs2.getFloat("oil"));
					map.put("weighbridgeffa", rs2.getFloat("ffa"));
					map.put("weighbridgemoisture",rs2.getFloat("moisture"));
					map.put("weighbridgeremarks",rs2.getString("remarks"));
				}else {
					map.put("weighbridgeoil", flo);
					map.put("weighbridgeffa", flo);
					map.put("weighbridgemoisture",flo);
					map.put("weighbridgeremarks",remarks);
				}
				
				String sql3="select oil,ffa,moisture,remarks from qc_register where inwardno="+rs.getInt("inwardno")+" and usertype=3";
				rs3 = statement3.executeQuery(sql3);
				if(rs3.next()) {
					map.put("unloadingoil", rs3.getFloat("oil"));
					map.put("unloadingffa", rs3.getFloat("ffa"));
					map.put("unloadingmoisture",rs3.getFloat("moisture"));
					map.put("unloadingremarks",rs3.getString("remarks"));
				}else {
					map.put("unloadingoil", flo);
					map.put("unloadingffa", flo);
					map.put("unloadingmoisture",flo);
					map.put("unloadingremarks",remarks);
				}
				
				String sql4="select oil,ffa,moisture from qc_register where inwardno="+rs.getInt("inwardno")+" and usertype=4";
				rs4 = statement4.executeQuery(sql4);
				if(rs4.next()) {
					map.put("postoil", rs4.getFloat("oil"));
					map.put("postffa", rs4.getFloat("ffa"));
					map.put("postmoisture",rs4.getFloat("moisture"));
				}else {
					map.put("postoil", flo);
					map.put("postffa", flo);
					map.put("postmoisture",flo);
				}
				list.add(map);
			}
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
