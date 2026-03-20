# ⚡ EaVy 2.0 – EV Charging Station Locator App

EaVy 2.0 is a mobile application developed as a final project for the *Programming for Mobile Devices* course. The app helps users locate electric vehicle (EV) charging stations through a map-based interface while supporting basic user account management using local database storage.

---

## 📌 Project Overview

This project enhances a previous prototype by integrating both front-end and back-end components to simulate a real-world mobile application. It includes user authentication, local data storage, and interactive navigation features.

The application aligns with **Sustainable Development Goal 13 (Climate Action)** by promoting EV usage and accessibility to charging stations. 

---

## 🚀 Features

### 🔐 User Authentication

* User registration (Create)
* Login validation (Read)
* Delete account functionality (Delete)
* *Update is simulated by deleting and re-registering*

### 🗺️ EV Charging Station Locator

* Map-based interface with station markers
* Display station details and locations
* Navigation and routing simulation

### 👤 User Profile

* Display registered username
* Logout functionality
* Delete account option

### ⚙️ Additional Pages

* About Us
* Help & Support
* Privacy Policy
* Contact Us

---

## 🛠️ Technologies Used

* **Android Studio** – Development environment
* **Java** – Application logic and backend implementation
* **XML** – UI layout design
* **SQLite** – Local database for data storage

---

## 🧠 System Architecture

The application follows a simple layered architecture:

* **UI Layer** → Activities (Login, Register, Home, Map)
* **Data Access Layer** → `UserDao.java`
* **Database Layer** → `DBHelper.java`
* **Database** → SQLite (`eavy.db`)

👉 User input flows from UI → DAO → Database → Response back to UI 

---

## 📂 Key Components

* `DBHelper.java` – Handles database creation and structure
* `UserDao.java` – Manages CRUD operations
* `XML Layouts` – UI design for all screens
* `Activities` – Handle user interaction and navigation

---

## 🔄 CRUD Implementation

| Operation | Implementation                     |
| --------- | ---------------------------------- |
| Create    | User registration                  |
| Read      | Login validation & profile display |
| Update    | Simulated via delete & re-register |
| Delete    | Delete account function            |

---

## ⚙️ How to Run

1. Open project in Android Studio
2. Sync Gradle and build project
3. Run on emulator or Android device
4. Register a new account and explore features

---

## 🎯 Project Purpose

This project demonstrates:

* Integration of frontend (XML UI) and backend (Java + SQLite)
* Implementation of CRUD operations in mobile apps
* Basic authentication system
* Local data persistence without internet dependency

---

## ⚠️ Limitations

* No real-time API or cloud database
* Update function not fully implemented
* Data stored locally (removed when app is uninstalled)

---

## ✨ Future Improvements

* Implement full update functionality
* Integrate Firebase or cloud database
* Improve UI/UX design and responsiveness
* Add real-time navigation with APIs

---

## 📎 Demo & Resources

🎥 Demo Video:
https://drive.google.com/file/d/1Y8JHvHDLYJVUKLZzv33jm0yi_qQMx_nQ/view

💻 GitHub Repository:
https://github.com/khinphyucinhtet/EaVy2.0

---

## 👥 Team Members

* Khin Phyu Cin Htet
* Ahmad Danyal Bin Mustapha
* Koh Ju Ping

---

## 🏁 Conclusion

EaVy 2.0 successfully demonstrates a functional mobile application prototype with integrated front-end and back-end logic, achieving a Technology Readiness Level (TRL) of approximately 2–3. 

---
