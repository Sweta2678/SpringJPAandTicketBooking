package com.cignex.ticketBooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.ticketBooking.DefaultExceptionHandler;
import com.cignex.ticketBooking.model.Screen;
import com.cignex.ticketBooking.repository.ScreenRepository;

@Service
public class ScreenService {
	@Autowired
	private ScreenRepository screenRepository;

	public List<Screen> getAllScreen() {
		return screenRepository.findAll();
	}

	public Screen addScreen(Screen screen) {
		return screenRepository.save(screen);

	}
	public void deleteScreen(int screen_id) {
		if(screen_id==25) {
//			throw new RuntimeException("Some thing went wrongg");
//			throw new DefaultExceptionHandler();
		}
	
		screenRepository.deleteById(screen_id);
	}

	public Optional<Screen> getById(int screen_id) {
		
		return screenRepository.findById(screen_id);
	}

	public void updateScreen(Screen screen) {
		
		screenRepository.save(screen);
	}

}
