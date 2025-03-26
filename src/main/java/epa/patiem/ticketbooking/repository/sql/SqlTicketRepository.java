package epa.patiem.ticketbooking.repository.sql;

import epa.patiem.ticketbooking.model.mongo.Category;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTicketRepository extends CrudRepository<Ticket, Long> {

    Page<Ticket> getAllByUserId(Pageable pageable, Long userId);

    Page<Ticket> getAllByEventId(Pageable pageable, Long eventId);

    Boolean existsByEventIdAndPlaceAndCategory(Long eventId, Integer place, Category category);
}
