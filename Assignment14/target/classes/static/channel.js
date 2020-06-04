

var inputBox = document.querySelector("#inputBox")
var userName = sessionStorage.getItem('userName')

var channelId = document.getElementById('channelId').innerHTML
		console.log(channelId)
		

inputBox.addEventListener('keypress', (e) => {

	if (e.key === 'Enter'){
				
		var responseBody = {
			'message' : inputBox.value,
			'userName' : userName,
			'channelId' : channelId
		}
		
		fetch('http://localhost:8080/channel/{channelId}', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(responseBody)
		})
		
	}
})

setInterval(fetch1, 500)

async function fetch1(){
let response = await fetch('http://localhost:8080/channel/1/get')
.then( response => response.json())
.then( (object) => {console.log(object)
		var lengthOfMessages = object.length
		var max5Messages = lengthOfMessages - 6
		var positiveResult = max5Messages - lengthOfMessages
		var m = 5
				
		for (i = lengthOfMessages -1; i > max5Messages ; i--){
			var objectMessage = object[i]
			if (objectMessage != undefined){
				var userName = objectMessage.userName
				var message = objectMessage.message
				document.getElementById("userName" + m).innerHTML = userName
				document.getElementById("message" + m).innerHTML = message
				m--
				}
			
			}
								
		}
	)
}


