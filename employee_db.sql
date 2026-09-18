CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employee(
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(50)NOT NULL,
    designation VARCHAR(50)NOT NULL,
    salary FLOAT NOT NULL,
    department VARCHAR(50)
);

INSERT INTO employee(emp_name,designation,salary,department)VALUES
('jhon doe','manager',75000,'HR'),
('priya','engineer',55000,'IT'),
('kumar','analyst',50000,'Finance'),
('anita','techinician',40000,'operation'),
('teja','tester',200000,NULL);

SELECT *FROM employee;


