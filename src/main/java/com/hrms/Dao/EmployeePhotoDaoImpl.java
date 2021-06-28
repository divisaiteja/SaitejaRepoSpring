package com.hrms.Dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.EmployeePhotoDTO;
import com.hrms.utitlities.DBUtil;

@Repository
public class EmployeePhotoDaoImpl implements EmployeePhotoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EmployeePhotoDTO getphotobasedonempid(Integer empid) {
		String sql = "select photo from hr_employeephotos where empid =" + empid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<EmployeePhotoDTO>() {
			@Override
			public EmployeePhotoDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
				EmployeePhotoDTO photoDTO = new EmployeePhotoDTO();
				try {
					if (rs.next()) {
						Blob blob = rs.getBlob("photo");
						if (blob != null) {
							InputStream inputStream = blob.getBinaryStream();
							ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							byte[] buffer = new byte[4096];
							int bytesRead = -1;
							while ((bytesRead = inputStream.read(buffer)) != -1) {
								outputStream.write(buffer, 0, bytesRead);
							}
							byte[] imageBytes = outputStream.toByteArray();
							String base64Image = Base64.getEncoder().encodeToString(imageBytes);
							inputStream.close();
							outputStream.close();
							photoDTO.setBase64Image(base64Image);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return photoDTO;
			}
		});
	}

	@Override
	public EmployeePhotoDTO displayimageandpdf(String filename) {
		String sql = "select file from compliance_transaction_uploads where filename='" + filename + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<EmployeePhotoDTO>() {
			@Override
			public EmployeePhotoDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
				EmployeePhotoDTO photoDTO = new EmployeePhotoDTO();
				try {
					if (rs.next()) {
						Blob blob = rs.getBlob("file");
						if (blob != null) {
							InputStream inputStream = blob.getBinaryStream();
							ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							byte[] buffer = new byte[4096];
							int bytesRead = -1;
							while ((bytesRead = inputStream.read(buffer)) != -1) {
								outputStream.write(buffer, 0, bytesRead);
							}
							byte[] imageBytes = outputStream.toByteArray();
							String base64Image = Base64.getEncoder().encodeToString(imageBytes);
							inputStream.close();
							outputStream.close();
							photoDTO.setBase64Image(base64Image);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return photoDTO;
			}
		});
	}

	@Override
	public void LoginPhoto(MultipartFile canvas) {
		try {
			final byte[] photoBytes = canvas.getBytes();
			String sql = "insert into hr_documentsupload(idno,filename,filepath,description)values(?,?,?,?)";
			jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, 10);
					ps.setString(2, "sample");
					ps.setBytes(3, photoBytes);
					ps.setString(4, "yes");
					return ps.execute();

				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
