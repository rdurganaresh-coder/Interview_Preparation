CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL,
    location VARCHAR(50)
);

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    dept_id INT REFERENCES departments(dept_id),
    manager_id INT REFERENCES employees(emp_id),
    salary DECIMAL(10, 2) NOT NULL,
    hire_date DATE NOT NULL
);

INSERT INTO departments VALUES
(10, 'Engineering', 'Hyderabad'),
(20, 'Product', 'Bengaluru'),
(30, 'Finance', 'Mumbai');

INSERT INTO employees VALUES
(1, 'Aarav Sharma', 10, NULL, 150000, '2022-01-15'),
(2, 'Priya Nair', 10, 1, 120000, '2023-03-10'),
(3, 'Rohan Verma', 10, 1, 115000, '2023-07-22'),
(4, 'Sneha Reddy', 20, NULL, 140000, '2022-05-01'),
(5, 'Karthik Rao', 20, 4, 95000, '2024-02-14');
