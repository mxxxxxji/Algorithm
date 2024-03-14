SELECT A.TITLE,	A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, 
        DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_REPLY AS B LEFT JOIN USED_GOODS_BOARD AS A
ON A.BOARD_ID = B.BOARD_ID
WHERE A.CREATED_DATE LIKE '2022-10-%'
ORDER BY B.CREATED_DATE, A.TITLE