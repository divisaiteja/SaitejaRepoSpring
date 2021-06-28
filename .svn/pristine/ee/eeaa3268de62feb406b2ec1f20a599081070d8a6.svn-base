package com.hrms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.dtos.BaseResponseDTO;
import com.hrms.dtos.ProjectDTO;
import com.hrms.service.ProjectService;
import com.hrms.utitlities.constants;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "projects", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView project() {

		return new ModelAndView("Projects");
	}

	@RequestMapping(value = "getProjectInformation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO getAllProjectList() {
		List<ProjectDTO> projectList = projectService.getAllProjectsList("");
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(projectList);
		return response;

	}

	@RequestMapping(value = "getallproject", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ProjectDTO> getAllProjects(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String loginId = "";
		String fltStr = "";
		loginId = session.getAttribute("username").toString();
		if (!loginId.equalsIgnoreCase("admin")) {
			String actId = session.getAttribute("activityId").toString();
			int activityId = Integer.valueOf(actId);
			fltStr = constants.getAccessRights(loginId, "projects", activityId);
		}
		List<ProjectDTO> projectList = projectService.getAllProjectsList(fltStr);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(projectList);
		return projectList;

	}

	@RequestMapping(value = "getProjectInfoByTranid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ProjectDTO> getJobTypeByTranid(@RequestParam(value = "tranid") int tranid, ModelMap map) {
		List<ProjectDTO> projectByTranid = projectService.getProjectByTranid(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setDataBean(projectByTranid);
		response.setSuccessMessage("storedsucessfully");
		return projectByTranid;

	}

	@RequestMapping(value = "projectSave", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO saveProject(@RequestBody ProjectDTO projectDTO) {
		String displayMessage = projectService.projectSave(projectDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage);
		return response;
	}

	@RequestMapping(value = "editProject", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO editProject(@RequestBody ProjectDTO projectDTO) {
		String displayMessage1 = projectService.editProject(projectDTO);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage(displayMessage1);
		return response;

	}

	@RequestMapping(value = "deleteProject", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDTO deleteProject(@RequestParam("tranid") int tranid) {
		projectService.deleteProject(tranid);
		BaseResponseDTO response = new BaseResponseDTO();
		response.setSuccessMessage("deleted sucessfully");
		return response;

	}

}
