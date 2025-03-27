package epa.patiem.ticketbooking.repository.mongo;

import epa.patiem.ticketbooking.model.aggregation.TicketCountByCategory;
import epa.patiem.ticketbooking.model.aggregation.TicketCountByEvent;
import epa.patiem.ticketbooking.model.mongo.Ticket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, ObjectId> {

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$category', 'count': { '$sum': 1 } } }",
            "{ '$project': { 'category': '$_id', 'count': 1, '_id': 0 } }"
    })
    List<TicketCountByCategory> countTicketsByCategory();

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$event', 'count': { '$sum': 1 } } }",
            "{ '$project': { 'event': '$_id', 'count': 1, '_id': 0 } }"
    })
    List<TicketCountByEvent> countTicketsByEvent();
}
