drop table if exists Cuser;
drop table if exists investment;

CREATE TABLE  Cuser (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE investment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    investment_type VARCHAR(100) NOT NULL,
    asset_name VARCHAR(100) NOT NULL,
    amount_invested DECIMAL(15, 2),
    current_value DECIMAL(15, 2),
    date_of_investment DATE,
    maturity_date DATE,
    user_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES Cuser(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS citizen (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS  aadhaar_card (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    aadhaar_number VARCHAR(12) NOT NULL,
    citizen_id BIGINT,
    CONSTRAINT fk_citizen FOREIGN KEY (citizen_id) REFERENCES citizen(id)
);



-- Table for Pharmacy
CREATE TABLE IF NOT EXISTS pharmacy (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

-- Table for Medicine
CREATE TABLE IF NOT EXISTS medicine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    pharmacy_id BIGINT,
    CONSTRAINT fk_pharmacy FOREIGN KEY (pharmacy_id) REFERENCES pharmacy(id) on delete cascade
);


CREATE TABLE IF NOT EXISTS hospitalstaff (
    username VARCHAR(100) NOT NULL PRIMARY KEY,
    password varchar(100) NOT NULL,
    role  varchar(100)
);
