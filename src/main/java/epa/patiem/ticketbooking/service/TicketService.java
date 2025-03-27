package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();
}