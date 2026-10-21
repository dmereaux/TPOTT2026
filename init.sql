

-- Create table
CREATE TABLE IF NOT EXISTS clothes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    price REAL NOT NULL,
    popular BOOLEAN DEFAULT FALSE
);

-- Insert initial data
INSERT INTO clothes (name, price, popular) VALUES ('T-Shirt', 19.99, TRUE);
INSERT INTO clothes (name, price, popular) VALUES ('Jeans', 39.99, FALSE);
INSERT INTO clothes (name, price, popular) VALUES ('Jeans blue', 59.99, TRUE);
INSERT INTO clothes (name, price, popular) VALUES ('Jacket', 59.99, TRUE);
INSERT INTO clothes (name, price, popular) VALUES ('Sneakers', 29.99, FALSE);
