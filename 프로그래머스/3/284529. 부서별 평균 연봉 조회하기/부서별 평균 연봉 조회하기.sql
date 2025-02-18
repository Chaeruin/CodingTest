-- 코드를 작성해주세요
SELECT hd.dept_id, hd.dept_name_en, ROUND(AVG(he.sal),0) as AVG_SAL
FROM HR_DEPARTMENT hd
JOIN HR_EMPLOYEES he ON hd.dept_id = he.dept_id
GROUP BY hd.dept_id
ORDER BY AVG_SAL DESC;