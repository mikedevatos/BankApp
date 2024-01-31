DROP TABLE Account IF EXISTS;
CREATE TABLE Account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(19, 2), -- The size (19, 2) is just an example; adjust based on your precision needs
    currency VARCHAR(255), -- Adjust the size based on your currency needs
    created_at DATETIME
);
insert into Account(balance, currency, created_at) values (100.00, 'EUR', '2024-01-31 13:02:08.792');
insert into Account(balance, currency, created_at) values (200.00, 'EUR', '2024-01-31 13:02:08.793');
insert into Account(balance, currency, created_at) values (300.00, 'EUR', '2024-01-31 13:02:08.794');
insert into Account(balance, currency, created_at) values (200.00, 'EUR', '2024-01-31 13:02:08.795');