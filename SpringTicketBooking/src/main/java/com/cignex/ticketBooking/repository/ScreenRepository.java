package com.cignex.ticketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cignex.ticketBooking.model.Screen;

//@Repository
	public interface ScreenRepository extends JpaRepository<Screen, Integer> {
	}
