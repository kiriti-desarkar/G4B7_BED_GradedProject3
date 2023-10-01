package com.gl.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.tickettracker.model.Ticket;
import com.gl.tickettracker.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	//display all tickets
	@GetMapping("/tickets")
	public String getAllTickets(Model model,@RequestParam(name = "keyword",required = false)String keyword) {
		List<Ticket> tickets = ticketService.getAllTickets();
		if(keyword != null) {
			model.addAttribute("tickets", ticketService.getTicketsByKeyword(keyword));
		} else {
			model.addAttribute("tickets", tickets);
		}
		return "tickets";
	}
	
	//Create a new ticket
	@GetMapping("/tickets/newTicket")
	public String createNewTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "create_ticket";
	}
	
	@PostMapping("/tickets/addTicket")
	public String addTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.addTicket(ticket);
		return "redirect:/admin/tickets";
	}
	
	//delete existing ticket
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Long id) {
		ticketService.deleteTicketByid(id);
		return "redirect:/admin/tickets";
	}	
	
	//view existing ticket
	@GetMapping("/view/{id}")
	public String ticketViewPage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "view_ticket";
	}
	
	//edit existing ticket
	@GetMapping("/update/{id}")
	public String ticketUpdatePage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "update_ticket";
	}
	
	@RequestMapping("/updateTicket")
	public String updateTicket (Ticket ticket) {
	ticketService.updateTicket(ticket);
	return "redirect:/admin/tickets";
	}
}
