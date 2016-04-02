SELECT Day, ROUND(COUNT(IF(Status = 'Completed', NULL, 1)) / COUNT(Day), 2) AS `Cancellation Rate` FROM
    (SELECT Request_at AS Day, Status FROM Trips
        JOIN Users ON Users.Users_Id = Trips.Client_Id
        WHERE Request_at BETWEEN '2013-10-01' AND '2013-10-03' AND Users.Banned = 'No') AS b
    GROUP BY Day;