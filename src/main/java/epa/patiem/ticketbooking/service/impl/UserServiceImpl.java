package epa.patiem.ticketbooking.service.impl;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import epa.patiem.ticketbooking.model.mongo.User;
import epa.patiem.ticketbooking.repository.mongo.UserRepository;
import epa.patiem.ticketbooking.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    private ObjectId idToObjectId(String id) {
        return new ObjectId(id);
    }
}
