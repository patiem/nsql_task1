package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.Event;

import java.util.List;

public interface EventService {

    List<Event> getAll();

}
