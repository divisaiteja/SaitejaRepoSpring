package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.HolidayDao;
import com.hrms.dtos.HolidayDTO;
@Service
public class HolidayServiceImpl implements HolidayService {
	@Autowired
	private HolidayDao holidayDao;
	
	@Override
	public List<HolidayDTO> getAllHolidays() {
		
		return holidayDao.getAllHolidays();
	}

	@Override
	public List<HolidayDTO> getHolidayByTranid(Integer tranid) {
		
		return holidayDao.getHolidayByTranid(tranid);
	}

	@Override
	public String saveHolidays(HolidayDTO holidayDTO) {
		
		return holidayDao.saveHolidays(holidayDTO);
	}

	@Override
	public String editHolidays(HolidayDTO holidayDTO) {
		
		return holidayDao.editHolidays(holidayDTO);
	}

	@Override
	public void deleteHoliday(Integer tranid) {
		holidayDao.deleteHoliday(tranid);
		
	}

}
