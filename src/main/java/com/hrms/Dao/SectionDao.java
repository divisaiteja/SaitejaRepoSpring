package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.SectionDTO;

public interface SectionDao {

	public List<SectionDTO> getAllSection();

	public List<SectionDTO> getSectionByTranid(Integer sectionid);

	public String saveSection(SectionDTO sectionDTO);

	public String editSection(SectionDTO sectionDTO);

	public String deleteSection(Integer sectionid);

}
