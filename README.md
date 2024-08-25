# Game Management System

A Spring Boot application to manage an event like the Olympics, including athlete registrations, event simulations, and medal tally management. The system uses Java Faker for generating sample data and provides RESTful APIs for interacting with the system.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [REST API Usage](#rest-api-usage)
- [Simulating Events](#simulating-events)
- [License](#license)

## Features
- Register athletes, countries, and events.
- Simulate event results and generate a medal tally.
- Query statistics like the top-performing countries and athletes.
- RESTful API for interacting with the system.

## Technologies
- **Spring Boot** - Application framework
- **Spring Data JPA** - Data persistence
- **Hibernate** - ORM framework
- **PostgreSQL** - Database
- **Docker** - Containerization
- **Java Faker** - Data generation for testing

## Setup

### Prerequisites
- **Java 17** or higher
- **Maven** or **Gradle** for build automation
- **PostgreSQL** for the database
- **Docker** (optional, for containerization)

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/game-management-system.git
   cd game-management-system```

2. **Configure the Database**
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432 olympics
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update```

3. **Build the Application**
```bash
mvn clean install
```
4. **Running the Application**
```bash
mvn spring-boot:run
```

[Click here]() for REST API Usages.


### Additional Notes:
1. **Customization**: Customize the file to match your exact project structure and features.
2. **Database Setup**: If you're using Docker for PostgreSQL, add instructions on setting up and running the PostgreSQL container.
3. **API Documentation**: Consider using Swagger for better API documentation. You can include instructions for accessing Swagger UI if you integrate it.


## Licence
This project is licensed under the MIT Licence.
