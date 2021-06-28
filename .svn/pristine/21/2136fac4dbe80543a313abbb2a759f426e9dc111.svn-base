package com.hrms.commons;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.jboss.logging.Logger;

import com.hrms.utitlities.DBUtil;



public class fileUploadToFolder {
	
	private static final Logger logger =Logger.getLogger(fileUploadToFolder.class);
	
	public String insertIntoFolder(int idno,String fileName,byte[] b){
		
		String result=null;
		try{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String filepath=DBUtil.directoryPath();
		
		
		File filecreate = new File(filepath+"\\"+idno); 
		
		 if (!filecreate.exists()) {
             System.out.println("iam in if block");
         filecreate.mkdir();
                 
             System.out.println("Directory is created!");
		 }
          else {
             System.out.println("Failed to create directory!");
         }
         File serverFile = new File(filecreate.getAbsoluteFile()
					+ File.separator + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(b);
			System.out.println(b);
			stream.close();
			System.out.println("Server File Location="
					+ serverFile.getAbsolutePath());
			logger.info("Server File Location="
					+ serverFile.getAbsolutePath());
     
		System.out.println("method came");
		result=serverFile.getAbsolutePath();
		
	}catch(Exception e){
		e.printStackTrace();
	}
		return result;
	}
public String insertPhotoIntoFolder(int idno,String fileName,byte[] b){
		
		String result=null;
		try{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String filepath=DBUtil.directoryPath1();
		
		
		File filecreate = new File(filepath+"\\"+idno); 
		
		 if (!filecreate.exists()) {
             System.out.println("iam in if block");
         filecreate.mkdir();
                 
             System.out.println("Directory is created!");
		 }
          else {
             System.out.println("Failed to create directory!");
         }
         File serverFile = new File(filecreate.getAbsoluteFile()
					+ File.separator +idno+".jpg");
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(b);
			stream.close();
			System.out.println("Server Photo Location="
					+ serverFile.getAbsolutePath());
			logger.info("Server File Location="
					+ serverFile.getAbsolutePath());
     
		System.out.println("method came");
		result=serverFile.getAbsolutePath();
		
	}catch(Exception e){
		e.printStackTrace();
	}
		return result;
	}

}
