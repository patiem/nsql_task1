package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.sql.SqlEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SqlEventRepository extends CrudRepository<SqlEvent, Long> {

    Page<SqlEvent> getAllByTitle(Pageable pageable, String title);

    Page<SqlEvent> getAllByDate(Pageable pageable, Date day);

    Boolean existsByTitleAndDate(String title, Date date);
}
