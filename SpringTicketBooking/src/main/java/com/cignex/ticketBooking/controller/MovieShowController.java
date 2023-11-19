package com.cignex.ticketBooking.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Time;
import java.util.List;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cignex.ticketBooking.model.Movie;
import com.cignex.ticketBooking.model.MovieShow;
import com.cignex.ticketBooking.model.Screen;
import com.cignex.ticketBooking.model.Seat;
import com.cignex.ticketBooking.repository.MovieShowRepository;
import com.cignex.ticketBooking.repository.SeatRepository;
import com.cignex.ticketBooking.service.MovieService;
import com.cignex.ticketBooking.service.MovieShowService;
import com.cignex.ticketBooking.service.ScreenService;

@Controller
public class MovieShowController {
	@Autowired
	private MovieShowService movieShowService;

	@Autowired
	MovieService movieService;

	@Autowired
	ScreenService screenService;
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	MovieShowRepository movieShowRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/movieShowList")
	public String getAllMovieShow(ModelMap model) {
		List<MovieShow> movieshowlist = movieShowService.getAllMovieShow();
		model.put("movieshow", movieshowlist);
		return "movieShowList";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/movieShowAdd")
	public String addMovieShow(ModelMap model) {
		MovieShow movieshow = new MovieShow();
		List<Movie> movies = movieService.getAllMovie();
		model.put("movies", movies);
		List<Screen> screens = screenService.getAllScreen();
		model.put("screens", screens);
		model.put("movieshow", movieshow);
		return "movieShowAdd";
	}

	@PostMapping("/addMovieShow") // to save it in the database
	public String save(@ModelAttribute MovieShow movieshow, HttpServletRequest request) {
		Time time = Time.valueOf(request.getParameter("showtime") + ":00");
		movieshow.setShow_time(time);
		movieShowService.addMovieShow(movieshow);
		return "redirect:/movieShowList";
	}

	@RequestMapping(value = "/updateMovieShow", method = RequestMethod.GET)
	public String updated(ModelMap model, @RequestParam int show_id) {
		MovieShow movieshow = movieShowService.getById(show_id).get();
		model.put("movieshow", movieshow);
		List<Movie> movies = movieService.getAllMovie();
		model.put("movies", movies);
		List<Screen> screens = screenService.getAllScreen();
		model.put("screens", screens);
		return "movieShowAdd";
	}

	@RequestMapping(value = "/updateMovieShow", method = RequestMethod.POST)
	public String updateMovieShow(@ModelAttribute MovieShow movieshow, @RequestParam("show_time") Time show_time,
			HttpServletRequest request, ModelMap model) {
		movieShowService.updateMovieShow(movieshow);
		System.out.println(movieshow);
		return "redirect:/movieShowList";
	}

	@RequestMapping(value = "/deleteMovieShow", method = RequestMethod.GET)
	public String deleteMovieShow(@RequestParam int show_id) {
		movieShowService.deleteMovieShow(show_id);
		return "redirect:/movieShowList";
	}

	@RequestMapping(value = "/seatBook", method = RequestMethod.GET)
	public String MovieSeats(ModelMap model, @ModelAttribute MovieShow movieshow) {
		MovieShow movieshows = new MovieShow();
		model.put("movieshow", movieshows);
		return "/seatBook";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/bookMovies")
	public String bookMovieShow(ModelMap model) throws IOException {
		// System.out.println(movieshow.getMovie());
		String imgString = null;
		MovieShow movieshow = new MovieShow();
		List<Movie> movies = movieService.getAllMovie();
		for(Movie m:movies) {
			System.out.println("getAll data"+m);
			File file = new File(m.getImage().toString());
			byte[] byteImg = Files.readAllBytes(file.toPath());
			imgString = Base64.encodeBase64String(byteImg);
			m.setImage(imgString);
		}
		model.put("movies", movies);
		model.put("movieshow", movieshow);
		return "bookMovie";
	}

	@GetMapping("/bookMovie")
//	@PostMapping("/bookMovie") // to save it in the database
	public String bookMovie(ModelMap model, HttpServletRequest request, @ModelAttribute MovieShow movieshow,
			@RequestParam("id") int id) {

		List<MovieShow> movieshowlists = movieShowService.movieShowByMovie(id);
		System.out.println(movieshowlists);
		model.put("movieshowss", movieshowlists);
		return "bookScreen";
	}
//	
	@RequestMapping(method=RequestMethod.GET, value="/screenSeats")
	public String booking(@RequestParam("show_id") int show_id, ModelMap model,@RequestParam("screen") int screen,@RequestParam("platinum_price") int platinum_price,@RequestParam("gold_price") int gold_price,@RequestParam("silver_price") int silver_price){
		System.out.println("yessssssssssssssssss"+show_id);
		List<Screen> seatlist = movieShowService.movieShowByScreen(screen);
		System.out.println(seatlist);
		List<Seat> checkedSeat = movieShowService.GetBySeat(show_id);
		System.out.println(checkedSeat);
		model.put("movieshw", seatlist);
		model.put("show_id", show_id);
		model.put("platinum_price", platinum_price);
		model.put("gold_price", gold_price);
		model.put("silver_price", silver_price);
		model.put("seatshow", checkedSeat);
		return "seatBook";
	}

	@PostMapping("/saveData")
	public String Savedata(@ModelAttribute("seat") Seat seat,ModelMap model,@RequestParam("show_id") int show_id) {
		
	    model.addAttribute("platinum_seat",seat.getPlatinum_seat());
        model.addAttribute("gold_seat",seat.getGold_seat());
        model.addAttribute("silver_seat", seat.getSilver_seat());
        
        model.put("seat", seat);
        MovieShow movieShow = new MovieShow();
        movieShow.setShow_id(show_id);
        seat.setMovieShow(movieShow);
//        seat.setMovieShow(movieShow);
        seatRepository.save(seat);
		return "saveData";
	}
	
//	@PostMapping("/saveDatas")
//	public String GetData(@ModelAttribute("seat") Seat seat,ModelMap model,@RequestParam Seat seat_id) {
//		Optional<Seat> seats = seatRepository.findById(seat_id);
//		System.out.println(seats);
//		System.out.println("@@@@@@@@@@@@@@@@@@@");
//		  model.put("seat", seats);
//		return "redirect:/saveData";
//		
//	}
//	@PostMapping("/saveDatas") // to save it in the database
//	public String GetData(ModelMap model, HttpServletRequest request, @ModelAttribute("seat") Seat seat,
//			@RequestParam("seat_id") int seat_id, @RequestParam int show_id) {
//		 List<Seat> checkedSeat = movieShowService.GetBySeat(show_id);
//       model.put("show_id", show_id);
//       model.put("seatshow", checkedSeat);
//		return "redirect:/saveData";
//	}
		
}
