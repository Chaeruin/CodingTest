-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', b.board_id, '/', f.file_id, f.file_name, f.file_ext) as FILE_PATH
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_FILE f ON b.board_id = f.board_id
WHERE b.VIEWS = (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD)
ORDER BY f.file_id DESC;