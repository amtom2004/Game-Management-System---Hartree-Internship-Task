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
   cd game-management-system
