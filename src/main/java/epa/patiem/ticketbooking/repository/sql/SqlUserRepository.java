package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.mongo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SqlUserRepository extends CrudRepository<User, Long> {

    Optional<User> getByEmail(String email);

    Page<User> getAllByName(Pageable pageable, String name);

    Boolean existsByEmail(String email);
}
