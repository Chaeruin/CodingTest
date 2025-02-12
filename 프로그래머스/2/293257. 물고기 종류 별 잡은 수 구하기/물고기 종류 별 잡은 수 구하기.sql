-- 코드를 작성해주세요
SELECT COUNT(f.FISH_TYPE) as FISH_COUNT, f.fish_name
FROM FISH_NAME_INFO f
INNER JOIN FISH_INFO i ON i.fish_type = f.fish_type
GROUP BY f.FISH_TYPE, f.fish_name
ORDER BY FISH_COUNT DESC;
