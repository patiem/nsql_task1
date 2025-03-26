package epa.patiem.ticketbooking.service;

import epa.patiem.ticketbooking.model.mongo.UserAccount;

import java.math.BigDecimal;

public interface UserAccountService {

    UserAccount refillAccount(long userId, BigDecimal money);
}
