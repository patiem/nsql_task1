package epa.patiem.ticketbooking.repository.mongo;

import epa.patiem.ticketbooking.model.aggregation.UserWithTicketCount;
import epa.patiem.ticketbooking.model.mongo.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Aggregation(pipeline = {
            "{ '$lookup': { 'from': 'tickets', 'localField': '_id', 'foreignField': 'user.$id', 'as': 'tickets' } }",
            "{ '$project': { 'name': 1, 'email': 1, 'ticketCount': { '$size': '$tickets' } } }",
            "{ '$sort': { 'ticketCount': -1 } }",
            "{ '$limit': 5 }"
    })
    List<UserWithTicketCount> findTopUsersByTicketCount();
}
