package com.hrms.service;

import java.util.List;

import com.hrms.dtos.PermissionsDTO;

public interface PermissionService {

	public String passELSave(PermissionsDTO permissionsDTO);

	public String passSLSave(PermissionsDTO permissionsDTO);

	public String passCLSave(PermissionsDTO permissionsDTO);

	public String passLeaveSave(PermissionsDTO permissionsDTO);

	public String forgetPunchSave(PermissionsDTO permissionsDTO);

	public String lopIntimationSave(PermissionsDTO permissionsDTO);

	public String permissionSave(PermissionsDTO permissionsDTO);

	public List<PermissionsDTO> getPermissionsList(int idno);

	public void deletePermission(int tranid);
}
