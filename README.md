![EventureLogo](https://github.com/user-attachments/assets/e9cecf6e-be8f-48ea-8ff6-e0fb02031585)

# 🎟️ Eventure – Event Ticketing System

**Eventure** is a desktop-based event ticketing system built using **Java Swing** with **Microsoft SQL Server** as the backend. It enables event organizers to manage events and tickets, while allowing users to browse and book tickets through a clean and intuitive interface.

---

## 🚀 Features

- Event creation and management
- Ticket booking with availability tracking
- User registration and authentication
- Booking history and transaction records
- Persistent data storage using SQL Server

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Microsoft SQL Server
- JDBC
- Object-Oriented Programming (OOP)

---

## 🗃️ Database

Eventure uses a relational database to store:
- Users
- Events
- Tickets
- Bookings

SQL schema scripts are included in the repository.

---

## ⚙️ Setup & Configuration

### Prerequisites
- Java JDK 8 or higher
- Microsoft SQL Server
- SQL Server JDBC Driver

### Steps
1. Create a database (e.g., `ETS_DB`) in SQL Server.
2. Run the provided SQL scripts to generate tables.
3. Update the JDBC connection string in the application configuration:
   ```java
   jdbc:sqlserver://localhost;databaseName=ETS_DB
4. Compile and run the main application class.
