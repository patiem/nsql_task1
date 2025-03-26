package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.Event;

import java.util.Date;
import java.util.List;

/**
 * The interface Event service.
 */
public interface EventService {

    List<Event> getAll();
//    Event getEventById(String eventId);
//    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
//    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);
//    Event createEvent(Event event);
//    Event updateEvent(Event event);
//    boolean deleteEvent(String eventId);
}
