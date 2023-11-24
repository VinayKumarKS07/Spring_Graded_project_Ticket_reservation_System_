package com.gl.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Model.Ticket;
import com.gl.Service.TicketService;
import com.gl.repository.TicketRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/Tickets")
@Slf4j
public class HomeController {

	@Autowired
	TicketService service;
	@RequestMapping("/home")
	public String homePage(Model m) {
	    List<Ticket> list = (List<Ticket>) service.list();
	    m.addAttribute("Tickets", list);
		return "home";
	}
	
	
//	
//	public String update() {
//		
//	}
	
	@RequestMapping("/addTicket")
	public String addTicket(Model m) {
		m.addAttribute("Tickets", new Ticket());
		return "addTicket";
	}
	
	
	@PostMapping("/process")
	public String processTicket(@ModelAttribute Ticket ticket , Model m) {
		service.save(ticket);
		log.info("Saved Successfully");
		List<Ticket> list = (List<Ticket>) service.list();
		m.addAttribute("Tickets", list);
		return "redirect:/Tickets/home";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteOperation(@PathVariable("id") int id , Model m) {
	  
		//Deleting by Id
	    service.delete(id);
	    m.addAttribute("Tickets", service.list());
		return "redirect:/Tickets/home";
		
	}
	
	
     @RequestMapping("/update/{id}")
	public String UpdateTicket(@PathVariable int id , Model m) {
		service.update(id, m);
		return "addTicket";
	}
	
     @RequestMapping("/View/{id}")
 	public String ViewTicket(@PathVariable int id , Model m) {
    	Optional<Ticket> ticket = service.findbyId(id);
    	m.addAttribute("Tickets", ticket);
 		return "viewform";
 	}
	
     
     @RequestMapping("/search")
     public String SearchOperation(@RequestParam("ticketTitle") String ticketTitle,Model m) {
      Optional<Ticket> ticket = service.getByticketTitle(ticketTitle);	
      if (ticket.isEmpty()) {
     log.info("The Search item is not present ");
     return "redirect:home";
      }
      m.addAttribute("Tickets", ticket);
      return "viewform";
   }
}
