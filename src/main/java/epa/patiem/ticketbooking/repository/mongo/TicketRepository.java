package epa.patiem.ticketbooking.repository.mongo;

import epa.patiem.ticketbooking.model.mongo.Category;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, ObjectId> {

    Page<Ticket> getAllByUserId(Pageable pageable, Long userId);

    Page<Ticket> getAllByEventId(Pageable pageable, Long eventId);

    Boolean existsByEventIdAndPlaceAndCategory(ObjectId eventId, Integer place, Category category);
}
