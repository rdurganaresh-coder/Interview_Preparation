# Servlet Lifecycle & Thread Safety

## 1. Lifecycle Methods (`jakarta.servlet.Servlet`)
1. **Instantiation & `init(ServletConfig)`**: Called **once** when the container loads the servlet. Used for expensive one-time setup (e.g., loading config).
2. **`service(HttpServletRequest, HttpServletResponse)`**: Called for **every request** in a separate worker thread. Dispatches to `doGet()`, `doPost()`, `doPut()`, `doDelete()`.
3. **`destroy()`**: Called **once** before unloading the servlet to release resources.

## 2. Thread Safety Rule
* Servlet containers create **one singleton instance** of a Servlet class and serve concurrent HTTP requests using a thread pool.
* **Never store mutable per-request state in Servlet instance fields.** Keep state inside local method variables, `HttpServletRequest` attributes, or `HttpSession`.

## 3. `ServletConfig` vs `ServletContext`
| Scope | `ServletConfig` | `ServletContext` |
| :--- | :--- | :--- |
| Visibility | Single Servlet only | Entire Web Application |
| Lifecycle | Created per Servlet | Created once at app startup |
| Typical Use | Servlet-specific init params | Shared DB pools, global attributes |
