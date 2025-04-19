# Student Management System

A simple Java-based Student Management System that uses JDBC to interact with a MySQL database for storing and managing student records.

---

## 📋 Features

- **Add Students**: Add new student records with PRN, name, branch, batch, and CGPA  
- **Display Students**: View all student records stored in the database  
- **Delete Students**: Remove student records by PRN  
- **Update Students**: Modify existing student information  
- **Search Functionality**:
  - Search by **PRN** for exact matches
  - Search by **Name** for partial matches

---

## 🛠 Requirements

- Java Development Kit (JDK) 8 or higher  
- MySQL Server  
- MySQL Connector/J (JDBC driver)  

---

## ⚙️ Setup

### 1. Database Configuration

Create a MySQL database and execute the following SQL command to create the `student` table:

```sql
CREATE TABLE student (
  PRN INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  branch VARCHAR(50),
  batch VARCHAR(20),
  cgpa FLOAT
);
```

### 2. Update Database Credentials

Open `StudentOperations.java` and update the following constants with your MySQL database details:

```java
private static final String URL = "jdbc:mysql://localhost:3306/your_database";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

---

## ▶️ Compile and Run

Compile the Java files:

```bash
javac *.java
```

Run the program:

```bash
java Main
```

---

## 🧭 Usage

When you run the program, a menu appears with the following options:

- **Add Student** - Enter student details to add a new record  
- **Display Students** - View all student records in the database  
- **Delete Student** - Remove a student record using their PRN  
- **Update Student** - Modify a student's information using their PRN  
- **Search by PRN** - Find a student using their unique PRN  
- **Search by Name** - Find students with matching name patterns  
- **Exit** - Terminate the program  

---

## 🗂 Project Structure

```
StudentManagementSystem/
├── Main.java                // Main menu and program flow
├── StudentOperations.java   // CRUD and search operations using JDBC
```

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
