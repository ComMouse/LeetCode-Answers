SELECT Name AS Customers
    FROM Customers
    LEFT OUTER JOIN Orders ON Customers.Id = Orders.CustomerId
    WHERE Orders.Id IS NULL;