-- Table Schemas

DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS reservation_detail;
DROP TABLE IF EXISTS request;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS station;


CREATE TABLE station
(
    station_id      INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    station_name    VARCHAR(100)  NOT NULL,
    station_city    VARCHAR(50) NOT NULL,
    station_province VARCHAR(50) NOT NULL,
    station_address VARCHAR(250) NOT NULL
);

CREATE TABLE car
(
    car_id      INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    car_brand    VARCHAR(25) NOT NULL,
    car_model    VARCHAR(50)  NOT NULL
);

CREATE TABLE client
(
    client_id        INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    client_firstname VARCHAR(50)        NOT NULL,
    client_lastname  VARCHAR(50)        NOT NULL,
    client_gender    VARCHAR(10),
    client_age       INT DEFAULT 0,
    client_phone     VARCHAR(15),
    client_email     VARCHAR(25) UNIQUE NOT NULL,
    client_car_id    INT NOT NULL,
    FOREIGN KEY (client_car_id) REFERENCES car (car_id)
);

CREATE TABLE request
(
    request_id      INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    request_city VARCHAR(50) NOT NULL,
    request_province VARCHAR(50) NOT NULL,
    request_neighborhood VARCHAR(50) NOT NULL,
    request_client_id INT NOT NULL,
    FOREIGN KEY (request_client_id) REFERENCES client (client_id)
);

CREATE TABLE reservation_detail
(
    reservation_detail_id     INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    station_reservation_date DATE NOT NULL,
    station_id INT NOT NULL,
    FOREIGN KEY (station_id) REFERENCES station (station_id)
);

CREATE TABLE reservation
(
    reservation_id         INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    client_id                INT NOT NULL,
    reservation_detail_id    INT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client (client_id),
    FOREIGN KEY (reservation_detail_id) REFERENCES reservation_detail (reservation_detail_id)
);

-- ////////////////////////////////////////////////////////////////////////////
--  Sample static test values
-- ////////////////////////////////////////////////////////////////////////////
INSERT INTO station(station_name,station_city,station_province,station_address)
VALUES ('X Benzin İstasyonu', 'Istanbul','Pendik','Veli caddesi no:10'),
        ('B Oteli', 'Muğla','Fethiye','Manolya sokak no:5'),
        ('H Konutları', 'İstanbul','Gaziosmanpaşa','Sarıgöl mah'),
        ('X Evleri', 'Bursa','Nilüfer','Görükle mah');

INSERT INTO car(car_brand,car_model)
VALUES ('Volkswagen', 'e-Golf'),
       ('Tesla', 'Model X'),
       ('Hyundai', 'Ionic EV'),
       ('Smart', 'Fortwo Electric Drive'),
       ('Renault', 'Zoe');

INSERT INTO client(client_firstname,client_lastname,client_gender,client_age,client_phone,client_email,client_car_id)
VALUES ('Ali', 'Gümüş', 'male', 27, '905586986235', 'ali@gmail.com',3),
       ('Pınar', 'Özdil', 'female', 26, '905586986232', 'pinar@gmail.com',2),
       ('Ekin', 'Öztürk', 'female', 14, '905586986236', 'ekin@gmail.com',1),
       ('Furkan', 'Yılmaz', 'male', 25, '905586986238', 'furkan@gmail.com',4),
       ('Bihter', 'Belgi', 'female', 29, '905586986239', 'bihter@gmail.com',3),
       ('Lale', 'Koç', 'female', 55, '905586986231', 'lale@hotmail.com',2);

INSERT INTO request(request_city,request_province,request_neighborhood,request_client_id)
VALUES ('Istanbul','Pendik','Ahmet Yesevi',1),
       ('Muğla','Fethiye','Akarca',4),
       ('İstanbul','Gaziosmanpaşa','Yıldıztabya',2);

INSERT INTO reservation_detail(station_reservation_date,station_id)
VALUES ('2022-03-04 12:00:00',1),
       ('2022-03-04 12:30:00',1),
       ('2022-03-04 13:00:00',1),
       ('2022-03-04 13:30:00',1),
       ('2022-03-05 12:00:00',2),
       ('2022-03-05 12:30:00',2),
       ('2022-03-05 13:00:00',2),
       ('2022-03-06 15:30:00',2),
       ('2022-03-07 12:00:00',3),
       ('2022-03-08 12:30:00',3),
       ('2022-03-09 13:00:00',3),
       ('2022-03-10 14:30:00',3);

INSERT INTO reservation(client_id,reservation_detail_id)
VALUES (1, 1),
       (2,3),
       (3,4),
       (5,5),
       (6,10);

