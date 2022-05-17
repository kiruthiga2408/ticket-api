package com.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ticket.model.Tickets;
import com.ticket.repository.TicketsRepository;
import com.ticket.validation.TicketValidation;

@Component
public class TicketsService {
	@Autowired
	TicketsRepository ticketsRepository;
	@Autowired 
	TicketValidation ticketValidation; 
	
	public void save(Tickets tickets)throws Exception{
		try {
			ticketValidation.ticketValidator(tickets);
			ticketsRepository.save(tickets);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	

}
