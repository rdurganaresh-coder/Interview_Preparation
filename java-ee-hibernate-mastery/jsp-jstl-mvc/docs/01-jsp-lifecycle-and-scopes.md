# JSP Lifecycle, Implicit Objects & Scopes

## 1. JSP Translation & Execution Pipeline
1. **Translation**: Container converts `.jsp` into a `.java` Servlet source file.
2. **Compilation**: Compiles the generated `.java` file into `.class` bytecode.
3. **Initialization**: Calls `jspInit()`.
4. **Execution**: Calls `_jspService(request, response)` for each request.
5. **Cleanup**: Calls `jspDestroy()`.

## 2. The 4 JSP Attribute Scopes (Narrowest to Broadest)
1. **`pageContext`**: Current JSP page only.
2. **`request`**: Single HTTP request (survives `RequestDispatcher.forward()`, lost on `sendRedirect()`).
3. **`session`**: Across multiple HTTP requests from the same user.
4. **`application` (`ServletContext`)**: Shared across all users of the web application.

## 3. `forward()` vs `sendRedirect()`
| Feature | `RequestDispatcher.forward()` | `HttpServletResponse.sendRedirect()` |
| :--- | :--- | :--- |
| Execution | Server-side internal transfer | Client-side 302 redirect (2nd HTTP request) |
| Browser URL | Remains original URL | Changes to target URL |
| Request Attributes | Preserved | Lost |
