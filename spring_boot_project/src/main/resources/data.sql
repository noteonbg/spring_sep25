-- Password for both users is: password (BCrypt-hashed)
INSERT INTO cuser(id, username, email, password, role) VALUES
(1, 'admin', 'admin@example.com', '$2a$12$AmSfq5Ot5d8sPG.pCCBLoedUvuIpKPPfh/gFfV1fD81/VL8X18rza', 'ROLE_ADMIN'),
(2, 'user1', 'user1@example.com', '$2a$12$AmSfq5Ot5d8sPG.pCCBLoedUvuIpKPPfh/gFfV1fD81/VL8X18rza', 'ROLE_USER');

-- Sample investments for user1
INSERT INTO investment(id, investment_type, asset_name, amount_invested, current_value, date_of_investment, maturity_date, user_id) VALUES
(1, 'Stock', 'Tesla Inc', 1000.00, 1500.00, '2024-01-01', '2026-01-01', 2),
(2, 'Mutual Fund', 'Vanguard S&P 500', 2000.00, 2500.00, '2023-06-15', '2028-06-15', 2);


delete from aadhaar_card;
delete from citizen;


INSERT INTO citizen (id, name, age, gender) VALUES
(1, 'Suresh Reddy', 42, 'Male'),
(2, 'Priya Nair', 29, 'Female');

-- Aadhaar Cards
INSERT INTO aadhaar_card (aadhaar_number, citizen_id) VALUES
('123456789012', 1),
('987654321098', 2);


-- Insert pharmacies
INSERT INTO pharmacy (id, name, location) VALUES
(1, 'Apollo Pharmacy', 'Mumbai'),
(2, 'MedPlus', 'Hyderabad'),
(3, '1MG', 'Bengaluru');

-- Insert medicines
INSERT INTO medicine (name, price, pharmacy_id) VALUES
('Paracetamol', 25.00, 1),
('Amoxicillin', 38.50, 1),
('Dolo 650', 18.00, 2),
('Cetrizine', 15.00, 2),
('Azithromycin', 60.00, 3),
('Metformin', 22.00, 3);

--password123 is the password--
INSERT INTO hospitalstaff(username, password, role)
VALUES ('doctor1', '$2a$12$6QPDaJrGOAm5x.8nGuK3sODKQLgnjFsn6IQaW35Jc2pevvO7O2OMe', 'ROLE_USER');