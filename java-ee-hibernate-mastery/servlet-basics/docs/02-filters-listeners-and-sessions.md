# Filters, Listeners & Session Tracking

## 1. Servlet Filters (`jakarta.servlet.Filter`)
Intercepts requests **before** reaching a Servlet and responses **after** leaving a Servlet.
* Common uses: Authentication/JWT checks, request logging, CORS headers, GZIP compression.
* Always call `chain.doFilter(request, response)` to pass control downstream.

## 2. Web Listeners
React to container lifecycle events:
* `ServletContextListener`: App startup (`contextInitialized`) and shutdown (`contextDestroyed`).
* `HttpSessionListener`: Track active user sessions (`sessionCreated`, `sessionDestroyed`).

## 3. Session Tracking Mechanisms
1. **Cookies**: Small key-value pairs stored in browser (`HttpOnly`, `Secure`, `SameSite`).
2. **`HttpSession`**: Server-side state keyed by `JSESSIONID` cookie.
3. **URL Rewriting**: Appending `;jsessionid=...` when cookies are disabled.
