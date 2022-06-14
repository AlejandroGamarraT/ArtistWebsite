package com.songs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.songs.model.Song;

/*Interfaz que hereda de JpaRepository, especifica la entidad con la cual
 * trabajará, así como el tipo de la clave primaria de dicha entidad
 */

@Repository
public interface SongsRepository extends JpaRepository<Song, Integer> {
	
	
	
}
