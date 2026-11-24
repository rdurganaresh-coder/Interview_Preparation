# JWT Authentication & RBAC
- Validate `Authorization: Bearer <token>` inside a custom `OncePerRequestFilter`.
- Enforce role checks using `@PreAuthorize("hasRole('ADMIN')")` with `@EnableMethodSecurity`.
