DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  salary NUMBER
);