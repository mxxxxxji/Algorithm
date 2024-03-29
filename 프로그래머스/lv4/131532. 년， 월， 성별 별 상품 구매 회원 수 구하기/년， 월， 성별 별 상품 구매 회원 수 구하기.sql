-- 코드를 입력하세요
SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, I.GENDER AS GENDER, COUNT(DISTINCT(O.USER_ID)) AS USERS
FROM ONLINE_SALE AS O LEFT JOIN USER_INFO AS I 
ON O.USER_ID = I.USER_ID
WHERE I.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER
