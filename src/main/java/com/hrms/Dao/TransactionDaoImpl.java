package com.hrms.Dao;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.Cm_Legislative_MasterDTO;
import com.hrms.dtos.Cm_frequency_masterDTO;
import com.hrms.dtos.ComplianceDTO;
import com.hrms.dtos.DocumentsDTO;
import com.hrms.utitlities.DBUtil;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<ComplianceDTO> getAllTransaction() {
		String sql = "select tranid,complianceid,title,description,clause_act,legislativeid,penalty,compliancetype,frequencyid,iscritical,duedate,proofsrequired,alertdays,isactive,docstatus from compliance_transaction";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ComplianceDTO>>() {

			@Override
			public List<ComplianceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ComplianceDTO> list = new ArrayList<ComplianceDTO>();
				while (rs.next()) {
					SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
					String duedate="";
					if(rs.getDate("duedate")!=null) {
						duedate=format.format(rs.getDate("duedate"));
					}
					ComplianceDTO dto = new ComplianceDTO();
					dto.setTranid(rs.getInt("tranid"));
					dto.setComplianceid(rs.getInt("complianceid"));
					dto.setTitle(rs.getString("title"));
					dto.setDescription(rs.getString("description"));
					dto.setClauseact(rs.getString("clause_act"));
					dto.setLegislativeid(rs.getInt("legislativeid"));
					dto.setPenality(rs.getString("penalty"));
					dto.setCompliancetype(rs.getString("compliancetype"));
					dto.setFrequencyid(rs.getInt("frequencyid"));
					switch (rs.getInt("iscritical")) {
					case 1: {
						dto.setIscriticalstatus(constants.yes);
						break;
					}
					case 0: {
						dto.setIscriticalstatus(constants.no);
						break;
					}
					default:
						dto.setIscriticalstatus(constants.NotFound);
						break;
					}
					dto.setIscritical(rs.getInt("iscritical"));
					dto.setDuedate(duedate);
					switch (rs.getInt("proofsrequired")) {
					case 1: {
						dto.setProofsrequiredstatus(constants.yes);
						break;
					}

					case 0: {
						dto.setProofsrequiredstatus(constants.no);
						break;
					}

					default:
						dto.setProofsrequiredstatus(constants.NotFound);
						break;
					}
					dto.setProofsrequired(rs.getInt("proofsrequired"));
					dto.setAlertdays(rs.getInt("alertdays"));
					switch (rs.getInt("isactive")) {
					case 1: {
						dto.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						dto.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						dto.setStatusCodeForActive(constants.NotFound);
						break;
					}
					dto.setIsactive(rs.getInt("isactive"));
					dto.setDocstatus(rs.getString("docstatus"));
					list.add(dto);
				}
				return list;
			}
		});

	}

	@Override
	public List<ComplianceDTO> getTranscationBasedOnTranid(int tranid) {
		String sql = "select t.tranid,t.complianceid,t.title,t.description,t.clause_act,t.legislativeid,t.penalty,t.compliancetype,t.frequencyid,t.iscritical,t.duedate,t.proofsrequired,t.alertdays,t.isactive,t.nextduedate,t.duedays,t.initiateddate,t.docstatus,t.ownername,m.legislativedescription,fm.frequency_description from compliance_transaction t join cm_legislative_master m  on t.legislativeid=m.legislativeid  join cm_frequency_master fm on t.frequencyid=fm.frequencyid  where tranid="
				+ tranid;
		// System.out.println("sql"+sql);
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ComplianceDTO>>() {
			@Override
			public List<ComplianceDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<ComplianceDTO> list = new ArrayList<ComplianceDTO>();
				if (rs.next()) {
					SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
					String initiateddate="";
					String duedate="";
					if(rs.getDate("initiateddate")!=null) {
						initiateddate=format.format(rs.getDate("initiateddate"));
					}
					if(rs.getDate("duedate")!=null) {
						duedate=format.format(rs.getDate("duedate"));
					}
					ComplianceDTO dto = new ComplianceDTO();
					Cm_Legislative_MasterDTO legislativeMasterDTO = new Cm_Legislative_MasterDTO();
					Cm_frequency_masterDTO frequencymasterDTO = new Cm_frequency_masterDTO();
					legislativeMasterDTO.setLegaslativedescription(rs.getString("legislativedescription"));
					frequencymasterDTO.setFrequencydescription(rs.getString("frequency_description"));
					dto.setFrequencymasterDTO(frequencymasterDTO);
					dto.setLegislativeMasterDTO(legislativeMasterDTO);
					dto.setTranid(rs.getInt("tranid"));
					dto.setComplianceid(rs.getInt("complianceid"));
					dto.setTitle(rs.getString("title"));
					dto.setDescription(rs.getString("description"));
					dto.setClauseact(rs.getString("clause_act"));
					dto.setLegislativeid(rs.getInt("legislativeid"));
					dto.setPenality(rs.getString("penalty"));
					dto.setCompliancetype(rs.getString("compliancetype"));
					dto.setFrequencyid(rs.getInt("frequencyid"));
					switch (rs.getInt("iscritical")) {
					case 1: {
						dto.setIscriticalstatus(constants.yes);
						break;
					}
					case 0: {
						dto.setIscriticalstatus(constants.no);
						break;
					}
					default:
						dto.setIscriticalstatus(constants.NotFound);
						break;
					}
					dto.setIscritical(rs.getInt("iscritical"));
					dto.setDuedate(duedate);
					switch (rs.getInt("proofsrequired")) {
					case 1: {
						dto.setProofsrequiredstatus(constants.yes);
						break;
					}

					case 0: {
						dto.setProofsrequiredstatus(constants.no);
						break;
					}

					default:
						dto.setProofsrequiredstatus(constants.NotFound);
						break;
					}
					dto.setProofsrequired(rs.getInt("proofsrequired"));
					dto.setAlertdays(rs.getInt("alertdays"));
					switch (rs.getInt("isactive")) {
					case 1: {
						dto.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						dto.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						dto.setStatusCodeForActive(constants.NotFound);
						break;
					}
					dto.setIsactive(rs.getInt("isactive"));
					dto.setNextduedate(rs.getString("nextduedate"));
					dto.setDuedays(rs.getInt("duedays"));
					dto.setInitiateddate(initiateddate);
					dto.setDocstatus(rs.getString("docstatus"));
					dto.setOwnername(rs.getString("ownername"));
					list.add(dto);
				}
				return list;
			}
		});
	}

	@Override
	public List<DocumentsDTO> getAllComplianceTransactionUploadsBasedOnTranid(int tranid) {
		String sql = "select tranid,transactiontranid,filename,file,flag from compliance_transaction_uploads where transactiontranid="
				+ tranid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<DocumentsDTO>>() {

			@Override
			public List<DocumentsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<DocumentsDTO> list = new ArrayList<DocumentsDTO>();
				while (rs.next()) {
					DocumentsDTO documentsDTO = new DocumentsDTO();
					documentsDTO.setTranid(rs.getInt("tranid"));
					documentsDTO.setIdno(rs.getInt("transactiontranid"));
					documentsDTO.setFilename(rs.getString("filename"));
					documentsDTO.setFilepath(rs.getBytes("file"));
					documentsDTO.setFlag(rs.getString("flag"));
					list.add(documentsDTO);
				}

				return list;
			}
		});
	}

	@Override
	public void TransactionstoreDocuments(final int tranid, List<MultipartFile> files) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement statement = null;
		try {
			for (MultipartFile multipartFile : files) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				FileOutputStream output = null;
				String fileName = multipartFile.getOriginalFilename();
				String	concate=null;
				try {
					if(connection!=null) {
					Statement createStatement = connection.createStatement();
					String sq = "select initiateddate from compliance_transaction where tranid=" + tranid;
					ResultSet rs = createStatement.executeQuery(sq);
					SimpleDateFormat format=new SimpleDateFormat("MMM-yyyy");
					String initiateddate="";
					if(rs.next()) {
					if(rs.getDate("initiateddate")!=null) {
						initiateddate=format.format(rs.getDate("initiateddate"));
						concate = fileName + "  tranid_" +tranid + "_" + initiateddate ;
					}
					}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String extensionOfFileName = fileName.substring(fileName.indexOf(".")+1,fileName.length());
				byte[] bytes2 = multipartFile.getBytes();
				if (null!=extensionOfFileName && extensionOfFileName.equalsIgnoreCase("pdf")) {
					try {
					    output = new FileOutputStream(fileName);
					    String sql = "insert into compliance_transaction_uploads(transactiontranid,filename,file,flag)values(?,?,?,?)";
					    if (connection!=null) {
					    	//System.out.println("Connection success");
					    	  statement   = connection.prepareStatement(sql);
					    	  System.out.println("sql    "+sql);
					            statement.setInt(1, tranid);
					            statement.setString(2, concate);
							    statement.setBytes(3, bytes2 );
							    statement.setString(4, "T");
							    int result = statement.executeUpdate();
					            System.out.println(result + " row(s) affected !!");
						}
					} catch (Exception e) {
					    e.printStackTrace();
					} finally {
					    baos.close();
					    output.close();
					}
				    
				}  else if (null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("jpg") || null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("jpeg") || null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("png")) {
				   byte[] bytes = multipartFile.getBytes();
				    String sql = "insert into compliance_transaction_uploads(transactiontranid,filename,file,flag)values(?,?,?,?)";
				             if (connection!=null) {
					    	  System.out.println("Connection success");
					    	  statement   = connection.prepareStatement(sql);
					    	  InputStream inputStream = new ByteArrayInputStream(bytes);
					    	  BufferedImage image = ImageIO.read(inputStream);
					    	  constants.resize(image, 100, 100); 
					    	  ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
								RenderedImage resize = constants.resize(image, 100, 100);
								ImageIO.write(resize, extensionOfFileName, baos1);
								baos1.flush();
								final byte[] photoreduce = baos1.toByteArray();
					    	    System.out.println("sql    "+sql);
					            statement.setInt(1, tranid);
					            statement.setString(2,concate );
							    statement.setBytes(3,  photoreduce);
							    statement.setString(4, "T");
							    statement.executeUpdate();
					            System.out.println( " row(s) affected !!");
						}
				}
				else {
				    System.out.println("Unknown file extension"+extensionOfFileName);
				}
			}
			/*Statement createStatement1 = connection.createStatement();
			String sql = "select docstatus from compliance_transaction where tranid=" + tranid;
			ResultSet rs1 = createStatement1.executeQuery(sql);
			if (rs1.next()) {
				String doc = rs1.getString("docstatus");
				if (doc.contains("FR")) {
					String update = "update compliance_transaction set docstatus ='SU' where tranid=" + tranid;
					statement = connection.prepareStatement(update);
					statement.executeUpdate();
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void TransactiondeleteDocuments(final int tranid) {
		String deleteQuery = "delete from compliance_transaction_uploads where tranid=?";

		jdbcTemplate.execute(deleteQuery, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void TransactionPhoto(int tranid, List<MultipartFile> files, String remarks,
			String duedate, String Remidiationplan,String complied) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement statement = null;
		try {
			for (MultipartFile multipartFile : files) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					FileOutputStream output = null;
					String fileName = multipartFile.getOriginalFilename();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
					  Date date = new Date(); 
					//  System.out.println(dateFormat.format(date));
					String	concate=null;
					try {
						if(connection!=null) {
						Statement createStatement = connection.createStatement();
						String sq = "select initiateddate from compliance_transaction where tranid=" + tranid;
						ResultSet rs = createStatement.executeQuery(sq);
						SimpleDateFormat format=new SimpleDateFormat("MMM-yyyy");
						String initiateddate="";
						if(rs.next()) {
						if(rs.getDate("initiateddate")!=null) {
							initiateddate=format.format(rs.getDate("initiateddate"));
							concate = fileName + "  tranid_" +tranid + "_" + initiateddate ;
						}
						}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					String extensionOfFileName = fileName.substring(fileName.indexOf(".")+1,fileName.length());
					byte[] bytes2 = multipartFile.getBytes();
					if (null!=extensionOfFileName && extensionOfFileName.equalsIgnoreCase("pdf")) {
						try {
						    output = new FileOutputStream(fileName);
							String sql = "insert into compliance_transaction_uploads(transactiontranid,filename,file,flag)values(?,?,?,?)";
						    if (connection!=null) {
						    	//System.out.println("Connection success");
						    	  statement   = connection.prepareStatement(sql);
						    	 // System.out.println("sql    "+sql);
						            statement.setInt(1, tranid);
						            statement.setString(2, concate);
								    statement.setBytes(3, bytes2 );
								    statement.setString(4, "R");
								    int result = statement.executeUpdate();
								    
						           // System.out.println(result + " row(s) affected !!");
							}
						} catch (Exception e) {
						    e.printStackTrace();
						} finally {
						    baos.close();
						    output.close();
						}
					    
					}  else if (null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("jpg") || null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("jpeg") || null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("png")) {
					   byte[] bytes = multipartFile.getBytes();
						String sql = "insert into compliance_transaction_uploads(transactiontranid,filename,file,flag)values(?,?,?,?)";
					   if (connection!=null) {
						    	 // System.out.println("Connection success");
						    	  statement   = connection.prepareStatement(sql);
						    	  InputStream inputStream = new ByteArrayInputStream(bytes);
						    	  BufferedImage image = ImageIO.read(inputStream);
						    	  constants.resize(image, 100, 100); 
						    	  ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
									RenderedImage resize = constants.resize(image, 100, 100);
									ImageIO.write(resize, extensionOfFileName, baos1);
									baos1.flush();
									final byte[] photoreduce = baos1.toByteArray();
						    	  //  System.out.println("sql    "+sql);
						            statement.setInt(1, tranid);
						            statement.setString(2,concate );
								    statement.setBytes(3,  photoreduce);
								    statement.setString(4, "R");
								    statement.executeUpdate();
						           // System.out.println( " row(s) affected !!");
							}
					}
					else if (null!=extensionOfFileName && extensionOfFileName.equalsIgnoreCase("xlsx") || null!=extensionOfFileName && extensionOfFileName.equalsIgnoreCase("csv") ) {
						try {
							byte[] bytes = multipartFile.getBytes();
						    output = new FileOutputStream(fileName);
							String sql = "insert into compliance_transaction_uploads(transactiontranid,filename,file,flag)values(?,?,?,?)";
						    if (connection!=null) {
						    	System.out.println("Connection success");
						    	  statement   = connection.prepareStatement(sql);
						    	  System.out.println("sql    "+sql);
						            statement.setInt(1, tranid);
						            statement.setString(2, concate);
								    statement.setBytes(3, bytes );
								    statement.setString(4, "R");
								    int result = statement.executeUpdate();
						           System.out.println(result + " row(s) affected !!");
							}
						} catch (Exception e) {
						    e.printStackTrace();
						}
					}
					else {
					    System.out.println("Unknown file extension"+extensionOfFileName);
					}
				}
			if ((null != duedate && duedate.length() != 0) && (null != Remidiationplan && Remidiationplan.length() != 0)
					&& (tranid != 0)) {
				String res="select transactiontranid  from compliance_transaction_remidiationplan where transactiontranid="+tranid;
				 ResultSet rs = statement.executeQuery(res);
				 if(rs.next()) {
				int id=	 rs.getInt("transactiontranid");
				 if(id!=0) {
					String update="update compliance_transaction_remidiationplan set remidiationdescription=?,alertdate=STR_TO_DATE(?,'%d-%m-%Y') where transactiontranid="+tranid;
					statement = connection.prepareStatement(update);
					statement.setString(1, Remidiationplan);
					statement.setString(2, duedate);
					statement.executeUpdate();
				 }
				 
				 }
				  else{
					String insert = "insert into compliance_transaction_remidiationplan(transactiontranid,remidiationdescription,alertdate) values(?,?,STR_TO_DATE(?,'%d-%m-%Y'))";
					statement = connection.prepareStatement(insert);
					statement.setInt(1, tranid);
					statement.setString(2, Remidiationplan);
					statement.setString(3, duedate);
					statement.executeUpdate();
					 }
					 
				
			}
			Statement createStatement = connection.createStatement();
			String sql = "select docstatus,complied from compliance_transaction where tranid=" + tranid;
			ResultSet rs = createStatement.executeQuery(sql);
			if (rs.next()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				  Date date = new Date(); 
				String doc = rs.getString("docstatus");
				if (doc.contains("FR")) {
					String update = "update compliance_transaction set docstatus =?,complied=?,submitteddate=?,transactionremarks=? where tranid=" + tranid;
					statement = connection.prepareStatement(update);
					statement.setString(1, "SU");
					statement.setString(2, complied);
					statement.setString(3, dateFormat.format(date));
					statement.setString(4, remarks);
					statement.executeUpdate();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public List<Map<Object, Object>> getFilenamesBasedOnTransactionid(Integer transactiontranid) {
		String sql="select filename from compliance_transaction_uploads where transactiontranid="+transactiontranid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {

			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
				while (rs.next()) {
					HashMap<Object,Object> map = new HashMap<Object,Object>();
					 map.put("filename", rs.getString("filename"));
					list.add(map);
				}
				return list ;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> getComplianceTrasactionBasedTranid(Integer transactiontranid) {
		String sql="select complied,submitteddate,transactionremarks from compliance_transaction where tranid="+transactiontranid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
				while (rs.next()) {
					SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String submitteddate="";
					if(rs.getDate("submitteddate")!=null) {
						submitteddate=format.format(rs.getTimestamp("submitteddate"));
					}
					Map<Object,Object> map = new HashMap<Object,Object>();
					 map.put("complied", rs.getString("complied"));
					 map.put("submitteddate", submitteddate);
					 map.put("transactionremarks", rs.getString("transactionremarks"));
					list.add(map);
				}
				return list;
			}
		});
	}

	@Override
	public List<Map<Object, Object>> getRemidiationBasedTranid(Integer transactiontranid) {
		String sql="select remidiationdescription,alertdate from compliance_transaction_remidiationplan where transactiontranid="+transactiontranid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<Object, Object>>>() {
			@Override
			public List<Map<Object, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
				while (rs.next()) {
					SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
					String alertdate="";
					if(rs.getDate("alertdate")!=null) {
						alertdate=format.format(rs.getDate("alertdate"));
					}
					Map<Object,Object> map = new HashMap<Object,Object>();
					 map.put("remidiationdescription", rs.getString("remidiationdescription"));
					 map.put("alertdate", alertdate);
					list.add(map);
				}
				return list;
			}
		});
	}
	
	@Override
	public String ApproverStatus(Integer transactiontranid,final String approvertext) {
		String resultMessage = "";
		String sql="update compliance_transaction set docstatus=?,approvelreason=? where tranid="+transactiontranid;
		 Integer result=jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, "AU");
				ps.setString(2, approvertext);
				return ps.executeUpdate();
			}
		});
			if (result > 0) {
				resultMessage = result > 0 ? HrmsMessageConstants.Update_success
						: HrmsMessageConstants.update_Fail;
				return resultMessage;
			}
			return resultMessage ;
	}

	@Override
	public String RejectedStatus(Integer transactiontranid,final String rejectedtext) {
		String resultMessage = "";
		String sql="update compliance_transaction set docstatus=?,rejectedreason=? where tranid="+transactiontranid;
		Integer result=jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, "FR");
				ps.setString(2, rejectedtext);
				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			resultMessage = result > 0 ? HrmsMessageConstants.Update_success
					: HrmsMessageConstants.update_Fail;
			return resultMessage;
		}
		return resultMessage ;
	}

	

	

	
}