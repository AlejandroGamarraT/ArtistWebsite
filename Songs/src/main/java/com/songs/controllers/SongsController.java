package com.songs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.songs.model.Song;
import com.songs.service.SongsService;

@RestController
public class SongsController {
	
	private SongsService songsService;
	
	//Inyecta una dependencia de la clase de Servicio
	@Autowired
	public SongsController(SongsService songsService) {
		this.songsService = songsService;
	}
	
	//Llamada GET, devuelve todas las canciones existentes
	@GetMapping("api/songs/all")
	public List<Song> allSongs(){
		return songsService.allSongs();
	}
	
	//Llamada GET, devuelve todas las canciones según el nombre del artista
	@GetMapping("api/songs/of")
	public List<Song> allSongs(@RequestParam String artist) {
		return songsService.allSongsOf(artist);
	}
	
	//Llamada POST, recibe una canción (en el body) y la agrega
	@PostMapping
	public void addSong(@RequestBody Song song) {
		songsService.addSong(song);
	}
	
	//Llamada DELETE, elimina la canción con el ID que recibe en la URL
	@DeleteMapping("api/deletesong")
	public String deleteSong(@RequestParam int id) {
		return songsService.deleteSong(id);
	}
	
	//Llamada PUT, actualiza el productor de la canción con el ID que recibe en la URL,
	//junto con el nombre del nuevo productor
	@PutMapping("api/updateproducer")
	public String updateSongProducer(@RequestParam int id,
								@RequestParam String producer) {
		return songsService.updateSongProducer(id, producer);
	}
}
