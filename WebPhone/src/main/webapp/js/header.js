
var user = document.getElementById("user").getAttribute("value");
if(user==""){
	document.getElementById("user").style.display = "none";
	
}else{
	document.getElementById("login").style.display = "none";
	document.getElementById("user").style.display = "block";
}
