-- 코드를 작성해주세요
# SELECT SCORE, EMP_NO, EMP_NAME, POSITION, EMAIL
# FROM

SELECT SUM(SCORE) AS SCORE, EMP_NO, (
    SELECT EMP_NAME
    FROM HR_EMPLOYEES
    WHERE HR_GRADE.EMP_NO = HR_EMPLOYEES.EMP_NO
) AS EMP_NAME,
(
    SELECT POSITION
    FROM HR_EMPLOYEES
    WHERE HR_GRADE.EMP_NO = HR_EMPLOYEES.EMP_NO
) AS POSITION, 
(
    SELECT EMAIL
    FROM HR_EMPLOYEES
    WHERE HR_GRADE.EMP_NO = HR_EMPLOYEES.EMP_NO
) AS EMAIL
FROM HR_GRADE
WHERE YEAR = 2022
GROUP BY EMP_NO
ORDER BY SCORE DESC
LIMIT 1