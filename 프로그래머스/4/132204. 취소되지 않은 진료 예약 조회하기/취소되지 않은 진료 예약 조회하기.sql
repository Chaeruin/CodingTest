-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, a.APNT_YMD
FROM APPOINTMENT a
JOIN DOCTOR d ON a.mddr_id = d.dr_id
JOIN PATIENT p ON p.pt_no = a.pt_no
WHERE DATE_FORMAT(a.APNT_YMD, '%Y-%m-%d') = '2022-04-13' AND a.apnt_cncl_yn = 'N'
ORDER BY a.apnt_ymd