package com.gl.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gl.Model.Ticket;
import com.gl.repository.TicketRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository dao;
	
	
	public void save(Ticket ticket){
		dao.save(ticket);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
    public Optional<Ticket> update(int id, Model m) {
	     Optional<Ticket> optionalTicket = dao.findById(id);
	     optionalTicket.ifPresent(ticket -> m.addAttribute("Tickets", ticket));
	     return optionalTicket;
	   }

    public List<Ticket> list(){
    	 List<Ticket> list = dao.findAll();
    	 return list;
    }
    
    public Optional<Ticket> findbyId(int id) {
    Optional<Ticket> ticket = dao.findById(id);
    return ticket;
    }
    
    public Optional<Ticket> getByticketTitle(String ticketTitle) {
    	Optional<Ticket> ticket = Optional.ofNullable(dao.getByticketTitle(ticketTitle));
    	if(ticket.isEmpty()) {
    	   log.info("Ticket not found");
    	}
		return ticket;   
		}
}
	