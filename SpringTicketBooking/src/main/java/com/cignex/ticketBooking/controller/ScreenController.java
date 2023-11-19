package com.cignex.ticketBooking.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cignex.ticketBooking.exception.UserNotFoundException;
import com.cignex.ticketBooking.model.MovieShow;
import com.cignex.ticketBooking.model.Screen;
import com.cignex.ticketBooking.repository.ScreenRepository;
import com.cignex.ticketBooking.service.ScreenService;

@Controller
public class ScreenController {
	@Autowired
	private ScreenService screenService;

	@Autowired
	private ScreenRepository screenRepository; 
	// getallMovies
	@RequestMapping(method = RequestMethod.GET, value = "/screenList")
	public String getAllScreen(ModelMap model) {
		List<Screen> screenlist = screenService.getAllScreen();
		model.put("screens", screenlist);
		return "screenList";
	}
	// @RequestMapping(method = RequestMethod.GET, value = "movieList/screenList")
	// public String getAllScreen(ModelMap model) {
	// List<Screen> screenlist = screenService.getAllScreen();
	// model.put("screen", screenlist);
	// return "screenList";
	// }

	@RequestMapping(method = RequestMethod.GET, value = "/screenAdd")
	public String add(ModelMap model) {
		Screen screen = new Screen();
		model.put("screen", screen);
		return "screenAdd";
	}

	// @RequestMapping(method = RequestMethod.GET, value = "/screenAdd")
	// public String addscreen(ModelMap model) {
	// Screen screen = new Screen();
	// model.put("screen", screen);
	// return "screenAdd";
	// }
	@PostMapping("/addScreen") // to save it in the database
	public String save(@ModelAttribute Screen screen) {
		screenService.addScreen(screen);
		System.out.println(screen);
		return "redirect:/screenList";
	}

	@RequestMapping(value = "/updateScreen", method = RequestMethod.GET)
	public String update(@RequestParam int screen_id, ModelMap model) {
		Optional<Screen> screens = screenService.getById(screen_id);
		Screen screen = screenRepository.getOne(screen_id);
		if(screen==null) {
			throw new UserNotFoundException("screen_id"+screen_id);
		}
		model.put("screen", screens);
		return "screenAdd";
	}

	@RequestMapping(value = "/updaten", method = RequestMethod.POST)
	public String updateScreen(@ModelAttribute Screen screen) {
		screenService.updateScreen(screen);
		System.out.println(screen);
		return "redirect:/screenList";
	}

	@RequestMapping(value = "/deleteScreen", method = RequestMethod.GET)
	public String deleteScreen(@RequestParam int screen_id) {
		screenService.deleteScreen(screen_id);
		return "redirect:/screenList";
	}

}
