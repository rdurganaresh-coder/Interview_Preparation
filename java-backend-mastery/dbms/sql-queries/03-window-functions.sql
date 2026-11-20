-- Rank employees by salary within each department
SELECT
    emp_name,
    dept_id,
    salary,
    DENSE_RANK() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS dept_rank,
    SUM(salary) OVER (PARTITION BY dept_id ORDER BY hire_date) AS running_dept_payroll
FROM employees;
