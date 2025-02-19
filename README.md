✈️ Flight Management System - Backend (Spring Boot)

📌 Project Overview

The Flight Management System is a backend application built using Spring Boot, providing a RESTful API for managing flights, bookings, passengers, payments, and airports. It includes JWT-based authentication, CORS handling, and Spring Data JPA for database operations.

🚀 Tech Stack
Spring Boot - Backend framework
Spring Web - REST API development
Spring Security & JWT - Authentication & authorization
Spring Data JPA (Hibernate) - Database ORM
Lombok - Reduces boilerplate code
CORS Configuration - Enables cross-origin requests
MySQL/PostgreSQL - Database (Configurable)
Swagger - API documentation

🗝 Features

✅ JWT Token-based Authentication & Authorization✅ Role-based Access Control (Admin, User, etc.)✅ CORS Configuration - Allows frontend communication✅ CRUD Operations for Flights, Bookings, Passengers, Airports, Payments✅ Spring Data JPA for seamless database management✅ Lombok Integration - Reduces boilerplate code✅ Exception Handling & Logging

💂 Project Structure

/src/main/java/com/flightbooking/app
 ├── airport
 ├── airline
 ├── booking
 ├── flight
 ├── passenger
 ├── payment
 ├── security
 ├── config
 ├── repository
 ├── service
 ├── controller

🛠️ Installation & Setup

1️⃣ Clone the Repository
git clone https://github.com/your-username/flight-management-system.git
cd flight-management-system

2️⃣ Configure Database

Modify application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3️⃣ Run the Application

mvn spring-boot:run

4️⃣ Access API (Swagger UI)
http://localhost:8080/swagger-ui/

🔒 Authentication & Security

JWT-based security with Bearer Token

Role-based access control (Admin, User)

CORS Configured for frontend integration

🔑 Generate Token (Example)

Send a POST request to:

http://localhost:8080/auth/login

with:

{
  "username": "admin",
  "password": "password"
}

Response:

{
  "token": "eyJhbGciOiJIUz..."
}

Use this token in the Authorization header for API requests.

📄 API Endpoints


📞 Contact

For queries, reach out via:📧 junaidparwez@gmail.com🔗 LinkedIn
