package epa.patiem.ticketbooking.service.sql;

import epa.patiem.ticketbooking.model.sql.SqlUser;
import epa.patiem.ticketbooking.repository.sql.SqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlUserService {

    @Autowired
    private SqlUserRepository userRepository;

    public List<SqlUser> getAll() {
        return (List<SqlUser>) userRepository.findAll();
    }
}
