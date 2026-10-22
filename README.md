# Quiz Microservices

A microservices-based online quiz application built using Spring Boot and Spring Cloud. The application is divided into independent services for managing questions and quizzes, with service discovery and inter-service communication.

## 🚀 Overview

This project demonstrates how a quiz application can be designed using a **microservices architecture** instead of a single monolithic application.

The system allows users to:

- Create quizzes based on a category
- Dynamically select random questions
- Start and attempt quizzes
- Submit answers
- Calculate quiz scores
- Communicate between microservices using OpenFeign
- Discover services using Eureka Service Discovery

## 🏗️ Architecture

```text
                         Client
                           |
                           v
                    +-------------+
                    | API Gateway |
                    +-------------+
                           |
             +-------------+-------------+
             |                           |
             v                           v
    +------------------+        +------------------+
    | Question Service | <----  |   Quiz Service   |
    +------------------+        +------------------+
             |                           |
             v                           v
       +-----------+               +-----------+
       | PostgreSQL|               | PostgreSQL|
       +-----------+               +-----------+

                 ^
                 |
          Eureka Server
        (Service Discovery)
```

🧩 Microservices
1. Question Service
Responsible for managing the questions used by quizzes.

Responsibilities:
- Add questions
- Retrieve all questions
- Retrieve questions by category
- Generate random question IDs
- Return questions based on selected IDs
- Evaluate submitted answers
2. Quiz Service
Responsible for quiz creation and quiz management.

Responsibilities:
- Create quizzes
- Request random question IDs from Question Service
- Store question IDs associated with each quiz
- Retrieve questions when a quiz starts
- Submit quiz answers
- Retrieve quiz results
  
3. Service Registry Uses Eureka Server for service discovery.
Services register themselves with Eureka so that they can communicate without relying on hard-coded service locations.

4. API Gateway
Acts as the entry point for client requests and routes requests to the appropriate microservice.

5. Service Communication
The services communicate using Spring Cloud OpenFeign.

🛠️ Tech Stack
Backend
- Java
- Spring Boot
- Spring Data JPA
- Spring Cloud
- Spring Cloud OpenFeign
- Spring Cloud Netflix Eureka
- REST APIs
- Maven
  
Database
- PostgreSQL
- JPA
  
Tools
- IntelliJ IDEA
- Postman
- Git & GitHub
  
📌 API Endpoints
Question Service
Method	Endpoint	Description
GET	/question/allQuestions	Get all questions
POST	/question/addQuestion	Add a new question
GET	/question/category/{category}	Get questions by category
GET	/question/generate	Generate random question IDs
POST	/question/getQuestions	Get questions using their IDs
POST	/question/GetScore	Calculate quiz score


Quiz Service
Method	Endpoint	Description
POST	/quiz/create	Create a new quiz
GET	/quiz/startQuiz/{id}	Start a quiz
POST	/quiz/submit/{id}	Submit quiz answers

⚙️ Getting Started
Prerequisites
Make sure you have installed:
- Java 17+
- Maven
- PostgreSQL
- Git
1. Clone the repository

2. Configure PostgreSQL
Create the required databases in PostgreSQL and update the database configuration in each service.

Example:
spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

Do not commit passwords, API keys, or other secrets to GitHub.
3. Start the services
Start the services in the following order:
1. Service Registry
2. Question Service
3. Quiz Service
4. API Gateway

Each service can be started using:
mvn spring-boot:run

🔮 Future Improvements
- Add authentication and authorization using Spring Security
- Add user accounts and quiz history
- Add a frontend application
- Add centralized configuration using Spring Cloud Config
- Add Docker and Docker Compose support
- Add unit and integration tests
- Add API documentation using Swagger/OpenAPI
- Add monitoring with Spring Boot Actuator
  
👩‍💻 Author
Aliva Indu
Computer Science & Engineering (Cyber Security)

⭐ If you found this project useful, consider giving it a star!
