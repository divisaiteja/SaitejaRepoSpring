package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.SectionDao;
import com.hrms.dtos.SectionDTO;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionDao sectionDao;

	@Override
	public List<SectionDTO> getAllSection() {

		return sectionDao.getAllSection();
	}

	@Override
	public String saveSection(SectionDTO sectionDTO) {
		String saveSection = sectionDao.saveSection(sectionDTO);
		return saveSection;
	}

	@Override
	public String editSection(SectionDTO sectionDTO) {
		String editSection = sectionDao.editSection(sectionDTO);
		return editSection;
	}

	@Override
	public String deleteSection(Integer sectionid) {
		String deleteSection = sectionDao.deleteSection(sectionid);
		return deleteSection;
	}

	@Override
	public List<SectionDTO> getSectionByTranid(Integer sectionid) {

		return sectionDao.getSectionByTranid(sectionid);
	}

}
