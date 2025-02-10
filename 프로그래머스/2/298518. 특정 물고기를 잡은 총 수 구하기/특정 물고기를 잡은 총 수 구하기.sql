-- 코드를 작성해주세요
SELECT COUNT(*) as FISH_COUNT
FROM FISH_INFO f
JOIN FISH_NAME_INFO n ON f.fish_type = n.fish_type
WHERE n.fish_name IN ("BASS", "SNAPPER");