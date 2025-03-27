package epa.patiem.ticketbooking.service.impl;

import epa.patiem.ticketbooking.model.mongo.User;
import epa.patiem.ticketbooking.repository.mongo.UserRepository;
import epa.patiem.ticketbooking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
