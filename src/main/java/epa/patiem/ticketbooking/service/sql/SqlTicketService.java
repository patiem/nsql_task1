package epa.patiem.ticketbooking.service.sql;

import epa.patiem.ticketbooking.model.sql.SqlTicket;
import epa.patiem.ticketbooking.model.sql.SqlUser;
import epa.patiem.ticketbooking.repository.sql.SqlTicketRepository;
import epa.patiem.ticketbooking.repository.sql.SqlUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SqlTicketService {

    private final SqlTicketRepository repository;

    public List<SqlTicket> getAll() {
        return (List<SqlTicket>) repository.findAll();
    }
}
