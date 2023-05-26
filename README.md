# REST API Automation Tests

This project contains automation tests for the REST API endpoints using TestNG, Maven, and RestAssured framework.

## Prerequisites

- Java JDK 8 or higher
- Maven

## Getting Started

1. Clone the repository:

git clone https://github.com/your-username/your-repository.git

2. Navigate to the project directory:

cd reqres

3. Build the project using Maven:

mvn clean install

## Running the Tests

You can run the tests using Maven:

mvn test

The test results will be displayed in the console.

## Project Structure
The project follows the standard Maven project structure:

├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── reqres
│   │               ├── endpoint
│   │               │   └── EndPoint.java
│   │               ├── pojo
│   │               │   ├── ListUsersResponse.java
│   │               │   ├── LoginRequest.java
│   │               │   ├── LoginResponseFailed.java
│   │               │   ├── LoginResponseSuccessfull.java
│   │               │   ├── RegisterRequest.java
│   │               │   ├── RegisterResponseFailed.java
│   │               │   └── RegisterResponseSuccessfull.java
│   │               ├── ListUsersTest.java
│   │               ├── LoginTest.java
│   │               └── RegisterTest.java
│   └── test
│       └── java
│           └── com
│               └── reqres
│                   ├── ListUsersTest.java
│                   ├── LoginTest.java
│                   └── RegisterTest.java
├── pom.xml
├── testng.xml
└── README.md

## Dependencies
The project uses the following dependencies:

TestNG: Testing framework
RestAssured: REST API testing framework
Lombok: Library for reducing boilerplate code
Gson Databind: JSON serialization/deserialization library
These dependencies are managed through Maven.
