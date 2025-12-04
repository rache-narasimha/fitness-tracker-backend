# Fitness Tracker — Backend

Spring Boot backend for the **Fitness Tracker** demo application.

**Tech stack**
- Java 21, Spring Boot 4
- Spring Data JPA (Hibernate)
- H2 (in-memory) for local development — switchable to Oracle
- Maven
- BCrypt for password hashing

---

## What’s included (current)
- User registration (`POST /api/users/register`) — stores username + bcrypt hash  
- Workout tracking  
  - `POST /api/workouts` — create workout  
  - `GET  /api/users/{userId}/workouts` — list workouts for a user  
- Meal tracking  
  - `POST /api/meals` — create meal  
  - `GET  /api/users/{userId}/meals` — list meals for a user  
- Basic project layout: `/src/main/java/com/fitness` (controllers, models, repos, service)

---

## Quickstart (run locally)

Requirements:
- Java 21 installed
- Maven installed (or use `./mvnw`)
- Git

Run the app (project root):
```bash
# using wrapper
./mvnw spring-boot:run

# or using installed maven
mvn spring-boot:run
