-- 코드를 작성해주세요
SELECT it.item_id, ii.item_name, ii.rarity
FROM (ITEM_INFO ii
      INNER JOIN ITEM_TREE it ON 
      ii.item_id = it.item_id)
WHERE it.parent_item_id in (SELECT item_id FROM item_info 
                            WHERE rarity = 'RARE')
ORDER BY it.item_id DESC;