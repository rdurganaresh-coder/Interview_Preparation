# Java Backend Mastery (`java-backend-mastery`)

A full-stack, multi-module monorepo configured for **JDK 26**, **Spring Boot 4.1.2**, **DBMS**, **AWS (LocalStack)**, **Linux & DevOps**, **Docker Compose**, **React**, and **Angular**.

## Architecture Overview

- **Core Java & DSA (`JDK 26`):**
  - `corejava_modules/`: `java-streams`, `java-collections`, `multithreading` (with `NOTES.md` per topic)
  - `dsa_algorithms/`: `arrays-strings`, `trees-graphs`, `dynamic-programming` (with `NOTES.md` per topic)
- **Backend Spring & Microservices (`Spring Boot 4.1.2`):**
  - `spring-boot/`: `spring-boot-rest-basics` (`8081`), `spring-boot-jpa-crud` (`8082`)
  - `spring-batch/`: `batch-csv-to-db`, `batch-job-scheduler`
  - `spring-security/`: `security-basic-rbac` (`8083`), `security-jwt-auth` (`8084`)
  - `microservices/`: `service-discovery` (`8761`), `api-gateway` (`8080`), `order-service` (`8091`), `payment-service` (`8092`) + `docker-compose.yml`
- **DBMS & SQL Practice:**
  - `dbms/`: `jdbc-connection-pooling`, `jpa-hibernate-tuning` (`8085`), `nosql-mongodb-redis` (`8086`), `sql-queries/` (PostgreSQL & H2 scripts), and `docker-compose.yml`
- **AWS Cloud Practice (LocalStack):**
  - `aws/`: `aws-s3-file-service` (`8087`), `aws-sqs-sns-messaging` (`8088`), `aws-dynamodb-crud` (`8089`), `aws-cli-scripts/`, and `docker-compose.yml`
- **Linux & Shell Scripting Practice:**
  - `linux/`: `scripts/` (system diagnostics, log analyzer, backup automation, process monitor, deployment scripts), `NOTES.md`, and `Dockerfile` (Ubuntu sandbox container)
- **Frontend Workspaces:**
  - `frontend/react-workspace/`: `@learning/shared-ui`, `react-basics` (`3001`), `react-dashboard` (`3002`)
  - `frontend/angular-workspace/`: `shared-lib`, `angular-basics` (`4201`), `angular-admin` (`4202`)

## Quick Build Commands

```bash
# Build all Java/Maven modules
mvn clean compile

# Run Linux practice sandbox container
cd linux && docker compose up -d --build && docker exec -it linux-practice-lab bash

```


The archive contains the updated java-backend-mastery full-stack multi-module workspace configured for JDK 26, Spring Boot 4.1.2, Docker Compose, React, and Angular:
• Nested Core Java & DSA Aggregators (Both inherit JDK 26 from the root pom.xml):
• corejava_modules/ (<packaging>pom</packaging>) containing java-streams, java-collections, and multithreading (with a Java Virtual Threads demo).
• dsa_algorithms/ (<packaging>pom</packaging>) containing arrays-strings (TwoSum), trees-graphs (BinaryTreeTraversal), and dynamic-programming (FibonacciDP).
• Spring & Microservices Backend Modules:
• spring-boot/ with spring-boot-rest-basics (port 8081) and spring-boot-jpa-crud (port 8082).
• spring-batch/ with batch-csv-to-db and batch-job-scheduler.
• spring-security/ with security-basic-rbac (port 8083) and security-jwt-auth (port 8084).
• microservices/ with service-discovery (port 8761), api-gateway (port 8080), order-service (port 8091), payment-service (port 8092), Dockerfiles, and docker-compose.yml.
• Frontend Workspaces:
• frontend/react-workspace/ (@learning/shared-ui, react-basics on 3001, react-dashboard on 3002) and frontend/angular-workspace/ (shared-lib, angular-basics on 4201, angular-admin on 4202).
Would you like me to add JUnit 5 unit tests inside your new dsa_algorithms sub-modules (arrays-strings, trees-graphs, and dynamic-programming) so you can run automated test suites in IntelliJ IDEA?
Show Code

