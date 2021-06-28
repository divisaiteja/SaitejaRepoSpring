 jQuery(function($) { 
	
  $("#loginform").validate({
    rules: {
      uid: "required",
      password: {
         required: true,
       
      }
    },
    messages: {
      uid: {
        required: "Pleace Enter user name"
      },
      password: {
            required:" Please Enter password",
        
      }
    },
    submitHandler: function (form) { // for demo
    	
      form.submit();
    }
  });
});