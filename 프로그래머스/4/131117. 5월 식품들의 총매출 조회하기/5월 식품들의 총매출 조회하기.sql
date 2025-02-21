-- 코드를 입력하세요
SELECT p.product_id, p.product_name, SUM(p.price * o.amount) as TOTAL_SALES
FROM FOOD_ORDER o
JOIN FOOD_PRODUCT p ON p.product_id = o.product_id
WHERE DATE_FORMAT(o.produce_date, '%Y-%m') = '2022-05'
GROUP BY p.product_id
ORDER BY TOTAL_SALES DESC, p.product_id;