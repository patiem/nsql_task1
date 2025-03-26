package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
}
