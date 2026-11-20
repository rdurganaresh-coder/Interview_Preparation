# MongoDB & Redis Notes

- **Cache-Aside Pattern:** Check Redis first (`@Cacheable`); on cache miss, load from MongoDB/SQL and populate Redis with a TTL.
