var button = document.querySelector("#button")
var userName = sessionStorage.getItem("userName")

if (userName == null){
	window.location.replace("localhost:8080/register")
}

// button.addEventListener(click, => {
	
//})