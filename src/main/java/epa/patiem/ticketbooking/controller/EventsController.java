package epa.patiem.ticketbooking.controller;

import epa.patiem.ticketbooking.model.mongo.Event;
import epa.patiem.ticketbooking.model.sql.SqlEvent;
import epa.patiem.ticketbooking.service.EventService;
import epa.patiem.ticketbooking.service.sql.SqlEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventsController {

    private final EventService mongoService;
    private final SqlEventService sqlService;

    @GetMapping("/sql")
    public List<SqlEvent> getAllSqlUsers() {
        return sqlService.getAll();
    }

    @GetMapping("/mongo")
    public List<Event> getAllMongoUsers() {
        return mongoService.getAll();
    }
}
