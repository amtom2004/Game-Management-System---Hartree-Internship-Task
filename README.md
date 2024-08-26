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
## Rest API Usage

### 1. Generate Data

This endpoint is used to generate a large number of registrations and simulate data for the event.

- **Endpoint**: http://localhost:8080/api/data/generate
- **Method**: `GET`
- **Description**: Generates mock data for countries, athletes, and events using Java Faker. This data will be used for simulations and queries.

### 2. Register an Athlete

This endpoint allows you to register a new athlete.

- **Endpoint**: http://localhost:8080/athletes
- **Method**: `POST`
- **Request Body**:
  ```json
  {
      "firstName": "Aron",
      "lastName": "Tom",
      "age": 25,
      "gender": "Male",
      "country": {
          "id": 1
      }
  }

### 3. Get an Athlete by ID

This endpoint allows you to get an athlete.

- **Endpoint**: http://localhost:8080/athletes/id
- **Method**: `GET`

### 4. Update an Athlete by ID

This endpoint allows you to update an athlete.

- **Endpoint**: http://localhost:8080/athletes/id
- **Method**: `PUT`

### 5. Get all Athletes

This endpoint allows you to get all athlete.

- **Endpoint**: http://localhost:8080/athletes
- **Method**: `GET`

### 6. Delete an Athlete by ID

This endpoint allows you to delete an athlete.

- **Endpoint**: http://localhost:8080/athletes
- **Method**: `DELETE`

### 7. Simulate the Game

This endpoint allows you to simulate the whole game.

- **Endpoint**: http://localhost:8080/api/data/simulate
- **Method**: `GET`

### 8. Get Countries with Most Gold Medals

This endpoint allows you to get countries with most Gold medals.

- **Endpoint**: http://localhost:8080/stats/countries/most-gold-medals
- **Method**: `GET`

### 9. Get Countries with Least Silver Medals

This endpoint allows you to get countries with least Silver medals.

- **Endpoint**: http://localhost:8080/stats/countries/least-silver-medals
- **Method**: `GET`

### 10. Get Athletes with most Medals

This endpoint allows you to get athletes with most number of medals.

- **Endpoint**: http://localhost:8080/stats/athletes/most-medals
- **Method**: `GET`

### 11. Get Athletes with most Points

This endpoint allows you to get athletes with most points.

- **Endpoint**: http://localhost:8080/stats/athletes/most-points
- **Method**: `GET`

### 12. Get Top n Countries in Medal Tally

This endpoint allows you to get top n countries in Medal Tally.

- **Endpoint**: http://localhost:8080/stats/countries/top-medal-tally/n
- **Method**: `GET`

### 12. Get Top n Countries in Medal Tally for an Event

This endpoint allows you to get top n countries in Medal Tally for an EventID.

- **Endpoint**: http://localhost:8080/stats/countries/top-medal-tally/n/id
- **Method**: `GET`

### Additional Notes:
1. **Customization**: Customize the file to match your exact project structure and features.
2. **Database Setup**: If you're using Docker for PostgreSQL, add instructions on setting up and running the PostgreSQL container.
3. **API Documentation**: Consider using Swagger for better API documentation. You can include instructions for accessing Swagger UI if you integrate it.


## Licence
This project is licensed under the MIT Licence.
