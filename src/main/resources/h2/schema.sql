-- DROP TABLE IF EXISTS PRODUCT;
-- CREATE TABLE PRODUCT (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NULL,
--     is_discount BIT(1) NOT NULL DEFAULT false,
--     price INT NOT NULL,
--     discount_price INT NOT NULL,
--     product_kind_id INT,
--     product_maker_id INT,
--     stock INT
-- );
--
-- DROP TABLE IF EXISTS PRODUCT_KIND;
-- CREATE TABLE PRODUCT_KIND (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL
-- );
--
-- DROP TABLE IF EXISTS PRODUCT_MAKER;
-- CREATE TABLE PRODUCT_MAKER (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL
-- );