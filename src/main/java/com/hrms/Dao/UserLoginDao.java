package com.hrms.Dao;

import com.hrms.dtos.NotificationEmailDTO;
import com.hrms.dtos.UserLoginDTO;

public interface UserLoginDao {

	public void SaveuserDetails(UserLoginDTO userLoginDTO);

	public String getEmployeeEmailId(int idno);

	public Integer StoreOtpWithEmail(String email, int idno, String OTP);

	public Integer verifyOtp(String email, int otp);

	public String emailNotification(NotificationEmailDTO notificationEmailDTO);

}
