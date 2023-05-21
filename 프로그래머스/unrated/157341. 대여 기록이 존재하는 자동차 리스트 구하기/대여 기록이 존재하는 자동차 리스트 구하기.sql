-- 코드를 입력하세요
SELECT DISTINCT(A.CAR_ID) AS CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A LEFT JOIN CAR_RENTAL_COMPANY_CAR AS B
ON A.CAR_ID = B.CAR_ID
WHERE B.CAR_TYPE = '세단' AND A.START_DATE LIKE '2022-10%'
ORDER BY CAR_ID DESC