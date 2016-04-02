SELECT Department.Name AS Department, a.Name AS Employee, a.Salary
    FROM Employee a
    JOIN Department ON Department.Id = a.DepartmentId
    WHERE (
        SELECT COUNT(DISTINCT b.Salary) FROM Employee b
        WHERE a.DepartmentId = b.DepartmentId
            AND a.Salary < b.Salary
    ) < 3
    ORDER BY Department, Salary DESC;