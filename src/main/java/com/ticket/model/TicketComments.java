package com.ticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name="ticket_comments")
public class TicketComments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="comments")
	private Integer comments;
}
