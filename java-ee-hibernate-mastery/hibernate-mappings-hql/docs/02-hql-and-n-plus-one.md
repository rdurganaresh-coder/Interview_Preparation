# HQL, JOIN FETCH & N+1 Prevention

## 1. What is the N+1 Problem?
1. Query 1 fetches `N` parent records (`SELECT * FROM departments`).
2. Accessing a lazy collection (`dept.getEmployees()`) inside a loop triggers `N` additional `SELECT` queries—one per parent.

## 2. How to Fix N+1
* **`JOIN FETCH` in HQL**:
  ```sql
  SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees
  ```
* **`@EntityGraph`**: Declaratively specify association paths to fetch in a single query.
* **`@BatchSize(size = 20)`**: Fetches uninitialized proxies in batches instead of 1 by 1.
