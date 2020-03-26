insert into roles (rolename) values ('ROLE_ADMIN'); 
insert into roles (rolename) values ('ROLE_USER');
insert into usuarios(username,password) values ('dbuser1', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi');
insert into usuarios(username,password) values ('dbadmin1', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi');
insert into usuariorol (userid, rolid) values (1, 2); 
insert into usuariorol (userid, rolid) values (2, 1);
