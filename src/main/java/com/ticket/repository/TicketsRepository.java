package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.model.Tickets;

public interface TicketsRepository  extends JpaRepository<Tickets,Integer>{
	

}
