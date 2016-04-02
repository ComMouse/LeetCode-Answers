SELECT Score, (
    SELECT COUNT(b.Id) + 1 FROM Scores b
        WHERE b.Score < a.Score
) FROM Scores a;