$(document).ready({
	
})

 const validate = () =>{
	var name = $('#username').val();
	 if(name.trim()==""){
		$('.error-msg').text("Please Fill name field");
	}	
}