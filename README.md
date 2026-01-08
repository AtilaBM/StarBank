# 🏦 Star Bank

Star Bank is a **study project** created to practice **Java OOP** concepts.
It is a simple banking system that runs in the terminal (CLI) and simulates basic bank operations.


---

## 🚀 What this project does

* Create saving and checking accounts
* Deposit and withdraw money
* Transfer money between accounts
* View account information
* Change account information
* Close accounts

---

## 🧠 Concepts practiced

* Object-Oriented Programming (OOP)

  * Abstraction
  * Encapsulation
  * Inheritance
  * Polymorphism

* Separation of responsibilities

  * Model
  * Service
  * View (CLI)
* Basic validations and business rules

---

## 🗂 Project structure

The project is organized to keep responsibilities clear:

* **model** → domain entities (Account, Client, etc.)
* **service** → business logic and rules
* **view** → menus and user interaction (CLI)
* **enums** → fixed values like account status and category

---

## 🏦 Account types

### Savings Account

* Designed to store money
* Has interest rate
* Limited number of withdrawals

### Checking Account

* Designed for daily use
* Withdrawal fee
* Daily withdrawal limit

---

## ▶️ How to run

Compile the project and run the main class:

```bash
javac -d bin src/main/java/com/atila/**/*.java src/main/java/com/atila/*.java
java -cp bin com.atila.Main
```

---

## 🛠 Technologies used

* Java 17+
* Pure Java (no frameworks)
* Command Line Interface (CLI)

---

📚 *Personal study project to improve Java and OOP skills.*
