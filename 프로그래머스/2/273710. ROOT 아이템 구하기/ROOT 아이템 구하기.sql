-- 코드를 작성해주세요
SELECT ii.item_id, ii.item_name
FROM ITEM_INFO ii
JOIN ITEM_TREE it ON ii.item_id = it.item_id
WHERE it.parent_item_id is null
ORDER BY ii.item_id ASC;