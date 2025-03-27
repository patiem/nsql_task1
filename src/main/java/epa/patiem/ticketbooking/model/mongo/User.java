package epa.patiem.ticketbooking.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    @Field("_id")
    private String id;

    private String name;
    private String email;

    @DBRef
    private List<Ticket> tickets = new ArrayList<>();
    private UserAccount account;

    public List<Ticket> getTickets() {
        return tickets;
    }

}
