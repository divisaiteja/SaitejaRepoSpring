package com.hrms.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrms.utitlities.DBUtil;

@Controller
public class displaycontroller {

	@RequestMapping(value="/display",method=RequestMethod.GET)
	public void getImage(HttpServletRequest request, HttpServletResponse response) {
		 try {
	       	 Connection con=DBUtil.getConnection();

	            PreparedStatement ps = con.prepareStatement("select * from hr_employeephotos where empid=?");
	            int empid = Integer.parseInt(request.getParameter("empid"));
	           // System.out.println(empid);
	            ps.setInt(1,empid );
	            ResultSet rs = ps.executeQuery();
	            rs.next();
	            Blob b = rs.getBlob("photo");
	            response.setContentType("image/jpeg");           
	            InputStream is = b.getBinaryStream();
	            OutputStream os = response.getOutputStream();
	            byte buf[] = new byte[(int) b.length()];
	            is.read(buf);
	            os.write(buf);
	            os.close();
	            is.close();
	        	con.close();
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	}
	
}
