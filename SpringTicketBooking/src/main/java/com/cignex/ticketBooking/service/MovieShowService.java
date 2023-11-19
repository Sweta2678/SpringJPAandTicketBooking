package com.cignex.ticketBooking.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.ticketBooking.model.MovieShow;
import com.cignex.ticketBooking.model.Screen;
import com.cignex.ticketBooking.model.Seat;
import com.cignex.ticketBooking.repository.MovieShowRepository;
import javax.persistence.Query;

@Service
public class MovieShowService {

	@Autowired
	private MovieShowRepository movieShowRepository;

	@PersistenceContext
	EntityManager em;

	public List<MovieShow> getAllMovieShow() {
		return movieShowRepository.findAll();
	}

	public MovieShow addMovieShow(MovieShow movieshow) {
		return movieShowRepository.save(movieshow);
	}

	public void deleteMovieShow(int Id) {
		movieShowRepository.deleteById(Id);
	}

	public Optional<MovieShow> getById(int id) {
		return movieShowRepository.findById(id);
	}

	public void updateMovieShow(MovieShow movieshow) {
		movieShowRepository.save(movieshow);
	}

	public List<MovieShow> movieShowByMovie(int id) {
		System.out.println("adsfdxbvc" + id);
		Query query = em.createQuery("Select show from MovieShow show where show.movie=" + id);
		List<MovieShow> show = query.getResultList();
		return show;
	}

	public List<Screen> movieShowByScreen(int screen_id) {
		Query query = em.createQuery("Select screen from Screen screen where screen=" + screen_id);
		List<Screen> screenss = query.getResultList();
		return screenss;
	}

//	public List<Seat> seatByScreen(int seat_id) {
//		Query query = em.createQuery("Select show from Screen where seat=" + seat_id);
//		List<Seat> seats = query.getResultList();
//		System.out.println(seats);
//		return seats;
//		
//	}

	public List<Seat> GetBySeat(int show_id) {
		Query query = em.createQuery("select seat from Seat seat where seat.movieShow="+show_id);
		System.out.println("HELLLLLLLLLLLLLLLLLo"+query.toString());
		List<Seat> seats = query.getResultList();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+seats);
		return seats;
	}

	// public List<MovieShow> movieShowByScreen(int screen_id) {
	// System.out.println("@@@@@@@@@@@@@@@@@" + screen_id);
	// Query query = em.createQuery("Select shows from MovieShow shows where
	// show.screen="+screen_id);
	// List<MovieShow> shows = query.getResultList();
	// return shows;
	// }

	

}
