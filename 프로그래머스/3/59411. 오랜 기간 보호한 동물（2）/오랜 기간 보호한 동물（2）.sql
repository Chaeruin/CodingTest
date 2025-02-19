-- 코드를 입력하세요
SELECT i.animal_id, i.name
FROM ANIMAL_INS i
INNER JOIN ANIMAL_OUTS o ON i.animal_id = o.animal_id
ORDER BY (DATEDIFF(o.datetime, i.datetime) + 1) DESC
LIMIT 2;