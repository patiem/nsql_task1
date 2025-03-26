package epa.patiem.ticketbooking.service.converter;


import epa.patiem.ticketbooking.model.mongo.Event;
import epa.patiem.ticketbooking.model.sql.SqlEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EventConverter {

    @Autowired
    private TicketConverter ticketConverter;

    public List<Event> convert(List<SqlEvent> events) {
        return events.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Event convert(SqlEvent event) {
        return Event.builder()
                .title(event.getTitle())
                .date(event.getDate())
                .ticketPrice(event.getTicketPrice())
                .build();
    }
}
