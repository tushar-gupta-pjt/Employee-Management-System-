
# Employee Management System API

Employee Management System (EMS) is a Spring Boot application designed to manage employees within an organization. It provides functionalities to perform CRUD (Create, Read, Update, Delete) operations on employee data stored in a MySQL database.


## Running The application

Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.project.employeeManagementSystem.Ems.Application class from your IDE.

```bash
  mvn spring-boot:run
```

Database Configuration:

Ensure you have MySQL installed locally.  
Create a MySQL database named ems.  
Update application.properties with your MySQL username and password if different.

Access the Application:

Once the application is up and running, you can access it at http://localhost:8080.   

Once the application is up and running, you can make execute end points via Swagger it at http://localhost:8080/swagger-ui/index.html#/



## Endpoints

#### Get all Employees

```http
  GET /employee
```

Retrieves all employees from the system.  
Response:

```bash
{
  "httpStatus": "OK",  
  "message": "Employees are fetched successfully",  
  "data": [ {...}, {...}, ... ],  
  "error": false
}
```

#### Get Employee

```http
  GET /employee/{id}
```

Retrieves an employee by their ID.  
Parameters:
id: ID of the employee to retrieve.  
Response:
```bash
{
  "httpStatus": "OK",
  "message": "Employee fetched successfully",
  "data": { ... },
  "error": false
}

```

#### Post Employee


```http
  POST /employee
```

Creates a new employee in the system.  
Request Body:

```bash
{
  "name": "John Doe",
  "position": "Software Engineer",
  "salary": 60000.0
}


```
Response:
```bash
{
  "httpStatus": "CREATED",
  "message": "Employee added successfully",
  "data": { "id": 123 },
  "error": false
}



```
#### Put Employee


```http
  PUT /employee/{id}
```

Updates an existing employee in the system.  
Parameters:  
id: ID of the employee to update.  
Request Body:

```bash
{
  "name": "Updated Name",
  "position": "Senior Software Engineer",
  "salary": 75000.0
}



```
Response:
```bash
{
  "httpStatus": "OK",
  "message": "Employee updated successfully",
  "data": { "id": 123 },
  "error": false
}




```

#### Delete Employee

```http
  DELETE /employee/{id}
```

Deletes an employee from the system.  
Parameters:  
id: ID of the employee to delete.  
Response:
```bash
{
  "httpStatus": "OK",
  "message": "Employee deleted successfully",
  "data": { "isDeleted": true },
  "error": false
}


```


## Technologies Used

**Tech Stack:** Java,
Spring Boot.
Spring Data JPA.
MySQL.
Lombok,
Swagger



## Authors

- [Tushar Gupta](tggguptatushar@gmail.com)

