package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.BloodGroupDTO;


public interface BloodGroupDao {
	public List<BloodGroupDTO> getAllBgroups();
	public void editBgroup(BloodGroupDTO bgroupDTO);
	public void deleteBgroup(Integer tranid);
	public void saveNewBgroup(BloodGroupDTO bgroupDTO);

}
