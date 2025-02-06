-- 코드를 입력하세요
SELECT fh.flavor as FLAVOR
FROM FIRST_HALF fh
JOIN ICECREAM_INFO ii ON fh.FLAVOR = ii.FLAVOR
WHERE ii.INGREDIENT_TYPE = "fruit_based" and fh.total_order > 3000
ORDER BY fh.total_order DESC;