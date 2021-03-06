  <!DOCTYPE html>
<html lang="en">
    
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>HR Management System - Login</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="resources/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="resources/dist/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="resources/dist/css/matrix-login.css" />
        <link href="resources/dist/css/icons/font-awesome/css/fontawesome.css" rel="stylesheet" />
        <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
    
   <script type ="text/javascript" src="resources/assets/libs/jquery-validation/dist/jquery.validate.js"></script>
<script type ="text/javascript" src="resources/assets/libs/jquery-validation/dist/jquery.validate.min.js"></script>
 <script type ="text/javascript" src="resources/assets/libs/jquery-validation/dist/additional-methods.js"></script>
 <script type ="text/javascript" src=" resources/assets/libs/jquery-validation/dist/additional-methods.min.js
"></script>

<script>
$(document).ready(function(){
	$("#verifyemail").hide();
	$("#verifyotp").hide();
	$("#NewPassword").hide();
	$("#ConfirmPassword").hide();
	$("#changepassword").hide();
	
	  $("#otpsend").click(function(){
		  var otpgeneration = {};
			var email=$("#email").val();
		  $.ajax({
				type : "post",
				contentType : "application/json",
				url : "SendingOTP?email="+email, // this is my servlet
				data : JSON.stringify(otpgeneration),
				success : function(data) {
					$("#servermessage").html(data["successMessage"]);
				}
			});
		 $("#email").hide();
		 $("#otpsend").hide();
		 $("#verifyemail").show();
		 $("#verifyotp").show();
	  });
	  $("#verifyotp").click(function(){
		  $("#verifyemail").hide();
		  $("#verifyotp").hide();
		  $("#NewPassword").show();
			$("#ConfirmPassword").show();
			$("#changepassword").show();
	  });
	});
</script>
 <script type="text/javascript" src="resources/customjs/login.js"></script> 
      

    </head>
    <body style="background:url(resources/assets/images/logo2.jpg);background-size:cover">
        <div id="loginbox">            
            <form id="loginform"  action="AdminLogin" method="post" name = "loginform">
				 <div class="control-group normal_text"> <h3><img src="resources/assets/images/booklogo.png" alt="Logo" height="100" width="180"/></h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box" >
                            <span class="add-on bg_lg"><i class="icon-user"> </i></span><input type="text" for="uid"  id = "uid" name="uid" placeholder="Username" pattern="[a-z]{5,15}" required="required" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" for="password" id = "password" name="password" placeholder="Password" pattern="(?=^.{4,}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s)[0-9a-zA-Z!@#$%^&*()]*$"  required="required"/>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a  class="flip-link btn btn-info" id="to-recover" data-toggle="modal" data-target="#myModal">Lost password?</a></span>
                    <span class="pull-right"><input type="submit" class="btn btn-success" value="Login"/> </span>
                </div>
                
            </form>
            
        </div>
        
        
        modal box for forget password
          <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <div class="container" align="center">
          <h4 class="modal-title">Changing password</h4>
          </div>
          <h3 align="center" id="servermessage"></h3>
        </div>
        <div class="modal-body">
         <table width="100%">
         <tr>
         	<td><input type="email" class="form-control" id="email" placeholder="Enter email" name="email"> </td>
         	<td><button type="submit" class="btn btn-danger" id="otpsend">Send OTP</button> </td>
         </tr>
         <tr>
         <td><input type="text" class="form-control" id="verifyemail" placeholder="Enter Your OTP" name="email"> </td>
         <td><button type="submit" class="btn btn-success" id="verifyotp">Verify OTP</button></td>
         </tr>
         <tr>
         <td><input type="text" class="form-control" id="NewPassword" placeholder="Enter NewPassword" name="email"> </td>
         <td><input type="text" class="form-control" id="ConfirmPassword" placeholder="Confirm Password" name="email"></td>
         </tr>
         </table>
         <center>
         <button type="submit" class="btn btn-primary" id="changepassword">Change Password</button>
       </center>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
        
        
        
        <script src="resources/dist/js/jquery.min.js"></script>  
        <script src="resources/dist/js/matrix.login.js"></script> 
        <script src="resources/dist/js/sidebarmenu.js"></script>

    </body>

</html>
  