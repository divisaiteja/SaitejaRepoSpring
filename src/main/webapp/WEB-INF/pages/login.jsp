<!DOCTYPE html>
<html lang="en">

    <head>
    <style>
    form .error {
  color: red;
}
    </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>HR Management System - Login</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="resources/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="resources/dist/css/bootstrap-responsive.min.css" />
        <!--<link rel="stylesheet" href="resources/dist/css/matrix-login.css" />-->
        <link href="resources/dist/css/icons/font-awesome/css/fontawesome-all.min.css" rel="stylesheet" />
        
        <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>

        <script type ="text/javascript" src="resources/assets/libs/jquery-validation/dist/jquery.validate.js"></script>
        <script type ="text/javascript" src="resources/assets/libs/jquery-validation/dist/jquery.validate.min.js"></script>
        <script type ="text/javascript" src="resources/assets/libs/jquery-validation/dist/additional-methods.js"></script>
        <script type ="text/javascript" src=" resources/assets/libs/jquery-validation/dist/additional-methods.min.js"></script>
  
<script type="text/javascript" src="resources/customjs/login.js"></script> 
        <script>
            $(document).ready(function () {
                $("#otp").hide();
                $("#image").hide();
                $("#verifyotp").hide();
                $("#NewPassword").hide();
                $("#ConfirmPassword").hide();
                $("#changepassword").hide();

//                $("#otpsend").click(function () {
////                    alert($("#uid").val());
//                    var idno = $("#uid").val();
//                    $("#idno").hide();
//                    $("#otpsend").hide();
//                    $("#image").show();
//                    $.ajax({
//                        type: "GET",
//                        contentType: "application/json",
//                        //url : "SendingOTP?email="+email, // this is my servlet
//                        url: "SendingOTP?idno=" + idno,
//                        success: function (data) {
//                            ////alert();
//                            $("#passedemailid").val(data["dataBean"]);
//                            $("#servermessage").html(data["successMessage"]);
//                            $("#image").hide();
//
//                            $("#otp").show();
//                            $("#verifyotp").show();
//                        }
//                    });
//
//                });

            });

            function reload() {
                window.location.reload();
            }

            function verifyotp() {
                var passedemailid = $("#passedemailid").val();
                var otp = $("#otp").val();
                $("#otp").hide();
                $("#verifyotp").hide();
                $("#image").show();

                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    //url : "SendingOTP?email="+email, // this is my servlet
                    url: "verifyOTP?passedemailid=" + passedemailid + "&&otp=" + otp,
                    success: function (data) {
                        $("#servermessage").html(data["successMessage"]);
                        $("#image").hide();
                        console.log(data);
                        alert(data.successMessage);
                        var sStr = data.successMessage;
                        if (sStr.includes("Successfully")){
                        $("#NewPassword").show();
                        $("#ConfirmPassword").show();
                        $("#changepassword").show();
                    }
                    }
                });

            }

        </script>
              
    </head>
    <body style="background:url(resources/assets/images/logo2.jpg);background-size: cover">
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div align="center" style="margin-left:50%;">            
            <form id="loginform"  action="AdminLogin" method="post" name = "loginform">
                <!--<div class="control-group normal_text"> <h3><img src="resources/assets/images/booklogo.png" alt="Logo" height="100" width="180"/></h3></div>-->
                <div class="control-group">
                    <div class="controls">        
                        <div class="main_input_box" >                                                             
                            <span class="add-on bg_lg"><i class="fa fa-user" style="font-size:18px;color:greenyellow">&nbsp;&nbsp;<input type="text" for="uid"  id = "uid" name="uid" placeholder="Username"  required="required" /></i></span>
                        </div>
                        <div class="main_input_box" >                                                             
                            <span class="add-on bg_ly"><i class="fa fa-lock" style="font-size:18px;color:greenyellow">&nbsp;&nbsp;<input type="password" for="password" id = "password" name="password" placeholder="Password"  required="required"/></i></span>
                        </div>


                    </div>
                    <div>
                        <div>
                            <span><a id="to-recover" data-toggle="modal" data-target="#myModal"  onclick="checkId()">Lost password?</a></span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <span align="right"><input type="submit" class="btn btn-success" value="Login"/> </span>
                        </div>
                    </div>
                </div>

            </form>

        </div>

        <!-- modal box for forget password -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">                  
                        Changing password
                        <h5 align="center" id="servermessage" style="color:red"></h5>
                    </div>
                    <div class="modal-body">
                        <div align="center"><img src="resources/img/reload.gif" id="image" height="50" width="150"></div>
                        <table width="100%">
                            <tr>
                                <td><input type="text" class="form-control" id="idno" placeholder="Enter EmployeeId" > </td>
                                <td><button type="submit" class="btn btn-danger" id="otpsend">Send OTP</button> </td>
                            </tr>
                            <tr>
                                <td><input type="hidden" id="passedemailid"><input type="text" class="form-control" id="otp" placeholder="Enter Your OTP" > </td>
                                <td><button type="submit" class="btn btn-success" id="verifyotp" onclick="verifyotp()">Verify OTP</button></td>
                            </tr>
                            <tr>
                                <td>
<!--                                    <input type="password" for="NewPassword" id="NewPassword" placeholder="NewPassword" name="email"
                                         pattern="(?=^.{4,}$)(?=.\d)(?=.[a-z])(?=.[A-Z])(?!.\s)[0-9a-zA-Z!@#$%^&()]$"  />-->
                                    
                                    <input type="password" class="form-control" id="NewPassword" placeholder="Enter NewPassword" name="email" > 
                                </td>
                                <td>
<!--                                    <input type="password" for="ConfirmPassword" id="ConfirmPassword" placeholder="Confirm Password" name="email"
                                         pattern="(?=^.{4,}$)(?=.\d)(?=.[a-z])(?=.[A-Z])(?!.\s)[0-9a-zA-Z!@#$%^&()]$" />-->
                                    <input type="password" class="form-control" id="ConfirmPassword" placeholder="Confirm Password" name="email"></td>
                            </tr>
                        </table>
                        <center>
                            <button type="submit" class="btn btn-primary" id="changepassword" onclick="return Validate()">Change Password</button>
                        </center>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="reload()">Close</button>
                    </div>
                </div>
            </div>
        </div>



        <!--       <script src="resources/dist/js/jquery.min.js"></script>  
              <script src="resources/dist/js/matrix.login.js"></script> 
              <script src="resources/dist/js/sidebarmenu.js"></script> -->

    </body>
    <script type="text/javascript">
    function Validate() {
        var password = document.getElementById("NewPassword").value;
        var confirmPassword = document.getElementById("ConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords not matched....");
            return false;
        }
        return true;
    }
</script>
<script type="text/javascript">
  function checkId() {
            var idno = $("#uid").val();
            if(idno!=""){        
                    $("#idno").hide();
                    $("#otpsend").hide();
                    $("#image").show();
                    $.ajax({
                        type: "GET",
                        contentType: "application/json",
                        //url : "SendingOTP?email="+email, // this is my servlet
                        url: "SendingOTP?idno=" + idno,
                        success: function (data) {
                            ////alert();
                            $("#passedemailid").val(data["dataBean"]);
                            $("#servermessage").html(data["successMessage"]);
                            $("#image").hide();
                            var sStr = data.successMessage;
                        if (!sStr.includes("Invalid")){
                            $("#otp").show();
                            $("#verifyotp").show();
                        }
                        }
                    });
                }
                else{
                    alert("User name is must....");                    
                                        reload();

                }                    
  }
</script>
<script>
    $('#changepassword').click(function() {  
//            alert("hi");
        var idno = document.getElementById("idno").value;
//        alert(idno);
        var confirmPassword = document.getElementById("ConfirmPassword").value;


	$.ajax({
		type : "post",
		// contentType: false,
		url : "changePassword?idno=" + idno+"&&password="+confirmPassword, // this controller url
		//url : "storeDocDetails1",
		
		success : function(data) {
                    console.log(data);
			 window.location.reload();
			
		}

	});
});
 </script>
 <!-- Right Click Opertaion Functionality -->
 


</html>
