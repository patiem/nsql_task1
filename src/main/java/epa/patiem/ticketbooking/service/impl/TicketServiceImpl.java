package epa.patiem.ticketbooking.service.impl;

import epa.patiem.ticketbooking.model.mongo.Ticket;
import epa.patiem.ticketbooking.repository.mongo.TicketRepository;
import epa.patiem.ticketbooking.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }
}
