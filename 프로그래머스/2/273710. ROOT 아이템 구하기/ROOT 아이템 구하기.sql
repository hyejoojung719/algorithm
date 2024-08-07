-- 문제 : ROOT 아이템을 찾아 아이템ID, 아이템명을 출력하는 SQL문 작성 / 아이템ID 기준 오름차순 정렬
SELECT I.ITEM_ID, I.ITEM_NAME
FROM ITEM_INFO I JOIN ITEM_TREE T ON I.ITEM_ID = T.ITEM_ID
WHERE T.PARENT_ITEM_ID IS NULL;