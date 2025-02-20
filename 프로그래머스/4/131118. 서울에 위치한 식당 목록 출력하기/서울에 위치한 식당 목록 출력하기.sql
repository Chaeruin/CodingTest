-- 코드를 입력하세요
SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address,
        ROUND(AVG(rr.REVIEW_SCORE), 2) as SCORE
FROM REST_INFO ri
JOIN REST_REVIEW rr ON ri.rest_id = rr.rest_id
WHERE SUBSTR(ri.address, 1, 2) = '서울'
GROUP BY ri.rest_id
ORDER BY SCORE DESC, ri.favorites DESC;