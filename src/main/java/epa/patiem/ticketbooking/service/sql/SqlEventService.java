package epa.patiem.ticketbooking.service.sql;

import epa.patiem.ticketbooking.model.sql.SqlEvent;
import epa.patiem.ticketbooking.repository.sql.SqlEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SqlEventService {

    private final SqlEventRepository repository;

    public List<SqlEvent> getAll() {
        return (List<SqlEvent>) repository.findAll();
    }
}
