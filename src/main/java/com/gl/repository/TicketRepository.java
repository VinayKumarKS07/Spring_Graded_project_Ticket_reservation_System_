package com.gl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.gl.Model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> ,ListCrudRepository<Ticket, Integer>{
	public Ticket getByticketTitle(String ticketTitle);

}
