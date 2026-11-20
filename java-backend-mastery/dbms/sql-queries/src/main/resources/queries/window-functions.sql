-- Rank employees by salary inside each department
SELECT dept, name,
       RANK() OVER (PARTITION BY dept ORDER BY salary DESC) AS rnk
FROM employees;
