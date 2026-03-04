# backend-new (Spring Boot + Postgres + Docker)

A simple production-oriented REST API sample:
- Layered architecture (Controller/Service/Repository)
- Validation + Global Exception handling
- PostgreSQL with Flyway migrations
- Docker Compose setup
- Swagger UI
- Integration tests with Testcontainers

## Run with Docker
```bash
docker compose up --build

## Architecture

Client
   ↓
Spring Boot REST API
   ↓
Hikari Connection Pool
   ↓
PostgreSQL

Infrastructure:
- Docker Compose
- Flyway migrations
- Swagger/OpenAPI
- Integration tests (Testcontainers)