package epa.patiem.ticketbooking.repository.mongo;

import epa.patiem.ticketbooking.model.mongo.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> getByEmail(String email);

    Page<User> getAllByName(Pageable pageable, String name);

    Boolean existsByEmail(String email);
}
