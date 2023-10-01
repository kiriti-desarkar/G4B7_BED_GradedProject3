package com.gl.tickettracker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tickettracker.model.Ticket;
import com.gl.tickettracker.repository.TicketRepository;
import com.gl.tickettracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id passed"));
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		if (ticketRepository.existsById(ticket.getId())) {
			return ticketRepository.save(ticket);
		}
		return null;
	}

	@Override
	public void deleteTicketByid(Long id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public List<Ticket> getTicketsByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

}
