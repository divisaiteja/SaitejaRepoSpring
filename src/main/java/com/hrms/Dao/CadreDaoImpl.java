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

import com.hrms.dtos.CadreDTO;
import com.hrms.utitlities.HrmsMessageConstants;
import com.hrms.utitlities.constants;

@Repository
public class CadreDaoImpl implements CadreDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<CadreDTO> getAllCadres() {
		return jt.query("select * from hr_cadre", new ResultSetExtractor<List<CadreDTO>>() {
			@Override
			public List<CadreDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<CadreDTO> list = new ArrayList<CadreDTO>();
				while (rs.next()) {
					CadreDTO e = new CadreDTO();
					e.setTranid(rs.getInt("tranid"));
					e.setCadrecode(rs.getString("cadrecode"));
					e.setCadredescription(rs.getString("cadredescription"));
					switch (rs.getInt("isactive")) {
					case 1: {
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						e.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						e.setStatusCodeForActive(constants.NotFound);
						break;
					}
					e.setIsactive(rs.getInt("isactive"));
					list.add(e);
				}
				return list;
			}
		});
	}

	@Override
	public List<CadreDTO> getCadreByTranid(int tranid) {
		return jt.query("select * from hr_cadre where tranid = " + tranid, new ResultSetExtractor<List<CadreDTO>>() {
			@Override
			public List<CadreDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<CadreDTO> list = new ArrayList<CadreDTO>();
				if (rs.next()) {
					CadreDTO e = new CadreDTO();
					e.setTranid(rs.getInt("tranid"));
					e.setCadrecode(rs.getString("cadrecode"));
					e.setCadredescription(rs.getString("cadredescription"));
					switch (rs.getInt("isactive")) {
					case 1: {
						e.setStatusCodeForActive(constants.Active);
						break;
					}
					case 0: {
						e.setStatusCodeForActive(constants.InActive);
						break;
					}

					default:
						e.setStatusCodeForActive(constants.NotFound);
						break;
					}
					e.setIsactive(rs.getInt("isactive"));
					list.add(e);
				}
				return list;
			}
		});

	}

	@Override
	public String editCadre(final CadreDTO cadreDto) {
		String resultMessage = "";
		String query = "update hr_cadre set cadrecode = ?,cadredescription = ?,isactive =? where tranid = ?";
		Integer result = jt.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, cadreDto.getCadrecode());
				ps.setString(2, cadreDto.getCadredescription());
				ps.setString(3, cadreDto.getStatusCodeForActive());
				ps.setInt(4, cadreDto.getTranid());

				return ps.executeUpdate();
			}

		});
		if (result > 0) {
			resultMessage = result > 0 ? HrmsMessageConstants.cadre_Update_success
					: HrmsMessageConstants.cadre_update_Fail;
			return resultMessage;
		}
		return resultMessage;
	}

	@Override
	public void deleteCadre(int tranid) {
		String deleteQuery = "update hr_cadre set isactive = ? where tranid = " + tranid;

		jt.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				CadreDTO cadreDto = new CadreDTO();
				ps.setString(1, cadreDto.getStatusCodeForActive());

				return ps.execute();
			}
		});

	}

	@Override
	public String saveNewCadre(CadreDTO cadreDto) {
		String resultMessage = "";
		String insertQuery = "insert into hr_cadre(cadrecode,cadredescription,isactive) values('"
				+ cadreDto.getCadrecode() + "','" + cadreDto.getCadredescription() + "',1)";
		int result = jt.update(insertQuery);
		resultMessage = result > 0 ? HrmsMessageConstants.cadre_Save : HrmsMessageConstants.cadre_Fail;
		return resultMessage;
	}

}
