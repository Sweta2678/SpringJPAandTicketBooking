package com.cignex.ticketBooking.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Seat {
	@Id
	@GeneratedValue
	private int seat_id;
	@ElementCollection
	private List<String> platinum_seat;
	@ElementCollection
	private List<String> gold_seat;
	@ElementCollection
	private List<String> silver_seat;
	
	@OneToOne
	private MovieShow movieShow;
	
	public Seat(List<String> platinum_seat, List<String> gold_seat, List<String> silver_seat, MovieShow movieShow) {
		super();
		this.platinum_seat = platinum_seat;
		this.gold_seat = gold_seat;
		this.silver_seat = silver_seat;
		this.movieShow = movieShow;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getPlatinum_seat() {
		return platinum_seat;
	}

	public void setPlatinum_seat(List<String> platinum_seat) {
		this.platinum_seat = platinum_seat;
	}

	public List<String> getGold_seat() {
		return gold_seat;
	}

	public void setGold_seat(List<String> gold_seat) {
		this.gold_seat = gold_seat;
	}

	public List<String> getSilver_seat() {
		return silver_seat;
	}

	public void setSilver_seat(List<String> silver_seat) {
		this.silver_seat = silver_seat;
	}
	
	

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public MovieShow getMovieShow() {
		return movieShow;
	}

	public void setMovieShow(MovieShow movieShow) {
		this.movieShow = movieShow;
	}

	@Override
	public String toString() {
		return "Seat [seat_id=" + seat_id + ", platinum_seat=" + platinum_seat + ", gold_seat=" + gold_seat
				+ ", silver_seat=" + silver_seat + ", movieShow=" + movieShow + "]";
	}

}
