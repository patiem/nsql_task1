package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.Event;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import epa.patiem.ticketbooking.model.mongo.User;
import epa.patiem.ticketbooking.model.sql.SqlEvent;
import epa.patiem.ticketbooking.model.sql.SqlUser;
import epa.patiem.ticketbooking.repository.mongo.EventRepository;
import epa.patiem.ticketbooking.repository.mongo.TicketRepository;
import epa.patiem.ticketbooking.repository.mongo.UserRepository;
import epa.patiem.ticketbooking.repository.sql.SqlEventRepository;
import epa.patiem.ticketbooking.repository.sql.SqlUserRepository;
import epa.patiem.ticketbooking.service.converter.UserConverter;
import epa.patiem.ticketbooking.service.converter.EventConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlToMongoService {

    @Autowired
    private UserRepository mongoUserRepository;
    @Autowired
    private TicketRepository mongoTicketRepository;
    @Autowired
    private EventRepository mongoEventRepository;

    @Autowired
    private SqlUserRepository sqlUerRepository;
    @Autowired
    private SqlEventRepository  sqlEventRepository;

    @Autowired
    private UserConverter userConverter;
    @Autowired
    private EventConverter eventConverter;


    public void migrate() {

        List<SqlUser> users = (List<SqlUser>) sqlUerRepository.findAll();
        List<User> mongoUsers = userConverter.convert(users);
        mongoUsers.forEach(this::saveUser);

        List<SqlEvent> events = (List<SqlEvent>) sqlEventRepository.findAll();
        List<Event> mongoEvents = eventConverter.convert(events);
        mongoEvents.forEach(this::saveEvent);
    }

    private void saveUser(User user) {
        List<Ticket> tickets = user.getTickets();
        mongoTicketRepository.saveAll(tickets);
        mongoUserRepository.save(user);
    }

    private void saveEvent(Event event) {
        mongoEventRepository.save(event);
    }

}