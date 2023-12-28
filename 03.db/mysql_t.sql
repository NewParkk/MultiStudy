/*
[mysql settings]
- download
	https://dev.mysql.com/downloads/
- check
	- cmd
		1) 환경변수 편집
		2) mysql -u 계정명 -p 비밀번호
		3) SHOW DATABASES;
		4) USE 데이터베이스명;
		5) 사용
	- workbench
		1) 접속 확인
		2) 데이터베이스 선택
		3) 사용
*/
/*
[mysql data types]
- https://dev.mysql.com/doc/refman/8.0/en/data-types.html
- https://www.mysqltutorial.org/wp-content/uploads/0211/03/MySQL-Data-Types.jpg
문자형	
	CHAR(n)			고정 길이(최대 255byte): n보다 짦은 데이터 입력시 나머지는 공백으로 채움
	VARCHAR(n)		가변 길이(최대 65535byte)
	TINYTEXT(n)		문자열(최대 255byte)
	TEXT(n)			문자열(최대 65535byte)
	MEDIUMTEXT(n)	문자열(최대 16777215byte)
	LONGTEXT(n)		문자열(최대 4294967295byte)

숫자형	
	TINYINT(n)		정수형(1byte) -128 ~ +127 또는 0 ~ 255
	SMALLINT(n)		정수형(2byte) -32768 ~ 32767 또는 0 ~ 65536
	MEDIUMINT(n)	정수형(3byte) -8388608 ~ +8388607 또는 0 ~ 16777215
	INT(n)			정수형(4byte) -2147483648 ~ +2147483647 또는 0 ~ 4294967295
	BIGINT(n)		정수형(8byte)
	FLOAT(길이,소수)	부동소수형(4byte)
	DECIMAL(길이,소수)	고정소수형(길이+1byte)
	DOUBLE(길이,소수)	부동소수형(8byte)

날짜형
	DATE		날짜(년도, 월, 일)(3byte)
	TIME		시간(시, 분, 초)(3byte)
	DATETIME	날짜와 시간(8byte)
	TIMESTAMP	날짜와 시간(4byte) -시스템 변경 시 자동으로 그 날짜와 시간이 저장
	YEAR		년도 표현(1byte)

이진	/ BLOB : Binary Large Object
	BINARY(n) & BYTE(n)	최대 255byte
	VARBINARY(n)	최대 65535byte)
	TINYBLOB(n)		최대 255byte
	BLOB(n)			최대 65535byte
	MEDIUMBLOB(n)	최대 16777215byte
	LONGBLOB(n)		최대 4294967295byte
*/
/*
[Null Value]
- IFNULL(컬럼, 값) / COALESCE(컬럼, 값)
*/

/*
[FUNCTION]
- TRUNCATE(데이터, 자릿수)
- LENGTH(), CHAR_LENGTH()
- SYSDATE(), NOW()

(ADD/SUB)
- DATE_ADD(date, INTERVAL value addunit)
  ADDDATE(date, INTERVAL value addunit)
- ADDDATE(date, adddays)
- ADDTIME(date, addtime)

- DATEDIFF(date, date)
- TIMESTAMPDIFF(unit, date, date)
	SECOND : 초
	MINUTE : 분
	HOUR : 시
	DAY : 일
	WEEK : 주
	MONTH : 월
	QUARTER : 분기
	YEAR : 연
	
- DAYOFWEEK(date)
- DAYNAME(date)

- DATE_FORMAT(date, format)
	%Y	년도 - Year(4자리 표기)
	%y	년도 (뒤에 2자리 표기)
	%M	월 - 월 이름(January ~ December)
	%m	월 - 월 숫자(00 ~ 12)
	%d	일(00 ~ 31)
	%H	시간 24시간(00 ~ 23)
	%h	시간 12시간(00 ~ 12)
	%i	분 (00 ~ 59)
	%s	초 (00 ~ 59)

- STR_TO_DATE()
- CAST(값 as 데이터형식[길이])
  CONVERT(변환하고싶은 데이터, 데이터형식[(길이)])​
	BINARY 		-- 이진 데이터 
	CHAR 		-- 문자열 타입 
	DATA 		-- 날짜 
	DATATIME 	-- 날짜, 시간 동시에 
	DECIMAL 	-- 소수점 까지 
	JSON 		-- JSON 타입 SIGEND 
	INTEGER 	-- 부호 (음수,양수) 있는 정수형 
	TIME 		-- UNSIGNED INTEGER
*/

/*
[DDL]
- ALTER TABLE 테이블명 ADD 컬럼명 타입;
- ALTER TABLE 테이블명 MODIFY 컬럼명 타입;
- ALTER TABLE 테이블명 CHANGE 컬럼명 변경후이름 타입;
*/

/*
[DML]
- BULK INSERT
	INSERT INTO 테이블명 (컬럼, ...)
		VALUES  (컬럼, ...), 
				(컬럼, ...), 
				(컬럼, ...), 
				(컬럼, ...);
*/

/*
[SCHEMA]
- SELECT * FROM information_schema.table_constraints;

[LIMIT]
- limit(offset, n)

[AUTO_INCREMENT]
AUTO_INCREMENT
*/

/*
[Stored Program]
- PROCEDURE, FUNCTION
	https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html
- TRIGGER
	https://dev.mysql.com/doc/refman/8.0/en/create-trigger.html
*/

