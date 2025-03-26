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
import epa.patiem.ticketbooking.repository.sql.SqlTicketRepository;
import epa.patiem.ticketbooking.repository.sql.SqlUserRepository;
import epa.patiem.ticketbooking.service.converter.TicketConverter;
import epa.patiem.ticketbooking.service.converter.UserConverter;
import epa.patiem.ticketbooking.service.converter.EventConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SqlToMongoService {

    private final UserRepository mongoUserRepository;
    private final TicketRepository mongoTicketRepository;
    private final EventRepository mongoEventRepository;

    private final SqlUserRepository sqlUerRepository;
    private final SqlTicketRepository sqlTicketRepository;
    private final SqlEventRepository  sqlEventRepository;

    private final TicketConverter ticketConverter;
    private final UserConverter userConverter;
    private final EventConverter eventConverter;


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