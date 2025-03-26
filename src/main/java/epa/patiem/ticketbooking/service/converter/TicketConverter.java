package epa.patiem.ticketbooking.service.converter;

import epa.patiem.ticketbooking.model.mongo.Category;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import epa.patiem.ticketbooking.model.sql.SqlTicket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TicketConverter {

    private EventConverter eventConverter;

    public List<Ticket> convert(List<SqlTicket> tickets) {
        return tickets.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Ticket convert(SqlTicket ticket) {
        return Ticket.builder()
                .event(eventConverter.convert(ticket.getEvent()))
                .date(ticket.getEvent().getDate())
                .ticketPrice(ticket.getEvent().getTicketPrice())
                .place(ticket.getPlace())
                .category(Category.valueOf(ticket.getCategory().name()))
                .build();
    }
}
