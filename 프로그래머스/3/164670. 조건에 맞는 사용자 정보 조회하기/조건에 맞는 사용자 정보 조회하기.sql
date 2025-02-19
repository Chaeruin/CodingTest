-- 코드를 입력하세요
SELECT uu.user_id, uu.nickname, 
        CONCAT(uu.CITY, ' ', uu.STREET_ADDRESS1, ' ', uu.STREET_ADDRESS2) as 전체주소, 
        CONCAT(SUBSTR(uu.TLNO, 1, 3), '-', SUBSTR(uu.TLNO, 4, 4), '-', SUBSTR(uu.TLNO, 8, 4)) as 전화번호
FROM USED_GOODS_USER uu
JOIN USED_GOODS_BOARD ub ON ub.writer_id = uu.user_id
GROUP BY ub.writer_id
HAVING COUNT(ub.writer_id) >= 3
ORDER BY ub.writer_id DESC;
                                      