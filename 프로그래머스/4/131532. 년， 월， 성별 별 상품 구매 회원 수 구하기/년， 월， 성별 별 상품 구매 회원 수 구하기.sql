-- 코드를 입력하세요
SELECT YEAR(os.sales_date) as YEAR, MONTH(os.sales_date) as MONTH, u.gender, COUNT(DISTINCT u.user_id)
FROM ONLINE_SALE os
JOIN USER_INFO u ON os.user_id = u.user_id
WHERE u.gender IS NOT NULL
GROUP BY YEAR, MONTH, u.gender
ORDER BY YEAR, MONTH, u.gender