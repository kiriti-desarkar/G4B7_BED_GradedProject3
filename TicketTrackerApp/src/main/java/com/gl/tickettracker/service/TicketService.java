package com.gl.tickettracker.service;

import java.util.List;

import com.gl.tickettracker.model.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets();

	Ticket addTicket(Ticket ticket);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketByid(Long id);

	List<Ticket> getTicketsByKeyword(String keyword);

}
