package com.cignex.ticketBooking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "screen")
public class Screen {
	@Id
	@GeneratedValue
	private int screen_id;
	private String screen_name;
	private int platinum_seat;
	private int gold_seat;
	private int silver_seat;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "screen")
	private List<Movie> movie;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MovieShow> movieshow;

	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Screen(int screen_id, String screen_name, int platinum_seat, int gold_seat, int silver_seat,
			List<Movie> movie, List<MovieShow> movieshow) {
		super();
		this.screen_id = screen_id;
		this.screen_name = screen_name;
		this.platinum_seat = platinum_seat;
		this.gold_seat = gold_seat;
		this.silver_seat = silver_seat;
		this.movie = movie;
		this.movieshow = movieshow;
	}


	public int getScreen_id() {
		return screen_id;
	}


	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}


	public String getScreen_name() {
		return screen_name;
	}


	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}


	public int getPlatinum_seat() {
		return platinum_seat;
	}


	public void setPlatinum_seat(int platinum_seat) {
		this.platinum_seat = platinum_seat;
	}


	public int getGold_seat() {
		return gold_seat;
	}


	public void setGold_seat(int gold_seat) {
		this.gold_seat = gold_seat;
	}


	public int getSilver_seat() {
		return silver_seat;
	}


	public void setSilver_seat(int silver_seat) {
		this.silver_seat = silver_seat;
	}


	public List<Movie> getMovie() {
		return movie;
	}


	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}


	public List<MovieShow> getMovieshow() {
		return movieshow;
	}


	public void setMovieshow(List<MovieShow> movieshow) {
		this.movieshow = movieshow;
	}


	@Override
	public String toString() {
		return "Screen [screen_id=" + screen_id + ", screen_name=" + screen_name + ", platinum_seat=" + platinum_seat
				+ ", gold_seat=" + gold_seat + ", silver_seat=" + silver_seat + ", movie=" + movie + ", movieshow="
				+ movieshow + "]";
	}

	
}
