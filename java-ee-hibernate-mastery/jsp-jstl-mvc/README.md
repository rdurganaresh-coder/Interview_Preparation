# JSP & JSTL MVC (`com.jee.jsp`)

Demonstrates classic Java EE MVC architecture: a Front Controller Servlet forwarding request attributes to JSP views rendered with Expression Language (EL) and JSTL tags on **port `8402`**.

## Study Guides (`docs/`)
- [01 - JSP Lifecycle, Implicit Objects & Scopes](docs/01-jsp-lifecycle-and-scopes.md)
- [02 - JSTL, EL & Classic MVC Pattern](docs/02-jstl-el-and-mvc.md)

## Run
```bash
mvn jetty:run
# Visit: http://localhost:8402/topics
```
