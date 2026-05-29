# 👨‍💼 Employee Management System

A full-stack **Employee Management System** built with **Spring Boot 3.5 & Java 17**.  
Supports role-based access for Admins and Employees with a clean MVC architecture.

---

## 🚀 Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot 3.5 |
| Web Layer | Spring MVC |
| Database | MySQL, Spring Data JPA (Hibernate) |
| Frontend | Thymeleaf, HTML5, CSS3, Bootstrap 5 |
| Build Tool | Maven |
| Server | Embedded Tomcat (Spring Boot) |

---

## ✨ Features

### 🔐 Authentication
- User **Register** with email, password, department & mobile
- Secure **Login / Logout** with session management
- Email duplication check on registration
- Role-based redirect — ADMIN → Admin Dashboard, EMPLOYEE → Employee Dashboard

### 🛠️ Admin
- View all registered employees in a dashboard table
- **Add** new employees with department assignment
- **Delete** any employee by ID
- Edit own admin profile (name, mobile)

### 👤 Employee
- View personal profile on dashboard
- Edit own profile (name, mobile)

---

## 🏗️ Project Structure

```
src/
└── main/
    ├── java/in/manu/ems/
    │   ├── EmployeeMsApplication.java     # Spring Boot entry point
    │   ├── controller/
    │   │   ├── AuthController.java        # Register, Login, Logout
    │   │   ├── AdminController.java       # Admin dashboard, add/delete employees
    │   │   └── EmployeeController.java    # Employee dashboard, edit profile
    │   ├── entity/
    │   │   └── Employee.java              # JPA Entity (id, name, email, role, dept...)
    │   ├── repository/
    │   │   └── EmployeeRepository.java    # Spring Data JPA Repository
    │   └── service/
    │       ├── EmployeeService.java       # Service interface
    │       └── EmployeeServiceImpl.java   # Service implementation
    └── resources/
        ├── application.properties         # DB config, server port
        ├── static/
        │   ├── css/bootstrap.min.css
        │   └── js/bootstrap.bundle.min.js
        └── templates/                     # Thymeleaf HTML pages
            ├── home.html
            ├── login.html
            ├── register.html
            ├── admin-dashboard.html
            ├── admin-add-employee.html
            ├── admin-edit-profile.html
            ├── employee-dashboard.html
            └── employee-edit-profile.html
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- MySQL 8+
- Maven 3.6+

### 1. Clone the repository
```bash
git clone https://github.com/manu072093/Employee-MS.git
cd Employee-MS/Employee-MS
```

### 2. Create the database
```sql
CREATE DATABASE ems_db;
```

### 3. Configure database credentials
Open `src/main/resources/application.properties` and update:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```
> Tables are auto-created by Hibernate on first run (`ddl-auto=update`)

### 4. Run the application
```bash
mvn spring-boot:run
```

### 5. Access the app
```
http://localhost:8080
```

---

## 🔗 API / URL Routes

| Method | URL | Description |
|---|---|---|
| GET | `/` | Home page |
| GET/POST | `/register` | Employee registration |
| GET/POST | `/login` | Login |
| GET | `/logout` | Logout & session invalidate |
| GET | `/admin/dashboard` | Admin dashboard (all employees) |
| GET/POST | `/admin/add-employee` | Add new employee |
| GET/POST | `/admin/edit-profile` | Admin edit own profile |
| GET | `/admin/delete/{id}` | Delete employee by ID |
| GET | `/employee/dashboard` | Employee dashboard |
| GET/POST | `/employee/edit-profile` | Employee edit own profile |

---

## 📸 Screenshots

### 🏠 Home Page
![Home Page](home.png)

### 🔐 Login
![Login Page](login.png)

### 📝 Register
![Register Page](register.png)

---

## 🙋‍♂️ Author

**Manoj Kumar M**  
📧 Manojneymar58@gmail.com  
🌐 [manojkumar-deve.netlify.app](https://manojkumar-deve.netlify.app)  
🐙 [github.com/manu072093](https://github.com/manu072093)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
