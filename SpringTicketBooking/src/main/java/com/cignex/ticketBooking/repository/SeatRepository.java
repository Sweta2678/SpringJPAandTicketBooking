package com.cignex.ticketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cignex.ticketBooking.model.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer>{

}
