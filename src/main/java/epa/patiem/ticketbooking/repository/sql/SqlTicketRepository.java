package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.mongo.Category;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import epa.patiem.ticketbooking.model.sql.SqlCategory;
import epa.patiem.ticketbooking.model.sql.SqlTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTicketRepository extends CrudRepository<SqlTicket, Long> {

    Page<SqlTicket> getAllByUserId(Pageable pageable, Long userId);

    Page<SqlTicket> getAllByEventId(Pageable pageable, Long eventId);

    Boolean existsByEventIdAndPlaceAndCategory(Long eventId, Integer place, SqlCategory category);
}
