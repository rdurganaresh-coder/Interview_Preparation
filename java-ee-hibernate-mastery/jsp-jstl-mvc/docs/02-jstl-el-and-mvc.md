# JSTL, EL & Classic MVC Pattern

## 1. Avoiding Java Scriptlets (`<% ... %>`)
Modern JSP avoids raw Java scriptlets in HTML by combining:
* **Expression Language (EL)**: `${topic.title}` searches `page -> request -> session -> application` scopes automatically.
* **JSTL Core (`jakarta.tags.core`)**: `<c:forEach>`, `<c:if>`, `<c:choose>`, `<c:out>` (escapes HTML to prevent XSS).

## 2. Classic Java EE MVC Flow
1. Browser sends `GET /topics` to `TopicMvcServlet` (**Controller**).
2. Servlet fetches `List<Topic>` from service/model (**Model**) and stores it in `request.setAttribute("topics", list)`.
3. Servlet forwards to `/WEB-INF/views/topics.jsp` (**View** — placed inside `WEB-INF` so users cannot access the JSP directly without going through the controller).
