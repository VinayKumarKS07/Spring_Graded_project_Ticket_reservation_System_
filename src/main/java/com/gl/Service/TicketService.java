package com.gl.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

import com.gl.Model.Ticket;

public interface TicketService {

	public void save(Ticket ticket);
	public void delete(int id);
	public Optional<Ticket> update(int id,Model m);
	public List<Ticket> list();
	public Optional<Ticket> findbyId(int id);
	public Optional<Ticket> getByticketTitle(String ticketTitle);
	
}
