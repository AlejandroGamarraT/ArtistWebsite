window.addEventListener("load", init);

function init(){
	
	loadAllSongs();
	
}

//	Sends a XHR with a GET-type method to load all the songs
function loadAllSongs(){
	
	let url = "api/songs/all";	//	Backend URL, returns a list of all the songs in database
	
	let xhr = new XMLHttpRequest();
	xhr.addEventListener("readystatechange", check1);
	xhr.open("GET", url, true);
	xhr.send(null);
	
}

//	Checks if the GET request is ready and the resource was found
function check1(){
	if(this.readyState==4 && this.status == 200){
		showData(this);			//	Calls function that will show the data contained in the XHR
	}
		
}

//	Creates table rows with the data received in the GET request
function showData(xhr){
	
	
	var songs = JSON.parse(xhr.responseText);
	
	
	for(let song of songs){
		
		let tr = document.createElement("tr");
				
		let tdName = document.createElement("td");
		tdName.innerHTML = song.name;
				
		//	Creates a button that calls a function when clicked, passing the song id to delete it'
		let tdListenBtn = document.createElement("td");
		tdListenBtn.innerHTML = "<a href='" + song.spotify_url + "' target='_blank'> <img id='spotify-logo' src='../assets/img/spotifylogo.png' /></a>";
		
		tr.appendChild(tdName);
		tr.appendChild(tdListenBtn);
		myTable.appendChild(tr);
	}
}

//	Sends a XHR with a DELETE-type method to delete a song given its id
function deleteSong(songId){
	
	let url = "api/deletesong?id=" + songId;
	let xhrDel = new XMLHttpRequest();
	xhrDel.addEventListener("readystatechange", function() {
		if(this.readyState==4 && this.status == 200){
		deleteRow(songId);		//	Calls function that will show the data contained in the XHR
	}
	});
	xhrDel.open("DELETE", url, true);
	xhrDel.send(null);
	
}

//	Deletes the row that has the song id received as parameter
function deleteRow(songId){
	
	let trArr = document.getElementsByTagName("tr");	//	All TRs
	
	for(i=0; i<trArr.length; i++){								//	Iterates through all rows
		
		let row = trArr[i];										
		
		let id = row.childNodes[0].innerHTML;					//	Saves the song id of the current row
		
		if(id == songId){										//	If the id matches the id of the song that has been deleted...
			
			myTable.removeChild(row);							//	Deletes the row from the table
			msg.innerHTML = "ID " + songId + " eliminado.";
			
		}
		
	}
	
	if(document.getElementsByTagName("tr").length==1){
		myTable.removeChild(myTable.childNodes[1]);
		
		let tr = document.createElement("tr");
		let tdNoData = document.createElement("td");
		tdNoData.innerHTML = "NINGÚN CANCIÓN EN LA BASE DE DATOS";
		tr.appendChild(tdNoData);
		myTable.appendChild(tr);
		
	}
	
}