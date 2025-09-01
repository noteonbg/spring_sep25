-- create-table.sql
CREATE TABLE if not exists loans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    loan_type VARCHAR(100),
    principal_amount DOUBLE,
    interest_rate DOUBLE,
    loan_term INT
);

INSERT INTO loans (loan_type, principal_amount, interest_rate, loan_term) VALUES ('Home Loan', 50, 6.5, 10);
INSERT INTO loans (loan_type, principal_amount, interest_rate, loan_term) VALUES ('Personal Loan', 10, 7.5, 3);
