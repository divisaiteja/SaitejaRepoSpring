package com.hrms.Dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dtos.EventsDTO;
import com.hrms.utitlities.HrmsMessageConstants;

@Repository
public class EventsDaoImpl implements EventsDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<EventsDTO> getAllParticipants() {
		String sql = "select * from hr_eventparticipants ";
		return template.query(sql, new ResultSetExtractor<List<EventsDTO>>() {

			@Override
			public List<EventsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EventsDTO> list = new ArrayList<EventsDTO>();
				int vslno = 1;
				while (rs.next()) {
					EventsDTO eventsDTO = new EventsDTO();
					eventsDTO.setTranid(rs.getInt("tranid"));
					eventsDTO.setEventid(rs.getInt("eventid"));
					eventsDTO.setParticipantname(rs.getString("participantname"));
					list.add(eventsDTO);
				}
				return list;
			}
		});
	}

	@Override
	public void deleteParticipant(final int tranid) {
		String deleteQuery = "delete from hr_eventparticipants where tranid=?";

		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});
	}

	@Override
	public String saveNewParticipant(final EventsDTO eventsDTO) {
		String resultMessage = "";
		String sql = "insert into hr_eventparticipants(eventid,participantname)values(?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, eventsDTO.getEventid());
				ps.setString(2, eventsDTO.getParticipantname());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Events_Participants_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Events_Participants_Details_NotSave;
		}

		return resultMessage;
	}

	@Override
	public List<EventsDTO> getAllExpenses() {
		String sql = "select * from hr_eventexpenses ";
		return template.query(sql, new ResultSetExtractor<List<EventsDTO>>() {

			@Override
			public List<EventsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EventsDTO> list = new ArrayList<EventsDTO>();
				int vslno = 1;
				float total=0.0f;
				while (rs.next()) {
					EventsDTO eventsDTO = new EventsDTO();
					eventsDTO.setTranid(rs.getInt("tranid"));
					eventsDTO.setEventid(rs.getInt("eventid"));
					eventsDTO.setAmount(rs.getFloat("amount"));
					eventsDTO.setAccounthead(rs.getString("accounthead"));
					total=total+rs.getFloat("amount");
					
					eventsDTO.setTotal(total);
					list.add(eventsDTO);
				}
				return list;
			}
		});
	}

	@Override
	public void deleteExpense(final int tranid) {
		String deleteQuery = "delete from hr_eventexpenses where tranid=?";

		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});
	}

	@Override
	public String saveNewExpense(final EventsDTO eventsDTO) {
		String resultMessage = "";
		String sql = "insert into hr_eventexpenses(eventid,amount,accounthead)values(?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, eventsDTO.getEventid());
				ps.setFloat(2, eventsDTO.getAmount());
				ps.setString(3, eventsDTO.getAccounthead());
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Events_Expense_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Events_Expense_Details_NotSave;
		}

		return resultMessage;
	}

	@Override
	public String saveNewImage(MultipartFile photo) {
		String resultMessage = "";
		final byte[] photoBytes;
		try {
			photoBytes = photo.getBytes();

			String sql = "insert into hr_eventuploads(image) values(?)";
		
			int result = template.execute(sql, new PreparedStatementCallback<Integer>() {

				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setBytes(1, photoBytes);
					return ps.executeUpdate();
				}
			});

			if (result > 0) {

				resultMessage = HrmsMessageConstants.Events_Expense_Details_Save;
			} else {
				resultMessage = HrmsMessageConstants.Events_Expense_Details_NotSave;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public String saveNewEvent( final EventsDTO eventsDTO) {
		String resultMessage = "";
		String sql = "insert into hr_events(infodate,title,description,conductedby,totalexpense,eventtype,isactive)values(?,?,?,?,?,?,?)";
		int result = template.execute(sql, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, eventsDTO.getInfodate());
				ps.setString(2, eventsDTO.getTitle());
				ps.setString(3, eventsDTO.getDescription());
				ps.setInt(4, eventsDTO.getConductedby());
				ps.setFloat(5, eventsDTO.getTotalexpense());
				ps.setString(6, "CSR");
				ps.setInt(7, 1);
				return ps.executeUpdate();

			}

		});

		if (result > 0) {

			resultMessage = HrmsMessageConstants.Events_Expense_Details_Save;
		} else {
			resultMessage = HrmsMessageConstants.Events_Expense_Details_NotSave;
		}

		return resultMessage;
	}

	@Override
	public List<EventsDTO> getAllEvents() {
		String sql = "select * from hr_events ";
		return template.query(sql, new ResultSetExtractor<List<EventsDTO>>() {

			@Override
			public List<EventsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<EventsDTO> list = new ArrayList<EventsDTO>();
				while (rs.next()) {
					EventsDTO eventsDTO = new EventsDTO();
					eventsDTO.setTranid(rs.getInt("tranid"));
					eventsDTO.setTotalexpense(rs.getFloat("totalexpense"));
					eventsDTO.setConductedby(rs.getInt("conductedby"));
					eventsDTO.setInfodate(rs.getString("infodate"));
					
					list.add(eventsDTO);
				}
				return list;
			}
		});
	}

	@Override
	public void deleteEvent( final int tranid) {
		String deleteQuery = " delete from hr_events where tranid = ? ";
 
		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});
		
	}


	public List<EventsDTO> getAllImages() { 
		
        String sql = "select * from hr_eventuploads ";
        return template.query(sql, new ResultSetExtractor<List<EventsDTO>>() {
        	@Override 
       public List<EventsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
        		List<EventsDTO> eventlist = new ArrayList<EventsDTO>();
          		try {
        		while (rs.next()) {
        			EventsDTO eventsDTO = new EventsDTO();
        			eventsDTO.setTranid(rs.getInt("tranid"));
        			Blob blob = rs.getBlob("image");
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
						  eventsDTO.setBase64Image(base64Image);
		                  eventlist.add(eventsDTO);
        		}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
   
        return eventlist;
    }
        });
	}

	@Override
	public void deleteImage( final int tranid) {
		String deleteQuery = " delete from hr_eventuploads where tranid = ? ";
		 
		template.execute(deleteQuery, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, tranid);
				return ps.execute();
			}
		});
		
	}

	@Override
	public String editEvent(final EventsDTO eventsDTO) {
		
		String resultMessage = "";
		String query = "update hr_events set infodate=?,conductedby=?,totalexpense=? where tranid=?";
		Integer result = template.execute(query, new PreparedStatementCallback<Integer>() {
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setString(1, eventsDTO.getInfodate());
				ps.setInt(2, eventsDTO.getConductedby());
				ps.setFloat(3, eventsDTO.getTotalexpense());
				ps.setInt(4, eventsDTO.getTranid());
				
				return ps.executeUpdate();
			}
		
		});
		if (result > 0) {
			resultMessage = HrmsMessageConstants.Employee_Details_Update_Success;
		} else {
			resultMessage = HrmsMessageConstants.Employee_Details_Update_Fail;
		}

		return resultMessage;
	}

	@Override
	public List<EventsDTO> getEventsByTranid(int tranid) {
		
		return template.query(
				"select * from hr_events  where tranid="
						+ tranid,
				new ResultSetExtractor<List<EventsDTO>>() {
					@Override
					public List<EventsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<EventsDTO> listdto = new ArrayList<EventsDTO>();
						if (rs.next()) {
							EventsDTO dto = new EventsDTO();
							dto.setTranid(rs.getInt("tranid"));
							dto.setTotalexpense(rs.getFloat("totalexpense"));
							dto.setConductedby(rs.getInt("conductedby"));
							dto.setInfodate(rs.getString("infodate"));
							listdto.add(dto);
						}
						return listdto;
					}

				});
	}

}


        
