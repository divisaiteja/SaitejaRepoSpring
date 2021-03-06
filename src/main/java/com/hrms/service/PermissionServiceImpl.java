package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Dao.PermissionDao;
import com.hrms.dtos.PermissionsDTO;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	public PermissionDao permissionDao;

	@Override
	public String passELSave(PermissionsDTO permissionsDTO) {
		return permissionDao.passELSave(permissionsDTO);
	}

	@Override
	public String passSLSave(PermissionsDTO permissionsDTO) {
		return permissionDao.passSLSave(permissionsDTO);
	}

	@Override
	public String passCLSave(PermissionsDTO permissionsDTO) {
		return permissionDao.passCLSave(permissionsDTO);
	}

	@Override
	public String passLeaveSave(PermissionsDTO permissionsDTO) {
		return permissionDao.passLeaveSave(permissionsDTO);
	}

	@Override
	public String forgetPunchSave(PermissionsDTO permissionsDTO) {
		return permissionDao.forgetPunchSave(permissionsDTO);
	}

	@Override
	public String lopIntimationSave(PermissionsDTO permissionsDTO) {
		return permissionDao.lopIntimationSave(permissionsDTO);
	}

	@Override
	public String permissionSave(PermissionsDTO permissionsDTO) {
		return permissionDao.permissionSave(permissionsDTO);
	}

	@Override
	public List<PermissionsDTO> getPermissionsList(int idno) {
		return permissionDao.getPermissionsList(idno);
	}

	@Override
	public void deletePermission(int tranid) {

		permissionDao.deletePermission(tranid);

	}

}
