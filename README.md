# JDBC Employee Management System

A console-based Employee Management System built using Java JDBC and MySQL.

## 🚀 Features
- Add Employee
- Update Employee
- Delete Employee
- Display Employees
- Batch Insert
- Find Employee with Maximum Salary
- Find Oldest Employee (Max Age)

## 🛠️ Tech Stack
- Java
- JDBC
- MySQL

## ⚙️ Setup Instructions

### 1. Create Database
```sql
CREATE DATABASE employee_management;
USE employee_management;

CREATE TABLE employees (
    eno INT PRIMARY KEY,
    ename VARCHAR(50),
    salary DOUBLE,
    dept VARCHAR(50),
    gender VARCHAR(10),
    dob DATE
);