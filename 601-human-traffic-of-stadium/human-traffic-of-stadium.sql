WITH Ranked AS (
    SELECT id, visit_date, people,
           id - ROW_NUMBER() OVER(ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
)
SELECT id, visit_date, people
FROM Ranked
WHERE grp IN (
    SELECT grp 
    FROM Ranked 
    GROUP BY grp 
    HAVING COUNT(*) >= 3
);