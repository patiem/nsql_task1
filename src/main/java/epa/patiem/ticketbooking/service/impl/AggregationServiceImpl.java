package epa.patiem.ticketbooking.service.impl;


import epa.patiem.ticketbooking.model.aggregation.TicketCountByCategory;
import epa.patiem.ticketbooking.model.aggregation.TicketCountByEvent;
import epa.patiem.ticketbooking.model.aggregation.UserWithTicketCount;
import epa.patiem.ticketbooking.repository.mongo.EventRepository;
import epa.patiem.ticketbooking.repository.mongo.TicketRepository;
import epa.patiem.ticketbooking.repository.mongo.UserRepository;
import epa.patiem.ticketbooking.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AggregationServiceImpl implements AggregationService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, Object> getAggregatedData() {
        Map<String, Object> results = new HashMap<>();

        List<TicketCountByEvent> ticketCountByEvents = ticketRepository.countTicketsByEvent();
        results.put("ticketsByCategory", ticketCountByEvents);

        List<TicketCountByCategory> ticketCountsByCategory = ticketRepository.countTicketsByCategory();
        results.put("ticketsByCategory", ticketCountsByCategory);

        List<UserWithTicketCount> topUsers = userRepository.findTopUsersByTicketCount();
        results.put("topUsersByTicketCount", topUsers);

        return results;
    }
}

