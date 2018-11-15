-- user_role data
insert into user_role (user_role_id, user_role_name) values (1, 'USER');
insert into user_role (user_role_id, user_role_name) values (2, 'ADMIN');
insert into user_role (user_role_id, user_role_name) values (3, 'GOD');

-- user data
insert into user (user_id, user_password, user_name, user_salt, user_role_id) VALUES (1, 'userPassword', 'firstUser', 'userSalt', 1);
insert into user (user_id, user_password, user_name, user_salt, user_role_id) VALUES (2, 'adminPassword', 'secondUser', 'adminSalt', 2);

-- product data
insert into product (product_id, product_name) values (1, 'firstProduct');
insert into product (product_id, product_name) values (2, 'secondProduct');

-- user status
insert into status (status_id, status_name) VALUES (1, 'active_status1');
insert into status (status_id, status_name) VALUES (2, 'active_status2');

--contact data
insert into contact (contact_id, contact_name, contact_phone,  contact_email) values (1, 'First', '+380667464646', 'gazeta@gmail.com');
insert into contact (contact_id,  contact_name, contact_phone, contact_email) values (2, 'Second', '+380509387132', 'lenta@gmail.com');

-- lead
 insert into lead (lead_id, lead_name, lead_creation_time, lead_comments, lead_contact_id, lead_user_id, lead_product_id, lead_status_id)
 values (1, 'First ContactLeads', '2018-11-01T21:42:32+00:00', 'Comments', 1, 1, 1, 1);

insert into lead (lead_id, lead_name, lead_creation_time, lead_comments, lead_contact_id, lead_user_id, lead_product_id, lead_status_id)
 values (2, 'First2 ContactLeads', '2018-11-01T21:42:32+00:00', 'Comments2', 1, 1, 1, 1);

insert into lead (lead_id, lead_name, lead_creation_time, lead_comments, lead_contact_id, lead_user_id, lead_product_id, lead_status_id)
 values (3, 'Second ContactLeads', '2018-11-01T21:42:32+00:00', 'Comments3', 2, 2, 2, 2);
