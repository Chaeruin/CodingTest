-- 코드를 입력하세요
SELECT cc.car_id
FROM CAR_RENTAL_COMPANY_CAR cc
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY rh ON cc.car_id = rh.car_id
WHERE cc.car_type = '세단' AND MONTH(rh.start_date) = 10
GROUP BY cc.car_id
ORDER BY cc.car_id DESC;