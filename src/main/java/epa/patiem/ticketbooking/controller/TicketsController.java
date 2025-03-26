package epa.patiem.ticketbooking.controller;

import epa.patiem.ticketbooking.model.mongo.Ticket;
import epa.patiem.ticketbooking.model.sql.SqlTicket;
import epa.patiem.ticketbooking.service.TicketService;
import epa.patiem.ticketbooking.service.sql.SqlTicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketsController {

    private static final Logger log = LoggerFactory.getLogger(TicketsController.class);

    private final TicketService mongoService;
    private final SqlTicketService sqlService;

    @GetMapping("/sql")
    public List<SqlTicket> getAllSqlUsers() {
        return sqlService.getAll();
    }

    @GetMapping("/mongo")
    public List<Ticket> getAllMongoUsers() {
        return mongoService.getAll();
    }
}
