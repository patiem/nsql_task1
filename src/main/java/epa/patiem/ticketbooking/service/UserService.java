package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
//    User getUserById(String userId);
//    User getUserByEmail(String email);
//    List<User> getUsersByName(String name, int pageSize, int pageNum);
//    User createUser(User user);
//    User updateUser(User user);
//    boolean deleteUser(String userId);
}
