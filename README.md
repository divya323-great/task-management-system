# Task Management System

## Overview

This project is a Task Management System developed using Spring Boot, Thymeleaf, and MySQL.
The system allows users to create, update, view, and delete tasks efficiently.

The application tracks:

* Task title and description
* Due date and task status
* Task remarks
* Task creator
* Last updated user
* Creation timestamp
* Last updated timestamp

This project demonstrates CRUD operations using Spring Boot MVC architecture.

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Thymeleaf
* MySQL
* HTML
* CSS
* Maven
* Git

---

## Database Design

### ER Diagram

The system consists of two entities:

User
Task

Relationship:

User (1) → (*) Task

A single user can create or update multiple tasks.

---

### Data Dictionary

#### Table: Task

| Field                | Type      | Description                       |
| -------------------- | --------- | --------------------------------- |
| id                   | Long      | Primary key                       |
| title                | String    | Task title                        |
| description          | String    | Task description                  |
| due_date             | Date      | Task deadline                     |
| status               | String    | Pending / In Progress / Completed |
| remarks              | String    | Additional notes                  |
| created_by_name      | String    | Name of task creator              |
| created_by_id        | String    | Employee ID of creator            |
| last_updated_by_name | String    | Name of last updater              |
| last_updated_by_id   | String    | Employee ID of updater            |
| created_on           | Timestamp | Task creation time                |
| last_updated_on      | Timestamp | Last update time                  |

---

### Indexes Used

Primary Key Index:
id

Reason:
Improves performance when retrieving, updating, or deleting tasks.

---

### Code First vs Database First

This project uses the **Code First Approach**.

Spring Boot with JPA automatically creates database tables based on entity classes.

Configuration used:

spring.jpa.hibernate.ddl-auto=update

---

## Application Structure

The project follows MVC architecture.

### Model

Represents database tables using entity classes.

Example:
Task.java

---

### View

Frontend pages built using Thymeleaf templates.

Files:

* index.html
* createTask.html
* editTask.html

---

### Controller

Handles HTTP requests and connects the frontend with backend logic.

Example:
TaskController.java

---

### Service Layer

Contains business logic.

Files:

* TaskService.java
* TaskServiceImpl.java

---

### Repository Layer

Handles database operations using Spring Data JPA.

Example:
TaskRepository.java

---

## Frontend Structure

Frontend technologies used:

* HTML
* CSS
* Thymeleaf

Thymeleaf integrates easily with Spring Boot and allows server-side rendering of dynamic content.

The application follows a Multi Page Application (MPA) architecture.

---

## Build and Installation

### Environment Requirements

* Java 17
* Maven
* MySQL
* Git
* IDE (IntelliJ / Eclipse / VS Code)

---

## Database Setup

Create database in MySQL:

CREATE DATABASE task_management;

---

## application.properties Configuration

server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/task_management
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false

---

## Build Project

Run the command:

mvn clean install

---

## Run Application

Start the application using:

mvn spring-boot:run

Or run the main class:

TaskManagementApplication.java

Open the browser and go to:

http://localhost:8081

---

## Features

* Create Task
* Edit Task
* Delete Task
* View Task List
* Track Task Creator
* Track Last Updated User
* Track Creation Timestamp
* Track Update Timestamp

---

## Conclusion

This project demonstrates a Task Management System using Spring Boot MVC architecture with MySQL database integration and Thymeleaf frontend templates.
