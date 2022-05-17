package com.ticket.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ticket.dto.MessageDTO;
import com.ticket.model.Tickets;
import com.ticket.repository.TicketsRepository;
import com.ticket.service.TicketsService;

@RestController
public class TicketsController {
	
	@Autowired
	TicketsRepository ticketsRepository;
	
	@Autowired
	TicketsService ticketsService;
	
	@PostMapping("ticket/save")
    public ResponseEntity<?> addTicket(@RequestBody Tickets tickets){
    	
		try {
			ticketsService.save(tickets);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	

    @GetMapping("ticket/listall") 
    public  List<Tickets>  findAll(){
		 List<Tickets> listall=ticketsRepository.findAll();
		 return listall;
		 
	 }
    
    @DeleteMapping("ticket/{id}")
	 public  void delete(@PathVariable("id")  Integer id) {
		 ticketsRepository.deleteById(id);
	 }
    @PutMapping("tickets/{id}")
	 public void update(@PathVariable("id") Integer id,@RequestBody Tickets tickets) {
		 tickets.setId(id);
		 ticketsRepository.save(tickets);
	 }
    
    @GetMapping("ticketss/search")
 	public List<Tickets> findByName(@RequestParam("description") String description) {
 		System.out.println(description);
 		List<Tickets> tickets = ticketsRepository.findAll();
 		List<Tickets> filteredProducts = tickets.stream().filter(m-> m.getDescription().toLowerCase().contains(description.toLowerCase())).collect(Collectors.toList());
 		return filteredProducts;
 	}
 
    
    @GetMapping("tickets/{id}")
 	public Tickets findById(@PathVariable("id") Integer id) {
 		Optional<Tickets> tickets = ticketsRepository.findById(id);
 		if (tickets.isPresent()) {
 			Tickets obj = tickets.get();
 			return obj;
 		} else {
 			return null;

 		}

 	}
      
	 
    
	

}
