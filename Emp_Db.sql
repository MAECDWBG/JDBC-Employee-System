CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;

CREATE TABLE IF NOT EXISTS employees (
    eno INT PRIMARY KEY,
    ename VARCHAR(50),
    salary DOUBLE,
    dept VARCHAR(50),
    gender VARCHAR(10),
    dob DATE
);