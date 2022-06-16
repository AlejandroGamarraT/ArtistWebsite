package com.songs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.songs.model.Song;

/*Interfaz que hereda de JpaRepository, especifica la entidad con la cual
 * trabajará, así como el tipo de la clave primaria de dicha entidad
 */

@Repository
public interface SongsRepository extends JpaRepository<Song, Integer> {
	
	@Query("SELECT s FROM Song s WHERE s.artist = ?1")
	List<Song> findSongsByArtist(String artist);
	
}
