CREATE TABLE IF NOT EXISTS vehicle
(
    id               SERIAL PRIMARY KEY,
    cost             NUMERIC(10, 2) NOT NULL,
    year             INTEGER        NOT NULL,
    mileage          NUMERIC(20, 2) NOT NULL,
    vehicle_model_id INT REFERENCES vehicle_model (id) ON DELETE SET NULL ON UPDATE CASCADE,
    enterprise_id    INT REFERENCES enterprise (id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS vehicle_model
(
    id               SERIAL PRIMARY KEY,
    body_type        VARCHAR(255)   NOT NULL,
    name             VARCHAR(255)   NOT NULL,
    tank_capacity    NUMERIC(10, 2) NOT NULL,
    seating_capacity INT            NOT NULL
);
CREATE TABLE IF NOT EXISTS enterprise
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    city       VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS driver
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(255)   NOT NULL,
    salary NUMERIC(10, 2) NOT NULL,
    enterprise_id    INT REFERENCES enterprise (id) ON DELETE SET NULL ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS driverTask(
    id     SERIAL PRIMARY KEY,
    vehicle_id INT REFERENCES vehicle (id),
    driver_id  INT REFERENCES driver (id) ON DELETE SET NULL ON UPDATE CASCADE,
    is_active BOOLEAN
);
ALTER TABLE vehicle ADD COLUMN enterprise_id INT REFERENCES enterprise (id);
ALTER TABLE enterprise DROP COLUMN vehicle_id;
ALTER TABLE enterprise DROP COLUMN driver_id;
ALTER TABLE driver ADD COLUMN enterprise_id    INT REFERENCES enterprise (id) ON DELETE SET NULL ON UPDATE CASCADE;

