package epa.patiem.ticketbooking.controller;

import epa.patiem.ticketbooking.model.mongo.User;
import epa.patiem.ticketbooking.model.sql.SqlUser;
import epa.patiem.ticketbooking.service.UserService;
import epa.patiem.ticketbooking.service.sql.SqlUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UserService mongoUserService;
    private final SqlUserService sqlUserService;

    @GetMapping("/sql")
    public List<SqlUser> getAllSqlUsers() {
        return sqlUserService.getAll();
    }

    @GetMapping("/mongo")
    public List<User> getAllMongoUsers() {
        return mongoUserService.getAll();
    }

}
