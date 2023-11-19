package com.cignex.ticketBooking.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String image;

	// private String base64Image;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MovieShow> movieshow;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Screen> screen;

	public Movie() {
		super();
	
	}
	

	public Movie(int id, String name, String description, String image, List<MovieShow> movieshow,
			List<Screen> screen) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.movieshow = movieshow;
		this.screen = screen;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<MovieShow> getMovieshow() {
		return movieshow;
	}

	public void setMovieshow(List<MovieShow> movieshow) {
		this.movieshow = movieshow;
	}

	public List<Screen> getScreen() {
		return screen;
	}

	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", movieshow=" + movieshow + ", screen=" + screen + "]";
	}
	
	

}
