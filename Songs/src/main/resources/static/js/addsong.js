window.addEventListener("load", init);

function init(){
	btnAdd.addEventListener("click", addSong);
}

//	Adds a song using XHR with a POST-type method
function addSong(){
	
	let url = "/";	//	Backend URL, receives a song and adds it
	let body = {
		"name":inpName.value,
		"artist":inpArtist.value,
		"album":inpAlbum.value,
		"duration":inpDuration.value,
		"year": parseInt(inpYear.value),
		"producer":inpProducer.value,
		"url":inpURL.value
	}

	let xhr = new XMLHttpRequest();
	xhr.addEventListener("readystatechange", check);
	xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json; charset=utf8");
	xhr.send(JSON.stringify(body));
	
}

//	Checks if the POST request is ready and the resource was found
function check(){
	if(this.readyState==4 && this.status == 200){
		myForm.reset();
		msg.innerHTML = "Canción agregada";
	}
		
}