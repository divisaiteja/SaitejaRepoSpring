package com.hrms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.ContractorDocumentsDTO;

@Repository
public class ContractorDocumentsDaoImpl implements ContractorDocumentsDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<ContractorDocumentsDTO> getAllStoreDocumentByContractorId(int contractorId) {
		return template.query("select * from hr_contractordocuments where contractorid=" + contractorId,
				new ResultSetExtractor<List<ContractorDocumentsDTO>>() {
					@Override
					public List<ContractorDocumentsDTO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<ContractorDocumentsDTO> listdto = new ArrayList<ContractorDocumentsDTO>();
						while (rs.next()) {
							ContractorDocumentsDTO dto = new ContractorDocumentsDTO();
							dto.setContractorid(rs.getInt("contractorid"));
							dto.setDocumentdetails(rs.getString("documentdetails"));
							dto.setTranid(rs.getInt("tranid"));
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

	@Override
	public void storeDocuments(final int contractorid, MultipartFile photo,final String documentdetails) {
		try {
			final byte[] photoBytes = photo.getBytes();
			String sql = "insert into hr_contractordocuments(contractorid,documentdetails)values(?,?)";
			template.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, contractorid);
					ps.setString(2, documentdetails);
					System.out.println(ps);
					return ps.execute();

				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
