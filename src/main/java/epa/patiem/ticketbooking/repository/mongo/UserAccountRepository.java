package epa.patiem.ticketbooking.repository.mongo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import epa.patiem.ticketbooking.model.mongo.UserAccount;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    Optional<UserAccount> findByUserId(Long userId);
}
