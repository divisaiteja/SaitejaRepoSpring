package com.hrms.Dao;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.MultiFileUploadDTO;
import com.hrms.utitlities.DBUtil;
@Repository
public class MultiFileUploadDaoImpl implements MultiFileUploadDao {
@Autowired
 private JdbcTemplate jdbcTemplate;
	@Override
	public String multiplefilesave(MultiFileUploadDTO multiFileUpload) {
		String successMessage = "";
		Connection connection =null;
		PreparedStatement statement=null;
		 int result=0;
		 List<MultipartFile> files = multiFileUpload.getMultiUploadedFileList();
		 System.out.println(">>>>>>files>>>>>"+files);
		try {
			connection = DBUtil.getConnection();
		    for (MultipartFile multipartFile : files) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileOutputStream output = null;
			String fileName = multipartFile.getOriginalFilename();
			String extensionOfFileName = fileName.substring(fileName.indexOf(".")+1,fileName.length());
			byte[] bytes2 = multipartFile.getBytes();
			if (null!=extensionOfFileName && extensionOfFileName.equalsIgnoreCase("pdf")) {
				try {
				    output = new FileOutputStream(fileName);
				    String sql = "INSERT INTO hr_documentsupload(idno, filename, filepath,description) values (?,?,?,?)";
				    if (connection!=null) {
				    	System.out.println("Connection success");
				    	  statement   = connection.prepareStatement(sql);
				    	  System.out.println("sql    "+sql);
				            statement.setInt(1, 1);
				            statement.setString(2, fileName);
						    statement.setBytes(3, bytes2 );
						    statement.setString(4, "Yes");
						    result = statement.executeUpdate();
				            System.out.println(result + " row(s) affected !!");
					}
				} catch (Exception e) {
				    e.printStackTrace();
				} finally {
				    baos.close();
				    output.close();
				}
			    
			}  else if (null != extensionOfFileName && extensionOfFileName.equalsIgnoreCase("jpg")) {
			   byte[] bytes = multipartFile.getBytes();
			    String sql = "INSERT INTO hr_documentsupload(idno, filename,filepath,description) values (?,?,?,?)";
				    if (connection!=null) {
				    	System.out.println("Connection success");
				    	  statement   = connection.prepareStatement(sql);
				    	    System.out.println("sql    "+sql);
				            statement.setInt(1, 1);
				            statement.setString(2, fileName);
						    statement.setBytes(3,  bytes);
						    statement.setString(4, "Yes");
						    result = statement.executeUpdate();
				            System.out.println(result + " row(s) affected !!");
					}
			}else {
			    System.out.println("Unknown file extension"
			+extensionOfFileName);
			}

		    }
		connection.close();
	 } catch (Exception e1) {
			e1.printStackTrace();
		}
		if(result>0) {
			successMessage ="Updates Sucessfully";
	} else {
		successMessage = "Not Updates";
	}
		
		return successMessage  ;
	}

	@Override
	public void singlefilesave(final Integer transactiontranid,final String filename, MultipartFile document) {
		try {
			 final byte[]  bytes = document.getBytes();
			String sql="insert into compliance_transaction_uploads(transactiontranid,filename,file) values(?,?,?)";
			jdbcTemplate.execute(sql ,new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1,transactiontranid );
				ps.setString(2, filename);
				ps.setBytes(3, bytes);
				return ps.execute();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
