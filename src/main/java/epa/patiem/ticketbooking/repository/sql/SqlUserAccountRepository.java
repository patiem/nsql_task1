package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.sql.SqlUserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SqlUserAccountRepository extends CrudRepository<SqlUserAccount, Long> {

    Optional<SqlUserAccount> findByUserId(Long userId);
}
