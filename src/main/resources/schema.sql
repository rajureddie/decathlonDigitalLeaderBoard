-- Drop old tables if exist
DROP TABLE IF EXISTS order_history;
DROP TABLE IF EXISTS teammate;

-- Teammate table
CREATE TABLE teammate (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    daily_orders INT NOT NULL,
    monthly_orders INT NOT NULL,
    photo_url VARCHAR(255)
);

-- Order history table
CREATE TABLE order_history (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    teammate_id BIGINT NOT NULL,
    teammate_name VARCHAR(100) NOT NULL,
    daily_orders INT NOT NULL,
    monthly_orders INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (teammate_id) REFERENCES teammate(id)
);
