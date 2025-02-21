SELECT HISTORY_ID, 
    ROUND(DAILY_FEE * (DATEDIFF(h.END_DATE, h.START_DATE) + 1)
    * (case when DATEDIFF(END_DATE,START_DATE) + 1 < 7 then 1
        when DATEDIFF(END_DATE,START_DATE) + 1 < 30 then 0.95
        when DATEDIFF(END_DATE,START_DATE) + 1 < 90 then 0.92
        else 0.85 end)) as "FEE"

from CAR_RENTAL_COMPANY_CAR as c 
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    on c.CAR_ID = h.CAR_ID


where c.car_type = "트럭"

group by HISTORY_ID

order by FEE desc , HISTORY_ID desc