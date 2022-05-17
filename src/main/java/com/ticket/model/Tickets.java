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
@Entity(name="query_tickets")
public class Tickets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="ticket_title")
	private String ticketTitle;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category" )
	private String category ;
	
	@Column(name="assigned_to" )
	private Integer assignedTo;

	@Column(name="priority" )
	private String priority="low";
	
	
	@Column(name="status" )
	private String status="open";
	
} 
