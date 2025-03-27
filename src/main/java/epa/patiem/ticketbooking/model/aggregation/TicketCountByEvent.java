package epa.patiem.ticketbooking.model.aggregation;

import epa.patiem.ticketbooking.model.mongo.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCountByEvent {
    private Event event;
    private int count;
}
