# 🛒 Online Shopping Center

The **Online Shopping Center** is a Java-based web application designed for **both Admin and Customer modules**, providing complete **CRUD operations** across product management, user authentication, and shopping workflows.  
The project is built using **Core & Advanced Java**, applying OOP principles like **encapsulation, inheritance, and abstraction** to create clean, modular components.

The backend uses **Servlets, JSP, and JDBC** implemented under a clean **MVC + DAO architecture**, enabling secure data handling, session-based authentication, and real-time product updates through optimized SQL queries in an Oracle Database.

---

## 📁 Project Structure

src/main/java/com.pack1/
│
├── dao/ # DAO Layer – DB operations
│ ├── AdminDAO.java
│ ├── CustomerDAO.java
│ └── ProductDAO.java
│
├── model/ # JavaBeans (OOP models)
│ ├── AdminBean.java
│ ├── CustomerBean.java
│ └── ProductBean.java
│
├── servlet/ # Controllers
│ ├── admin/
│ │
│ └── customer/
│
└── util/
  ├── DBconnect.java
  └── DBInfo.java

src/main/webapp/
│
├── admin/ # Admin UI Views
├── customer/ # Customer UI Views 
│
├── META-INF/
├── WEB-INF/
│ └── web.xml
│
└── index.html


---

## 🛠️ Technologies Used

- **Java (Core + Advanced)**
- **Java Servlets**
- **JSP (Java Server Pages)**
- **JDBC**
- **Oracle Database**
- **HTML, CSS**
- **MVC Architecture**
- **DAO Pattern**
- **Apache Tomcat**
