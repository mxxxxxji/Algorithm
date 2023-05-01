-- 코드를 입력하세요
# 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력
# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
# 2022년 11월 1일 부터 2022년 11월 30일까지 대여가능한 자동차
# 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차
# 대여 금액을 내림차순, 자동차 종류를 오름차순, 자동차 ID를 내림차순 

SELECT C.CAR_ID, C.CAR_TYPE,ROUND((C.DAILY_FEE*(1-(P.DISCOUNT_RATE/100))*30),0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS C LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
ON C.CAR_TYPE = P.CAR_TYPE
WHERE P.DURATION_TYPE ='30일 이상' 
    AND C.CAR_ID NOT IN(
                    SELECT C.CAR_ID
                    FROM CAR_RENTAL_COMPANY_CAR AS C LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
                    ON C.CAR_ID = H.CAR_ID
                    WHERE H.END_DATE IN (
                            SELECT MAX(END_DATE)
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                            GROUP BY CAR_ID)
                    AND (CAR_TYPE = '세단' OR CAR_TYPE = 'SUV') 
                    AND H.END_DATE > '2022-11-01'
                    AND H.START_DATE < '2022-12-01'
                    GROUP BY CAR_ID)
    AND (C.DAILY_FEE*(1-(P.DISCOUNT_RATE/100))*30) >= 500000
    AND (C.DAILY_FEE*(1-(P.DISCOUNT_RATE/100))*30) < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC