# JobFlow — Job Application Tracker

A REST API built using Java, Spring Boot, Spring Data JPA, and PostgreSQL to manage job applications.

## Features

- Create, retrieve, update, and delete job applications
- Input validation for company, role, and application status
- Consistent error responses for invalid input and missing records
- Filter applications by status
- Pagination and sorting
- PostgreSQL persistence
- Automated tests using the Spring Boot testing framework

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Jakarta Bean Validation
- JUnit / Spring Boot Test

## Setup

1. Install Java and PostgreSQL.
2. Create a PostgreSQL database named `jobflow`.
3. Configure database credentials in `src/main/resources/application.properties`.
4. Start the application:

   ```bash
   ./mvnw spring-boot:run
   ```

   On Windows PowerShell:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/applications` | Create an application |
| GET | `/api/applications` | List applications |
| GET | `/api/applications/{id}` | Get an application by ID |
| PUT | `/api/applications/{id}` | Update an application |
| DELETE | `/api/applications/{id}` | Delete an application |

### Filter and Pagination

Example:

`GET /api/applications?status=APPLIED&page=0&size=5`

### Example Request

```json
{
  "company": "Google",
  "role": "Software Engineer",
  "status": "APPLIED"
}
```

## Run Tests

Windows:

```powershell
.\mvnw.cmd test
```

## Configuration and Security

Keep database credentials outside version control. Do not commit passwords or other secrets.
