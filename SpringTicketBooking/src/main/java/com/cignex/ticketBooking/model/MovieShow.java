package com.cignex.ticketBooking.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
public class MovieShow {
	@Id
	@GeneratedValue
	private int show_id;

	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

	@ManyToOne(fetch = FetchType.LAZY)
	private Screen screen;

	private Date show_date;
	private Time show_time;
	private int platinum_price;
	private int gold_price;
	private int silver_price;

	public MovieShow(int show_id, Movie movie, Screen screen, Date show_date, Time show_time, int platinum_price,
			int gold_price, int silver_price) {
		super();
		this.show_id = show_id;
		this.movie = movie;
		this.screen = screen;
		this.show_date = show_date;
		this.show_time = show_time;
		this.platinum_price = platinum_price;
		this.gold_price = gold_price;
		this.silver_price = silver_price;
	}

	public MovieShow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Date getShow_date() {
		return show_date;
	}

	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}

	public Time getShow_time() {
		return show_time;
	}

	public void setShow_time(Time show_time) {
		this.show_time = show_time;
	}

	public int getPlatinum_price() {
		return platinum_price;
	}

	public void setPlatinum_price(int platinum_price) {
		this.platinum_price = platinum_price;
	}

	public int getGold_price() {
		return gold_price;
	}

	public void setGold_price(int gold_price) {
		this.gold_price = gold_price;
	}

	public int getSilver_price() {
		return silver_price;
	}

	public void setSilver_price(int silver_price) {
		this.silver_price = silver_price;
	}

	@Override
	public String toString() {
		return "MovieShow [show_id=" + show_id + ", movie=" + movie + ", screen=" + screen + ", show_date=" + show_date
				+ ", show_time=" + show_time + ", platinum_price=" + platinum_price + ", gold_price=" + gold_price
				+ ", silver_price=" + silver_price + "]";
	}

}
