promptForUserName()

function promptForUserName(){
	var userName = prompt("Please enter your name")
	sessionStorage.setItem("userName", userName)
	var user = {
		"userName": userName
	}
	console.log(user.userName)
	checkIfUserExists(user)
}


async function checkIfUserExists(user){
	let response = await fetch(`http://localhost:8080/register/checkUser`, {
				method: "post",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(user.userName)
			})
			.then ( (response) => response.json() )
			.then(data => {
				if (data === true){
					alert("UserName already exists. Please try again.")
					promptForUserName()
				} else{
					saveUser(user)
					window.location.href = "http://localhost:8080/welcome"
				}
				
				})
}
				
function saveUser(user){
	fetch(`http://localhost:8080/register`, {
			method: "post",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(user.userName)
		})
				
}