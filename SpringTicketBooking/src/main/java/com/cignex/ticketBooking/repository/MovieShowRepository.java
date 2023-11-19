package com.cignex.ticketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cignex.ticketBooking.model.MovieShow;
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {

}