package com.hrms.Dao;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class EmployeeBLogicsImpl implements EmployeeBLogics {

	@Override
	public void getEmployeeDoc(int idno) {
		File file = new File("E:\\LATESTWORKSPACEBYSRAVAN\\DASHBOARD\\src\\main\\webapp\\resources\\theme\\CustomDirectory\\"+idno);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directory is created!");
                
            } else {
                System.out.println("Failed to create directory!");
            }
        }
	}

}
