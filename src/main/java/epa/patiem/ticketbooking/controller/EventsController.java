package epa.patiem.ticketbooking.controller;

import epa.patiem.ticketbooking.model.mongo.Event;
import epa.patiem.ticketbooking.model.sql.SqlEvent;
import epa.patiem.ticketbooking.service.EventService;
import epa.patiem.ticketbooking.service.sql.SqlEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventService mongoService;

    @Autowired
    private SqlEventService sqlService;

    @GetMapping("/sql")
    public List<SqlEvent> getAllSqlUsers() {
        return sqlService.getAll();
    }

    @GetMapping("/mongo")
    public List<Event> getAllMongoUsers() {
        return mongoService.getAll();
    }
}
