--copy from test folder

insert into users (name, email)  values ('Alan', 'alan@gmail.com'),
                         ('Kate', 'kate@gmail.com'),
                         ('Max', 'max@gmail.com'),
                         ('Sara', 'sara@gmail.com'),
                         ('Alex', 'alex@gmail.com'),
                         ('Alex', 'anotheralex@gmail.com');

insert into events (title, date, ticket_price) values ('First sqlEvent', '2022-05-18 15:30', 100.0),
                          ('Second sqlEvent', '2022-05-15 21:00', 300.0),
                          ('Third sqlEvent', '2022-05-16 12:00', 500.0),
                          ('Fourth sqlEvent', '2022-05-15 21:00', 450.0),
                          ('Third sqlEvent', '2022-05-25 9:10', 1000.0),
                          ('Fifth sqlEvent', '2022-06-1 14:20', 230.0);

insert into tickets (user_id, event_id, place, category) values (1, 1, 10, 'BAR'),
                           (4, 3, 2, 'PREMIUM'),
                           (2, 2, 4, 'STANDARD'),
                           (1, 4, 20, 'BAR'),
                           (5, 1, 11, 'PREMIUM'),
                           (3, 5, 1, 'STANDARD');

insert into user_accounts (user_id, money) values (1, 1000.0),
                                 (2, 1500.0);