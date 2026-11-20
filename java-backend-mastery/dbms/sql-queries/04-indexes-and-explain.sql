CREATE INDEX idx_emp_dept_salary ON employees(dept_id, salary DESC);

EXPLAIN ANALYZE
SELECT emp_name, salary FROM employees WHERE dept_id = 10 AND salary > 110000;
