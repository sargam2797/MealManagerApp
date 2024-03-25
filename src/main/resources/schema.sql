CREATE TABLE IF NOT EXISTS MEAL
(
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR     NOT NULL,
    type VARCHAR(10) NOT NULL check (type in ('BREAKFAST', 'LUNCH', 'DINNER'))
);

