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
	public List<ProjectDTO> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.getAllProjects();
	}

	@Override
	public String editProject(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		return projectDao.editProject(projectDTO);
	}

	@Override
	public String projectSave(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		return projectDao.projectSave(projectDTO) ;
	}

	@Override
	public void deleteProject(int tranid) {
		// TODO Auto-generated method stub
		 projectDao.deleteProject(tranid);
	}

	@Override
	public List<ProjectDTO> getProjectByTranid(int tranid) {
		// TODO Auto-generated method stub
		return projectDao.getProjectByTranid(tranid);
	}

}
