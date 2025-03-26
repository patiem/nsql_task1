package epa.patiem.ticketbooking.service.sql;

import epa.patiem.ticketbooking.model.sql.SqlEvent;
import epa.patiem.ticketbooking.repository.sql.SqlEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlEventService {

    @Autowired
    private SqlEventRepository repository;

    public List<SqlEvent> getAll() {
        return (List<SqlEvent>) repository.findAll();
    }
}
