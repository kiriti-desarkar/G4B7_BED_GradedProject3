package com.gl.tickettracker.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String ticketTitle;

	@Column
	private String ticketDescription;

	@Column
	private String content;

	@Column
	private LocalDate ticketCreationDate = LocalDate.now();

	public Ticket() {
	}

	public Ticket(long id, String ticketTitle, String ticketDescription, String content, LocalDate ticketCreationDate) {
		super();
		this.id = id;
		this.ticketTitle = ticketTitle;
		this.ticketDescription = ticketDescription;
		this.content = content;
		this.ticketCreationDate = ticketCreationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getTicketCreationDate() {
		return ticketCreationDate;
	}

	public void setTicketCreationDate(LocalDate ticketCreationDate) {
		this.ticketCreationDate = ticketCreationDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketTitle=" + ticketTitle + ", ticketDescription=" + ticketDescription
				+ ", content=" + content + ", ticketCreationDate=" + ticketCreationDate + "]";
	}

}
