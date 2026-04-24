# 🚀 JDBC Employee Management System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-blue?style=for-the-badge)

---

## 📌 Overview

A **console-based Employee Management System** built using **Java JDBC and MySQL**.  
It performs full **CRUD operations**, supports **batch processing**, and includes **analytical queries** like max salary and oldest employee.

---

## ✨ Features

- ➕ Add Employee  
- 📋 Display All Employees  
- ✏️ Update Employee  
- ❌ Delete Employee  
- ⚡ Batch Insert Employees  
- 💰 Find Employee with Maximum Salary  
- 🎂 Find Oldest Employee  

---

## 🧠 Tech Stack

- **Language:** Java  
- **Database:** MySQL  
- **Connectivity:** JDBC  

---

## 📂 Project Structure

```
JDBC-Employee-System/
│
├── EmployeeApp.java
├── README.md
└── .gitignore
```

---

## ⚙️ Setup & Run

### 1️⃣ Compile

```bash
javac -cp ".;mysql-connector-j-9.6.0.jar" EmployeeApp.java
```

### 2️⃣ Run

```bash
java -cp ".;mysql-connector-j-9.6.0.jar" EmployeeApp
```

---

## 🗄️ Database Setup

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
```

---

## 🧪 Sample Output

```
===== Employee System =====
1. Add Employee
2. Display All
3. Update Employee
...
```

---

## 📈 Key Highlights

- Uses **PreparedStatement** → prevents SQL injection  
- Implements **batch processing** → efficient inserts  
- Clean modular design using **JDBC best practices**  
- Covers both **CRUD + analytical queries**

---

## 🎯 Use Case

Ideal for:
- Learning **JDBC fundamentals**
- Practicing **database-driven applications**
- Academic projects and lab assignments  

---

## 👨‍💻 Author

Your Name  
🔗 GitHub: https://github.com/YOUR_USERNAME  

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
