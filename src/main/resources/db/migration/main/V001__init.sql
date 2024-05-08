CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES categories(id)
);

CREATE TABLE shops (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    address VARCHAR(255),
    category_id INT,
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6),
    phone VARCHAR(20),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE shop_home_images (
    id SERIAL PRIMARY KEY,
    shop_id INT,
    image_url VARCHAR(255),
    weight INT,
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE shop_intro_images (
    id SERIAL PRIMARY KEY,
    shop_id INT,
    image_url VARCHAR(255),
    weight INT,
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE shop_recommendations (
    id SERIAL PRIMARY KEY,
    shop_id INT,
    weight INT,
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);
CREATE TABLE activities (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    shop_id INT,
    weight INT,
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE activity_images (
    id SERIAL PRIMARY KEY,
    activity_id INT,
    image_url VARCHAR(255),
    weight INT,
    FOREIGN KEY (activity_id) REFERENCES activities(id)
);
