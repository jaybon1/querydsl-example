INSERT INTO `PRODUCT_KIND` (`id`, `name`)
VALUES (1, '아이스크림'),
       (2, '과자'),
       (3, '라면');

INSERT INTO `PRODUCT_MAKER` (`id`, `name`)
VALUES (1, '해태'),
       (2, '롯데'),
       (3, '농심'),
       (4, '팔도');

INSERT INTO `PRODUCT` (`name`, `is_discount`, `price`, `discount_price`, `product_kind_id`, `product_maker_id`, `stock`)
VALUES ('누가바', false, 1000, 500, 1, 1, 9),
       ('폴라포', true, 1000, 500, 1, 1, 25),
       ('부라보콘', false, 1500, 1000, 1, 1, 15),

       ('죠스바', false, 1000, 500, 1, 2, 12),
       ('스크류바', false, 1000, 500, 1, 2, 16),
       ('월드콘', true, 1500, 1000, 1, 2, 7),

       ('새우깡', false, 1100, 700, 2, 3, 5),
       ('오징어집', false, 1100, 800, 2, 3, 8),
       ('포스틱', true, 1100, 900, 2, 3, 15),

       ('꼬깔콘', false, 900, 600, 2, 2, 9),
       ('콘칲', true, 1000, 800, 2, 2, 20),
       ('치토스', false, 1100, 900, 2, 2, 6),

       ('신라면', false, 850, 480, 3, 3, 21),
       ('짜파게티', false, 900, 600, 3, 3, 25),
       ('너구리', true, 850, 550, 3, 3, 51),

       ('해물라면', true, 900, 510, 3, 4, 49),
       ('팔도비빔면', false, 750, 600, 3, 4, 0),
       ('참깨라면', false, 800, 550, 3, 4, 23),

       (null, true, 900, 510, 1, 2, 0),
       (null, false, 750, 600, 2, 1, 0),
       (null, false, 800, 550, 3, 4, 0);



