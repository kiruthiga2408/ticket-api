package com.ticket.validation;

import org.springframework.stereotype.Component;

import com.ticket.model.Tickets;

@Component
public class TicketValidation {

	public void ticketValidator(Tickets tickets)throws Exception {
		if(tickets.getUserId()==null ) {
			throw new Exception("Invalid User Id");
		}
		if(tickets.getTicketTitle()==null || (tickets.getTicketTitle()).trim()=="") {
			throw  new Exception ("INVALID Ticket Title,Enter a valid Ticket Title...");
		}
		if(tickets.getDescription()==null || (tickets.getDescription()).trim()=="") {
			throw new Exception("Invalid Description Given!");
		}
		
		if(tickets.getCategory()==null || (tickets.getCategory()).trim()=="") {
			throw new Exception("INVALID category");
		}
		/**
		if(tickets.getPriority()==null || (tickets.getPriority()).trim()=="") {
			throw new Exception ("INVALID Priority");
		
		}
		if(tickets.getStatus()==null || (tickets.getStatus()).trim()==""){
			throw new Exception("INVALID Status");
		}
		
		if(tickets.getAssignedTo()==null || (tickets.getAssignedTo()).trim()=="") {
		throw new Exception("Invalid  Assigned");
	}
	**/
	}

}
