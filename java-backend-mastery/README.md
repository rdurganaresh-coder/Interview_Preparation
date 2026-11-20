# Java Backend Mastery

Maven multi-module repository (Java 21, JUnit 5, Spring Boot BOM 3.3.5).

| Domain | Submodules |
|---|---|
| `corejava_modules` | collections, streams, oop-basics, concurrency |
| `dsa_algorithms` | arrays-hashing, trees-graphs, dynamic-programming |
| `dbms` | sql-queries, jdbc-transactions, jpa-hibernate |
| `spring-boot` | rest-api, exception-handling, validation-profiles |
| `spring-batch` | chunk-processing, tasklet-jobs, fault-tolerance |
| `spring-security` | jwt-authentication, rbac-authorization, password-encoding |
| `microservices` | service-discovery, api-gateway, circuit-breaker |
| `aws` | s3-storage, sqs-messaging, iam-config |
| `linux` | shell-scripting, process-management, networking-tools |

## Commands
```bash
mvn clean test                                  # everything
mvn -pl dsa_algorithms -am test                 # one domain
mvn -pl dsa_algorithms/arrays-hashing -am test  # one topic
```

Requires JDK 21+ and Maven 3.9+.
