package epa.patiem.ticketbooking.service.converter;

import epa.patiem.ticketbooking.model.mongo.User;
import epa.patiem.ticketbooking.model.mongo.UserAccount;
import epa.patiem.ticketbooking.model.sql.SqlUser;
import epa.patiem.ticketbooking.model.sql.SqlUserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final TicketConverter ticketConverter;

    public List<User> convert(List<SqlUser> users) {
        return users.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private User convert(SqlUser sqlUser) {
        User user = getUser(sqlUser);
        setTickets(sqlUser, user);
        return user;
    }

    private User getUser(SqlUser sqlUser) {
        return User.builder()
                .name(sqlUser.getName())
                .email(sqlUser.getEmail())
                .account(convertAccount(sqlUser))
                .build();
    }

    private void setTickets(SqlUser sqlUser, User user) {
        user.setTickets(
                sqlUser.getTickets().stream()
                        .map(ticketConverter::convert)
                        .collect(Collectors.toList())
        );
    }

    private UserAccount convertAccount(SqlUser sqlUser) {
        BigDecimal money = Optional.ofNullable(sqlUser)
                .map(SqlUser::getUserAccount)
                .map(SqlUserAccount::getMoney)
                .orElse(BigDecimal.ZERO);
        return new UserAccount(money);
    }
}