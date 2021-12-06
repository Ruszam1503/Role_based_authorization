INSERT INTO users ( user_name, email, password, enabled )
VALUES ( 'USER', 'user@yandex.ru', '1a', TRUE ),
       ( 'EDITOR', 'creator@yandex.ru', '1a', TRUE ),
       ( 'ADMIN', 'admin@gmail.com', '1a', TRUE)
;

INSERT INTO roles (role_name)
VALUES ('USER'),
       ('EDITOR'),
       ('ADMIN')
;

INSERT INTO products (product_name, category, price)
VALUES ('products 1' ,'1' , 10),
       ('products 2' ,'2' , 7 ),
       ('products 3','3' , 6 ),
       ('products 4','4' , 10 ),
       ('products 5','5' , 4 )
;

INSERT INTO users_roles (user_id, role_id)
VALUES (1,1),
       (2,2 ),
       (3,3)
;