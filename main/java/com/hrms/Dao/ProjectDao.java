package com.hrms.Dao;

import java.util.List;

import com.hrms.dtos.ProjectDTO;

public interface ProjectDao {
	public List<ProjectDTO> getAllProjects();
	public String editProject(ProjectDTO projectDTO);
	public String projectSave(ProjectDTO projectDTO);
	public void deleteProject(int tranid);
	public List<ProjectDTO> getProjectByTranid(int tranid);
	


}
