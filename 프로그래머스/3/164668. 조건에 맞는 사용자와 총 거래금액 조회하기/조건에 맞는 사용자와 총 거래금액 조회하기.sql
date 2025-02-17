-- 코드를 입력하세요
select ub.writer_id, uu.nickname, sum(ub.price) as TOTAL_SALES
from used_goods_board ub
join used_goods_user uu on ub.writer_id = uu.user_id
where status = "DONE"
group by ub.writer_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES asc;