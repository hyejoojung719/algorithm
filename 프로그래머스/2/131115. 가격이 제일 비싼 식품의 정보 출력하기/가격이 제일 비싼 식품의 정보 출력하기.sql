-- 문제 : 가격이 제일 비싼 식품의 모든 칼럼 조회
SELECT * 
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);