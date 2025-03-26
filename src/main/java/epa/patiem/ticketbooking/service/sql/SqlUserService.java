package epa.patiem.ticketbooking.service.sql;

import epa.patiem.ticketbooking.model.sql.SqlUser;
import epa.patiem.ticketbooking.repository.sql.SqlUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SqlUserService {

    private final SqlUserRepository userRepository;

    public List<SqlUser> getAll() {
        return (List<SqlUser>) userRepository.findAll();
    }
}
