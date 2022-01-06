-- Populates categories table
insert into categories values (DEFAULT, 'French');
insert into categories values (DEFAULT, 'Japanese');
insert into categories values (DEFAULT, 'Indian');
insert into categories values (DEFAULT, 'Caribbean');
insert into categories values (DEFAULT, 'Vietnamese');
insert into categories values (DEFAULT, 'Korean');
insert into categories values (DEFAULT, 'Italian');
insert into categories values (DEFAULT, 'Greek');
insert into categories values (DEFAULT, 'Chinese');
insert into categories values (DEFAULT, 'Mexican');
insert into categories values (DEFAULT, 'Peruvian');

-- Populates restaurants table
-- French
insert into restaurants values (DEFAULT, 'Brooklyn', 'Levant on Smith', 'NY', '320 Atlantic Ave', '11201', (select id from categories where name = 'French'));
insert into restaurants values (DEFAULT, 'Brooklyn', 'Chez Oskar', 'NY', '310 Malcolm X Blvd', '11233', (select id from categories where name = 'French'));
-- Japanese
insert into restaurants values (DEFAULT, 'Brooklyn', 'Chikurin', 'NY', '2362 86th St', '11214', (select id from categories where name = 'Japanese'));
insert into restaurants values (DEFAULT, 'Manhattan', 'Dainobu', 'NY', '498 6th Ave', '10011', (select id from categories where name = 'Japanese'));
-- Italian
insert into restaurants values (DEFAULT, 'Brooklyn', 'Luigis Pizza', 'NY', '4704 5th Ave', '11220', (select id from categories where name = 'Italian'));
insert into restaurants values (DEFAULT, 'Staten Island', 'La Fontana Italian Restaurant', 'NY', '2879 Amboy Rd', '10306', (select id from categories where name = 'Italian'));
-- Mexican
insert into restaurants values (DEFAULT, 'Brooklyn', 'Tacombi', 'NY', '242 Metropolitan Ave', '11211', (select id from categories where name = 'Mexican'));
-- Peruvian
insert into restaurants values (DEFAULT, 'Queens', 'Pio Pio', 'NY', '84-21 Northern Blvd', '11370', (select id from categories where name = 'Peruvian'));

-- Populates users table
insert into users values (DEFAULT, 'iammichelle@madeup.com','Michelle', 'Lucero');
insert into users values (DEFAULT, 'jd@madeup.com', 'John', 'Doe');
insert into users values (DEFAULT, 'mw@madeup.com', 'Mike', 'Who');
insert into users values (DEFAULT, 'maizik0@slideshare.net', 'Minnaminnie', 'Aizik');
insert into users values (DEFAULT, 'doteague1@zdnet.com', 'Donielle', 'O''Teague');
insert into users values (DEFAULT, 'bsilversmidt2@salon.com', 'Bernhard', 'Silversmidt');
insert into users values (DEFAULT, 'acardoo3@cbsnews.com', 'Ardith', 'Cardoo');
insert into users values (DEFAULT, 'fsealy4@businessinsider.com', 'Fayth', 'Sealy');
insert into users values (DEFAULT, 'cfayerman5@fc2.com', 'Clayborn', 'Fayerman');
insert into users values (DEFAULT, 'jbordes6@salon.com', 'Joe', 'Bordes');
insert into users values (DEFAULT, 'scastilla7@free.fr', 'Shelba', 'Castilla');
insert into users values (DEFAULT, 'mkuhn8@ucoz.com', 'Mariska', 'Kuhn');
insert into users values (DEFAULT, 'emcguinness9@homestead.com', 'Earl', 'McGuinness');
insert into users values (DEFAULT, 'lcondicta@illinois.edu', 'Louisette', 'Condict');
insert into users values (DEFAULT, 'jdunsfordb@nydailynews.com', 'Jobi', 'Dunsford');
insert into users values (DEFAULT, 'dreekenc@fema.gov', 'Dulcia', 'Reeken');
insert into users values (DEFAULT, 'gluciend@sbwire.com', 'Gustie', 'Lucien');
insert into users values (DEFAULT, 'dbehnee@virginia.edu', 'Daniele', 'Behne');

-- Windows Example for running the script
-- \i 'C:/Users/lucer/Desktop/dummy-data.sql';