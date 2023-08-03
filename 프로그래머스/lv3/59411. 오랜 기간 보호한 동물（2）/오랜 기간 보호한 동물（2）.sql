-- 코드를 입력하세요
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS AS A JOIN ANIMAL_OUTS AS B 
ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY DATEDIFF(B.DATETIME, A.DATETIME) DESC
LIMIT 2
# WHERE A.ANIMAL_ID IN (
#     SELECT DATEDIFF(B.DATETIME, A.DATETIME) AS DATE
#     FROM ANIMAL_OUTS AS B LEFT JOIN ANIMAL_INS AS A 
#     ON A.ANIMAL_ID = B.ANIMAL_ID
#     ORDER BY DATE DESC
# )

