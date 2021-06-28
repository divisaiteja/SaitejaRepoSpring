package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.ProjectDao;
import com.hrms.dtos.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Override
	public List<ProjectDTO> getAllProjectsList(String strFltr) {
		return projectDao.getAllProjectsList(strFltr);
	}

	@Override
	public String editProject(ProjectDTO projectDTO) {
		return projectDao.editProject(projectDTO);
	}

	@Override
	public String projectSave(ProjectDTO projectDTO) {
		return projectDao.projectSave(projectDTO);
	}

	@Override
	public void deleteProject(int tranid) {
		projectDao.deleteProject(tranid);
	}

	@Override
	public List<ProjectDTO> getProjectByTranid(int tranid) {
		return projectDao.getProjectByTranid(tranid);
	}

}
