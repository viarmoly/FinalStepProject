
-- user_role data
insert into user_role (user_role_id, user_role_name) values (1, 'USER');
insert into user_role (user_role_id, user_role_name) values (2, 'ADMIN');

-- user data
insert into user (user_id, user_password, user_name, user_salt, user_role_id) VALUES (1, 'userPassword', 'firstUser', 'userSalt', 1);
insert into user (user_id, user_password, user_name, user_salt, user_role_id) VALUES (2, 'adminPassword', 'secondUser', 'adminSalt', 2);
