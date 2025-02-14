-- 코드를 작성해주세요
SELECT eco1.id, COUNT(eco2.id) as CHILD_COUNT
FROM ECOLI_DATA eco1
LEFT JOIN ECOLI_DATA eco2 ON eco1.id = eco2.parent_id
GROUP BY eco1.id
ORDER BY eco1.id ASC;
