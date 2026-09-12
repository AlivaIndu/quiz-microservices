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
