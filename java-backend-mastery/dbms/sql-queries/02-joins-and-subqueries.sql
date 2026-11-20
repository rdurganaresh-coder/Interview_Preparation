-- 1. Self Join: Employee and Manager names
SELECT e.emp_name AS employee, m.emp_name AS manager
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.emp_id;

-- 2. Employees earning above their department average (Correlated Subquery)
SELECT emp_name, dept_id, salary
FROM employees e
WHERE salary > (
    SELECT AVG(salary) FROM employees WHERE dept_id = e.dept_id
);
