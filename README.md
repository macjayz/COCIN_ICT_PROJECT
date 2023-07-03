# Employee Management System

This is a RESTful API for an Employee Management System built using Java and the Spring Boot framework.

## Requirements

- Java Development Kit (JDK) 11 or later: [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- MySQL: [Download MySQL](https://dev.mysql.com/downloads/installer/)
- Integrated Development Environment (IDE) of your choice (e.g., IntelliJ IDEA, Eclipse, Visual Studio Code)

## Setup Instructions

1. Clone or download the project from the repository.

2. Open the project in your preferred IDE.

3. Configure the MySQL database:
   - Open MySQL Workbench or any other MySQL client tool.
   - Create a new database named "employee_management".
   - Update the database connection configuration in the `application.properties` file located in the `src/main/resources` directory. Set the correct username and password for your MySQL installation.

4. Build and run the application:
   - Build the project using the IDE or by running the following command in the project's root directory:
     ```
     ./mvnw clean install        (for Mac/Linux)
     mvnw.cmd clean install      (for Windows)
     ```
   - Once the build is successful, run the application using the IDE or by executing the following command:
     ```
     ./mvnw spring-boot:run      (for Mac/Linux)
     mvnw.cmd spring-boot:run    (for Windows)
     ```

5. The application should start, and you can access the API endpoints using a tool like cURL, Postman, or any web browser.

6. The API is available at `http://localhost:8080`.


## API Documentation

Refer to the API documentation or the provided code to understand the available endpoints and their request/response formats.

## Testing

To run tests, you can use JUnit and Mockito for unit testing or tools like RestAssured for integration testing. Write tests for the desired endpoints or functionalities.

## Troubleshooting

If you encounter any issues during the setup or running of the application, please ensure that you have installed the required software and dependencies correctly. Check the console or logs for any error messages that may help in troubleshooting.

---