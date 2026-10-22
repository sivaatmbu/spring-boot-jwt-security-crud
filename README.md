# Spring Boot JWT Security & Customer CRUD API

A Java backend practice project built with Spring Boot, Spring Security, JWT authentication, Spring Data JPA, Hibernate, and MySQL.

## Overview

This project demonstrates how to build REST APIs, manage customer records, register employees, authenticate users, and protect endpoints using JSON Web Tokens (JWT).

It combines CRUD operations with a basic authentication workflow to practise important Java backend development concepts.

## Features

- **Customer CRUD Operations** — Create, read, update, and delete customer records.
- **Employee Registration** — Register employees with BCrypt password hashing.
- **Employee Login** — Authenticate employees using Spring Security.
- **JWT Authentication** — Generate signed JWTs after successful login.
- **Protected REST APIs** — Require authentication for customer endpoints.
- **Spring Data JPA** — Interact with the MySQL database using repositories.
- **Stateless Security** — Configure Spring Security without server-side login sessions.
- **REST API Testing** — Test endpoints using Postman.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot | Backend application |
| Spring Web | REST API development |
| Spring Security | Authentication and authorization |
| JWT (JJWT) | Token generation and validation |
| Spring Data JPA | Database access |
| Hibernate | ORM |
| MySQL | Relational database |
| Maven | Dependency management |
| Postman | API testing |

## Project Structure

```text
src/main/java/com/sp/www/
├── Beans/
│   ├── Customers.java
│   ├── Employees.java
│   └── MyEmployees.java
├── Configurations/
│   ├── JwtFilter.java
│   └── SecurityConfigurations.java
├── Controllers/
│   ├── CustomersController.java
│   └── EmployeesController.java
├── Repositories/
│   ├── CustomersRepo.java
│   └── EmployeesRepo.java
└── Services/
    ├── CustomersService.java
    ├── EmployeeDetails.java
    ├── EmployeesService.java
    └── JWTService.java
```

## API Endpoints

### Employee Authentication

| Method | Endpoint | Description | Authentication |
|---|---|---|---|
| POST | `/register` | Register an employee | Not required |
| POST | `/login` | Authenticate and receive a JWT | Not required |

### Customer Operations

| Method | Endpoint | Description |
|---|---|---|
| GET | `/getAllCustomers` | Retrieve all customers |
| GET | `/getCustomerById/{id}` | Retrieve a customer by ID |
| GET | `/getCustomerByName/{name}` | Retrieve a customer by name |
| POST | `/addCustomer` | Add a customer |
| PUT | `/updateCustomer` | Add or update a customer by ID |
| DELETE | `/deleteCustomer/{id}` | Delete a customer by ID |

Customer endpoints require a valid JWT in the Authorization header.

## Getting Started

### Prerequisites

Install the following:

- JDK 17
- MySQL Server
- Maven (or use the included Maven Wrapper, if available)
- Eclipse IDE or another Java IDE
- Postman

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/spring-boot-jwt-security-crud.git
```

Open the project in your preferred IDE as a Maven project.

### 2. Configure MySQL

Create the database:

```sql
CREATE DATABASE springsecuritydb;
```

Configure the database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springsecuritydb
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace the placeholders with your local MySQL credentials. These are example settings; retain any project-specific configuration you need.

### 3. Run the Application

Run the main Spring Boot application class from your IDE, or use the Maven Wrapper if it is included in the repository.

The default local address is:

```text
http://localhost:8080
```

### 4. Register an Employee

Send a POST request to:

```text
http://localhost:8080/register
```

Example JSON body:

```json
{
  "id": 1,
  "name": "praneesh",
  "password": "your-password"
}
```

Use a new ID and username if they already exist in your database.

### 5. Log In

Send a POST request to:

```text
http://localhost:8080/login
```

Example JSON body:

```json
{
  "name": "praneesh",
  "password": "your-password"
}
```

After successful authentication, the API returns a JWT.

### 6. Access a Protected Endpoint

Send a GET request to:

```text
http://localhost:8080/getAllCustomers
```

In Postman, open **Authorization**, select **Bearer Token**, and paste the JWT returned by the login endpoint.

## What I Learned

- Building REST APIs using Spring Boot.
- Implementing CRUD operations with Spring Data JPA.
- Connecting a Java application to MySQL.
- Configuring authentication with Spring Security.
- Hashing passwords using BCrypt.
- Generating and validating JWTs.
- Using a custom JWT filter to authenticate requests.
- Testing APIs with Postman.

## Important Security Notes

This is a learning project and is not production-ready.

- Keep database credentials and signing secrets out of public source code.
- The current JWT service generates a signing key at application startup, so tokens issued before a restart will no longer validate.
- Avoid returning password hashes in API responses. A DTO can be used to return only safe employee details.
- Add input validation, duplicate-user checks, and appropriate error handling before using the application in a real environment.

## Future Improvements

- Add DTOs and request validation.
- Improve exception handling.
- Add role-based authorization.
- Add pagination and sorting.
- Write unit and integration tests.
- Add a React frontend.

## Author

**Siva Praneesh Velpula**

Java Backend Development Learner

---

If you find this project useful, feel free to explore the source code and follow my progress in Java backend development.
