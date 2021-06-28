$(document).ready(function () {
jQuery(function($) { 
	
  $("#loginform").validate({
    rules: {
      uid: "required",
      password: {
         required: true,
         minlength: 6,
         lowercase:[a-z],
         uppercase:[A-Z]
     
      }
    },
    messages: {
      uid: {
        required: "Please Enter user name"
      },
      password: {
            required:" Please Enter password",
            minlength: "Your password must be at least 6 characters long",
            lowercase: "password must be atleat one lowercase letter",
            uppercase: "password must be atleat one uppercase letter"
            
      }
    },
    submitHandler: function (form) { // for demo
    	
      form.submit();
    }
  });
});

});