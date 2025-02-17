-- 코드를 입력하세요
SELECT b.category, sum(bs.sales) as TOTAL_SALES
FROM BOOK b
JOIN BOOK_SALES bs ON b.book_id = bs.book_id
WHERE DATE_FORMAT(bs.sales_date, '%Y-%m') = '2022-01'
GROUP BY b.category
ORDER BY b.category ASC;