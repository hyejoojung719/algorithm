-- [문제]
-- 이 문제에서 더 이상 업그레이드 할 수 없는 아이템 == 리프노드
-- 즉, 자신을 부모노드로 갖는 ITEM이 없는 경우에만 데이터 조회

SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID NOT IN (SELECT DISTINCT PARENT_ITEM_ID FROM ITEM_TREE WHERE PARENT_ITEM_ID IS NOT NULL)
ORDER BY ITEM_ID DESC;
