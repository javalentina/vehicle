CREATE TABLE IF NOT EXISTS vehicle
(
    id      SERIAL PRIMARY KEY,
    cost    NUMERIC(10, 2) NOT NULL,
    year    INTEGER        NOT NULL,
    mileage NUMERIC(20, 2) NOT NULL,
    vehicle_model_id INT REFERENCES vehicle_model (id)
);



CREATE TABLE IF NOT EXISTS vehicle_model
(
    id               SERIAL PRIMARY KEY,
    body_type        VARCHAR(255)   NOT NULL,
    name             VARCHAR(255)   NOT NULL,
    tank_capacity    NUMERIC(10, 2) NOT NULL,
    seating_capacity INT            NOT NULL
);