package com.cignex.ticketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cignex.ticketBooking.model.Movie;
//@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
