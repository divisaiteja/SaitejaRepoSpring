package com.hrms.commons;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailSendingServlet
 */
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 private String host;
	    private String port;
	    private String user;
	    private String pass;
	    
	    public void init() {
	        // reads SMTP server setting from web.xml file
	        ServletContext context = getServletContext();
	        host = context.getInitParameter("host");
	        port = context.getInitParameter("port");
	        user = context.getInitParameter("user");
	        pass = context.getInitParameter("pass");
	    }
    public EmailSendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hii");
		 // reads form fields
        String recipient = "sravankumar.bandi7@gmail.com";
        String subject = "testing";
        String content = "hi";
 
        String resultMessage = "";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
          //  getServletContext().getRequestDispatcher("/Result.jsp").forward(
                //    request, response);
        }
	}

}
