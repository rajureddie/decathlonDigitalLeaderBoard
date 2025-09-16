DROP TABLE IF EXISTS order_history;
DROP TABLE IF EXISTS teammate;

CREATE TABLE teammate (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    daily_orders INT NOT NULL,
    monthly_orders INT NOT NULL,
    photo_url VARCHAR(255)
);

CREATE TABLE order_history (
    id BIGSERIAL PRIMARY KEY,
    teammate_id BIGINT NOT NULL,
    teammate_name VARCHAR(100) NOT NULL,
    daily_orders INT NOT NULL,
    monthly_orders INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (teammate_id) REFERENCES teammate(id)
);
