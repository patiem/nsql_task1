package epa.patiem.ticketbooking.repository.mongo;

import epa.patiem.ticketbooking.model.mongo.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, ObjectId> {
}
