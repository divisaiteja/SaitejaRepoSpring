<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%
Connection con=DBUtil.getConnection();
try {
	
    // connects to the database
    
    // queries the database
    String sql = "SELECT filename,filepath FROM hr_documentsupload WHERE tranid = ?";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setInt(1, 21);

    ResultSet result = statement.executeQuery();
    if (result.next()) {
        // gets file name and file blob data
        String fileName = result.getString(1);
        Blob blob = result.getBlob("filepath");
        InputStream inputStream = blob.getBinaryStream();
        int fileLength = inputStream.available();
         
        System.out.println("fileLength = " + fileLength);

        ServletContext context = getServletContext();

        // sets MIME type for the file download
        String mimeType = context.getMimeType(fileName);
        if (mimeType == null) {        
            mimeType = "application/octet-stream";
        }              
         
        // set content properties and header attributes for the response
        response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);

        // writes the file to the client
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[2044];
        int bytesRead = -1;
         
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
      //  outStream.flush();
        inputStream.close();
        outStream.close();   
       // out.clear(); 
    } else {
        // no file found
        response.getWriter().print("File not found for the id: "  );  
    }
} catch (SQLException ex) {
    ex.printStackTrace();
   // response.getWriter().print("SQL Error: " + ex.getMessage());
} catch (IOException ex) {
    ex.printStackTrace();
   // response.getWriter().print("IO Error: " + ex.getMessage());
} finally {
    if (con != null) {
        // closes the database connection
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }          
}
%>