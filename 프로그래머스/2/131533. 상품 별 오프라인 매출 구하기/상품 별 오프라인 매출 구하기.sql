-- 코드를 입력하세요
SELECT p.product_code as PRODUCT_CODE, SUM(p.price * off.sales_amount) as SALES
FROM PRODUCT p
JOIN OFFLINE_SALE off ON p.product_id = off.product_id
GROUP BY off.product_id
ORDER BY SALES DESC, PRODUCT_CODE ASC;

