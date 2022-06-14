package com.songs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity	//Indica que esta clase es una entidad de la base de datos
@Table	//Especifica nombre de la tabla de esta entidad, por defecto se llaman igual
public class Song {
	
	@Id	//Especifica que el atributo es la clave primaria
	@SequenceGenerator(name = "songs_sequence", sequenceName = "songs_sequence", allocationSize = 1)	//Generador de clave primaria
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "songs_sequence")	//Especificaciones para generar clave primaria
	private int id;
	private String album;
	private String artist;
	private String duration;
	private String name;
	private String producer;
	private int year;
	private String spotify_url;
	
	public Song() {
	}
	
	public Song(int id, String album, String artist, String duration, String name, String producer, int year, String spotify_url) {
		super();
		this.id = id;
		this.album = album;
		this.artist = artist;
		this.duration = duration;
		this.name = name;
		this.producer = producer;
		this.year = year;
		this.spotify_url = spotify_url;
	}

	public Song(String album, String artist, String duration, String name, String producer, int year, String spotify_url) {
		super();
		this.album = album;
		this.artist = artist;
		this.duration = duration;
		this.name = name;
		this.producer = producer;
		this.year = year;
		this.spotify_url = spotify_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getSpotify_url() {
		return spotify_url;
	}

	public void setSpotify_url(String spotify_url) {
		this.spotify_url = spotify_url;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", album=" + album + ", artist=" + artist + ", duration=" + duration + ", name="
				+ name + ", producer=" + producer + ", year=" + year + ", spotify_url=" + spotify_url + "]";
	}
	
}
