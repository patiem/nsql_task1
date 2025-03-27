package epa.patiem.ticketbooking.model.aggregation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithTicketCount {
    private String name;
    private String email;
    private int ticketCount;
}
