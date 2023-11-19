package com.cignex.ticketBooking.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cignex.ticketBooking.model.Movie;
import com.cignex.ticketBooking.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	// getallMovies
	@RequestMapping(method = RequestMethod.GET, value = "/movieList")
	public String getAllMovie(ModelMap model) throws IOException {
		String imgString = null;
		List<Movie> movies=movieService.getAllMovie();
		System.out.println("getttallllllllll"+movies);
		for(Movie m:movies) {
			System.out.println("getAll data"+m);
			File file = new File(m.getImage().toString());
			byte[] byteImg = Files.readAllBytes(file.toPath());
			imgString = Base64.encodeBase64String(byteImg);
			m.setImage(imgString);
		}
		model.put("movies", movies);
		return "movieList";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/movieAdd")
	public String add(ModelMap model) {
		Movie movie = new Movie();
		model.put("movie", movie);
		return "movieAdd";
	}
	
	@PostMapping("/addMovie") 
	public String save(ModelMap model,@RequestParam String name,@RequestParam String description,@RequestParam("image") MultipartFile[] image) throws IOException {
		 Movie movie = new Movie();
		 Path path = movieService.getpath(image);
		  movie.setName(name);
		  movie.setDescription(description);
		  movie.setImage(path.toString());
		  movieService.addMovie(movie);
		System.out.println("Save methoddddd"+movie);
		return "redirect:/movieList";
	}

	@RequestMapping(value = "/updateMovie", method = RequestMethod.GET)
	public String update(@RequestParam int id,ModelMap model) {
		Optional<Movie> movies = movieService.getById(id);
		model.put("movie", movies);
		return "movieAdd";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMovie(@ModelAttribute Movie movie){
		movieService.updateMovie(movie);
		System.out.println(movie);
		return "redirect:/movieList";
	}
	@RequestMapping(value="/deleteMovie", method=RequestMethod.GET)
	public String deleteMovie(@RequestParam int id) {
		movieService.deleteMovie(id);
		return "redirect:/movieList";
	}

}
