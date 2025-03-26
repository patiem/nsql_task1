package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.Category;
import epa.patiem.ticketbooking.model.mongo.Event;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import epa.patiem.ticketbooking.model.mongo.User;

import java.util.List;

/**
 * The interface Ticket service.
 */
public interface TicketService {

    List<Ticket> getAll();
//
//    Ticket bookTicket(String userId, String eventId, int place, Category category);
//
//    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);
//
//    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);
//
//    boolean cancelTicket(String ticketId);
}