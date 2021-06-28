package com.hrms.Dao;

import java.util.List;


import com.hrms.dtos.OthersDetailsDTO;

public interface OthersDetailsDao {

	public void saveOthersDetails(OthersDetailsDTO othersDetailsDTO);

	public void editOthersDetails(OthersDetailsDTO othersDetailsDTO);

	public void deleteOthersDetails(Integer tranid);
	
	public List<OthersDetailsDTO> getAllDetails();
	
	public List<OthersDetailsDTO> getOtherDetailsInfoByTranid(int parentid);
}
