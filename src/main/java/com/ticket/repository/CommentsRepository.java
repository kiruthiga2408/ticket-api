package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.model.TicketComments;

public interface CommentsRepository extends JpaRepository<TicketComments,Integer> {
	

}
