# Employee Management Web Application

This project is a **Java Servlet + JSP Web Application** for managing employees.  
It has been refactored to use the **DAO (Data Access Object) Design Pattern** for cleaner separation of concerns.

---

## ✨ Features
- Add new employees  
- Edit employee details  
- Update employee information  
- Delete employees  
- DAO pattern for database operations  
- Centralized DB connection management  

---

## 📂 Project Structure
```
EmployeeWebApp/
│
├── src/main/java/
│   ├── dao/
│   │   ├── EmployeeDAO.java
│   │   └── EmployeeDAOImpl.java
│   ├── model/
│   │   └── Employee.java
│   ├── util/
│   │   └── DBConnection.java
│   ├── AddEmployeeServlet.java
│   ├── EditEmployeeServlet.java
│   ├── UpdateEmployeeServlet.java
│   └── DeleteEmployeeServlet.java
│
├── src/main/webapp/
│   ├── index.jsp
│   ├── add-employee.jsp
│   ├── edit-employee.jsp
│   └── WEB-INF/web.xml
│
└── README.md
```

---

## ⚙️ Technologies Used
- **Java 17+** (Servlet API – Jakarta EE for Tomcat 10+)  
- **JSP & Servlets** for frontend/backend  
- **DAO Pattern** for database access  
- **MySQL** as the database  
- **Apache Tomcat 10** as the server  

---

## 🗄 Database Setup
1. Create a database named `employee`
   ```sql
   CREATE DATABASE employee;
   USE employee;
   ```
2. Create the `emp` table:
   ```sql
   CREATE TABLE emp (
       id INT PRIMARY KEY AUTO_INCREMENT,
       firstName VARCHAR(100),
       lastName VARCHAR(100),
       salary DOUBLE,
       designation VARCHAR(100)
   );
   ```
3. Update your DB credentials in `util/DBConnection.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/employee";
   private static final String USER = "root";
   private static final String PASSWORD = "root";
   ```

---

## 🚀 Running the Application
1. Import the project into **Eclipse** or **IntelliJ** as a Maven/Java EE project.  
2. Add the **MySQL JDBC Driver (Connector/J)** to `WEB-INF/lib`.  
3. Deploy the app to **Apache Tomcat 10**.  
4. Visit:
   - Home: [http://localhost:8080/EmployeeWebApp/](http://localhost:8080/EmployeeWebApp/)  
   - Add Employee: `/add-employee.jsp`  
   - Edit Employee: `/edit-employee.jsp`  

---

## 📌 Notes
- Ensure Tomcat 10+ is used (Jakarta namespace).  
- DAO pattern helps keep Servlets clean and maintainable.  
- You can extend this project by adding authentication, search, and pagination features.  
