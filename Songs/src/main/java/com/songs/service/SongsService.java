package com.songs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songs.model.Song;
import com.songs.repository.SongsRepository;

@Service
public class SongsService {
	
	SongsRepository songsRepository;

	//Inyecta una dependencia de la clase de Repositorio
	@Autowired
	public SongsService(SongsRepository songsRepository) {
		this.songsRepository = songsRepository;
	}
	
	//Devuelve todas las canciones
	public List<Song> allSongs() {
		return songsRepository.findAll();
	}
	
	//Devuelve todas las canciones de un determinado artista
	public List<Song> allSongsOf(String artist) {
		return songsRepository.findSongsByArtist(artist);
	}
	
	//Recibe una canción y la agrega
	public void addSong(Song song) {
		Optional<Song> songOptional = songsRepository.findById(song.getId());
		if(songOptional.isPresent()) {
			throw new IllegalStateException("Song ID taken.");
		}
		songsRepository.save(song);
	}
	
	//Si existe una canción con el ID, la elimina
	public String deleteSong(int id) {
		Optional<Song> songOptional = songsRepository.findById(id);
		if(songOptional.isPresent()) {
			songsRepository.deleteById(id);
			return "OK";
		} else {
			throw new IllegalStateException("Invalid ID.");
		}
	}
	
	//Si existe una canción con el ID, actualiza el nombre de su productor
	@Transactional //Anotación para manipular la información de la entidad con getters y setters
	public String updateSongProducer(int id, String producer) {
		Optional<Song> songOptional = songsRepository.findById(id);
		if(songOptional.isPresent()) {
			songOptional.get().setProducer(producer);
			return "OK";
		} else {
			throw new IllegalStateException("Invalid ID.");
		}
	}

}
