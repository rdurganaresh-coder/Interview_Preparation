# Java EE (Servlets, JSP) & Hibernate Mastery

Standalone Java 17 + Maven multi-module workspace covering **Jakarta Servlets**, **JSP + JSTL MVC**, and **Native Hibernate ORM 6**.

## Port Allocation (Non-Conflicting)

| Module | Package | Port / Mode | Description |
| :--- | :--- | :--- | :--- |
| `servlet-basics` | `com.jee.servlet` | **`8401`** (Jetty WAR) | Servlet lifecycle, Filters, Listeners, Session & Cookies |
| `jsp-jstl-mvc` | `com.jee.jsp` | **`8402`** (Jetty WAR) | Classic Servlet Controller + JSP + JSTL MVC pattern |
| `hibernate-orm-core` | `com.jee.hibernate.core` | Standalone / JUnit | `SessionFactory`, Entity lifecycle states, Dirty Checking, Caching |
| `hibernate-mappings-hql` | `com.jee.hibernate.mappings` | Standalone / JUnit | `@OneToMany`, `@ManyToMany`, HQL, Criteria API, N+1 solutions |

## Quick Start

1. **Build and test all modules:**
   ```bash
   mvn clean test
   ```
2. **Run Servlet module on port 8401:**
   ```bash
   mvn -pl servlet-basics jetty:run
   # Visit http://localhost:8401/hello
   ```
3. **Run JSP MVC module on port 8402:**
   ```bash
   mvn -pl jsp-jstl-mvc jetty:run
   # Visit http://localhost:8402/topics
   ```
