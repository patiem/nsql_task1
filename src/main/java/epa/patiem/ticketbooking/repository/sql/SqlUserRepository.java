package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.sql.SqlUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SqlUserRepository extends CrudRepository<SqlUser, Long> {

    Optional<SqlUser> getByEmail(String email);
    Page<SqlUser> getAllByName(Pageable pageable, String name);
    Boolean existsByEmail(String email);
}
