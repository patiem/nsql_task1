package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.mongo.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SqlUserAccountRepository extends CrudRepository<UserAccount, Long> {

    Optional<UserAccount> findByUserId(Long userId);
}
