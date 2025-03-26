package epa.patiem.ticketbooking.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import epa.patiem.ticketbooking.model.mongo.Event;
import epa.patiem.ticketbooking.repository.mongo.EventRepository;
import epa.patiem.ticketbooking.service.EventService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Event service.
 */
@Service
public class EventServiceImpl implements EventService {

    private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

}