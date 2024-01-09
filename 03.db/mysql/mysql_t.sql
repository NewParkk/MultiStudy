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
SHOW TABLES;


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
SELECT * FROM emp;

DESCRIBE EMP;
select empno as 사번 
from emp;

SELECT distinct job
FROM emp;

SELECT ename
FROM EMP
ORDER BY ename ASC;

/*
[Null Value]
- IFNULL(컬럼, 값) / COALESCE(컬럼, 값)
*/
SELECT ename, sal, sal * 12, (sal * 12 + IFNULL(comm, 0))
FROM EMP;

SELECT ename, comm
FROM EMP
WHERE comm IS NULL;

SELECT ename
FROM EMP
WHERE deptno = 10 AND job = 'MANAGER';

SELECT ename
FROM EMP
WHERE deptno <> 10;

SELECT ename, comm
FROM EMP
WHERE comm IN (300, 500, 1400);

SELECT ename, hiredate
FROM EMP
WHERE hiredate between '81/1/1' AND '81/12/3';

SELECT empno, ename
FROM EMP
WHERE ename LIKE '%M%';

-- CAST
-- 1 -> '1'
SELECT CAST(1 AS CHAR(1)) + 1;
SELECT '1' + 1;

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
	DATE 		-- 날짜 
	DATETIME 	-- 날짜, 시간 동시에 
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
-- mysql
CREATE TABLE emp01 as select * from emp;

ALTER TABLE emp01 CHANGE job job2 varchar(20);

select * from emp01;

SELECT 2 + 3;

SELECT 34.56, TRUNCATE(34.5654, 1)
FROM DUAL;

-- lower_case_table_names = 0 으로 속성값을 바꾸면
-- 대소문자 구별 가능
SELECT *
FROM emp
WHERE ename = 'smith';


-- mysql에서는 LENGTH = 메모리크기, CHAR_LENGTH = 길이
SELECT LENGTH('ABC'), LENGTH('가나다')
FROM DUAL;

SELECT LENGTH('ABC'), LENGTH('가나다'), CHAR_LENGTH('ABC'), CHAR_LENGTH('가나다')
FROM DUAL;

SELECT SUBSTR('ABCD',  2, 2)
FROM DUAL;

SELECT CHAR_LENGTH(' ABC ' ), CHAR_LENGTH(TRIM(' ABC' ))
FROM DUAL;


-- 하나의 트랜잭션 내에서 동일한 시간값을 출력하려면 NOW
SELECT SYSDATE(),SLEEP(3),sysdate();
SELECT NOW(),SLEEP(3),NOW();

-- 3개월 후 검색
SELECT hiredate, ADDDATE(hiredate, INTERVAL 3 MONTH)
FROM emp;
-- 3시간 전
SELECT hiredate, SUBDATE(hiredate, INTERVAL 3 HOUR)
FROM emp;

-- DATEDIFF : 차이 일수
SELECT DATEDIFF(SYSDATE(), '2023-01-01');
-- TIMESTAMPDIFF : UNIT단위 차이
SELECT TIMESTAMPDIFF(SECOND, SYSDATE(), '2023-01-01');

-- DAYOFWEEK(date)
-- 1 : 일요일 7 : 토요일
SELECT DAYOFWEEK(SYSDATE());

-- DAYNAME(DATE)
SELECT DAYNAME('2023-01-01');

-- DATE_FORMAT()
SELECT date_format(20231215, '%Y-%m-%d');

-- 데이터 타입 형변환 CONVERT, CAST AS
SELECT CONVERT(20231215, DATE);


DROP TABLE emp01;

CREATE TABLE emp01 AS SELECT empno, sal, hiredate, ename FROM emp;

SELECT *
FROM emp01;

COMMIT;
SET SQL_SAFE_UPDATES = 0;
UPDATE emp01 SET sal = sal * 1.1;

SELECT *
FROM emp01;

ROLLBACK;

SELECT *
FROM emp01;

COMMIT;
SELECT @@autocommit;
-- 1이면 자동으로 커밋!!! -> 0??
-- 1)
SET autocommit = 0;

-- 2)
-- UNION : MERGE + DISTINCT
-- UNION ALL : MERGE


SELECT *
FROM emp
UNION ALL
SELECT *
FROM emp;

/*
[DML]
- BULK INSERT
	INSERT INTO 테이블명 (컬럼, ...)
		VALUES  (컬럼, ...), 
				(컬럼, ...), 
				(컬럼, ...), 
				(컬럼, ...);
*/
DROP TABLE emp02;

-- 1) 컬럼레벨에서는 제약조건 이름 사용불가,
-- 테이블 컬럼 선언 이후에도 제약조건 추가 불가능
CREATE TABLE emp02(
    empno int(4) PRIMARY KEY,
    ename varchar(10)
);

-- 2) 외부에서는 제약조건명 사용 가능
ALTER TABLE emp02
ADD CONSTRAINT emp02_empno_pk PRIMARY KEY(empno);











drop table dept02;
drop table emp02;
create table dept02 as select * from dept;
create table emp02 as select * from emp;

ALTER TABLE dept02
ADD CONSTRAINT dept02_deptno_pk PRIMARY KEY(deptno);

ALTER TABLE emp02
ADD CONSTRAINT emp02_empno_pk PRIMARY KEY(empno);

ALTER TABLE emp02
ADD CONSTRAINT emp02_deptno_fk FOREIGN KEY(deptno) REFERENCES dept02(deptno) 
ON DELETE CASCADE ON UPDATE CASCADE;

SELECT *
FROM dept02 ;

SELECT *
FROM emp02;

UPDATE dept02 SET deptno = 11
WHERE deptno = 10;

SELECT *
FROM dept02;

SELECT *
FROM emp02;






SELECT * FROM information_schema.table_constraints;
/*
[SCHEMA]
- SELECT * FROM information_schema.table_constraints;

[LIMIT]
- limit(offset, n)

[AUTO_INCREMENT]
AUTO_INCREMENT
*/

CREATE VIEW emp01_v AS SELECT empno, ename, sal FROM emp;

SELECT *
FROM emp01_v;

DROP VIEW emp01_v;

SELECT *
FROM information_schema.views
WHERE table_schema = 'SCOTT';

-- WITH

WITH temp_table AS
(
SELECT 1 AS no
UNION ALL
SELECT 2 AS no
)

SELECT * 
FROM temp_table;

-- LIMIT

SELECT empno, deptno
FROM emp
LIMIT 0, 10;

SELECT empno, deptno
FROM emp;


-- AUTO_INCREMENT
DROP TABLE people;

CREATE TABLE people (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20)
);

INSERT INTO people(name) VALUES ('IT');

SELECT * 
FROM people;


ALTER TABLE people AUTO_INCREMENT = 1;

INSERT INTO people(name) VALUES('IT');

SELECT *
FROM people;


-- INDEX 삭제 : DROP INDEX 인덱스명 ON 테이블명;
-- PK, UNIQUE 인덱스는 직접적으로 제거할 수 없다!
DROP INDEX idx_emp01_ename ON emp01;

-- 변수
-- SET, SELECT
SET @height = 180;

SELECT @height;

SELECT @weight := 80;

SELECT @weight;


-- 시스템 변수 : @@변수명

SHOW GLOBAL VARIABLES;


-- 조건
-- IF(조건문, 참, 거짓)

SET @num = 30;

SELECT IF(@num < 50, 'FAIL', 'PASS');

-- EMP 테이블에서 sal >= 3000 이상이면 GOOD, ??
SELECT sal, IF(sal >= 3000, 'GOOD', '??')
from emp;


-- CASE
SELECT grade, CASE
				WHEN GRADE = 1 THEN '아이언'
				WHEN GRADE = 2 THEN '브론즈'
                END AS '등급'
FROM SALGRADE;





/*
[Stored Program]
- PROCEDURE, FUNCTION
	https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html
- TRIGGER
	https://dev.mysql.com/doc/refman/8.0/en/create-trigger.html
*/


DROP PROCEDURE IF EXISTS  testProc;

DELIMITER //
CREATE PROCEDURE  testProc()
BEGIN
	SELECT *
    FROM emp;
END //
-- DELEMITER(공백); 지켜야함
DELIMITER ;

CALL testProc();


-- 사원번호로 근무지역 출력 : getLOC
DROP PROCEDURE IF EXISTS getLOC;


DELIMITER //
CREATE PROCEDURE getLOC(IN i_empno INT, OUT o_loc VARCHAR(20))
BEGIN
	SELECT d.loc
		INTO o_loc
    FROM emp e,dept d
    WHERE e.deptno = d.deptno AND e.empno = i_empno;
END //
DELIMITER ;


CALL getLOC(7369,@loc);
SELECT @loc;

-- 사원번호로 사원이름 검색 : getName(i_empno INT)
DELIMITER //
CREATE FUNCTION getName(i_empno INT)
	RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
	DECLARE o_ename VARCHAR(20);
    
	SELECT ename
		INTO o_ename
	FROM emp
	WHERE empno = i_empno;
    
    RETURN o_ename;
END //
DELIMITER ;

SELECT getName(7369);

DROP FUNCTION IF EXISTS getName;


-- BACKUP TRIGGER
drop table order_table;
create table order_table(
	no int,
	ord_code varchar(10),
	ord_date date
);

drop table backup_order;
create table backup_order(
	no int,
	ord_code varchar(10),
	ord_date date
);
select * from order_table;

drop trigger backup_trigger;


-- test 문장
insert into order_table values(1, 'c001', sysdate());
insert into order_table values(2, 'c002', sysdate());

select * from backup_order;
select * from order_table;

--
DELIMITER //
CREATE TRIGGER backup_trigger
	BEFORE UPDATE
    ON order_table
    FOR EACH ROW
BEGIN
	INSERT INTO backup_order
		VALUES(OLD.no, OLD.ord_code, OLD.ord_date);
END //
DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
update order_table set ord_code='c002' where no = 1;

-- WHILE
DROP PROCEDURE IF EXISTS while_loop;

DELIMITER //
CREATE PROCEDURE while_loop()
BEGIN
	DECLARE i INT;
    
    SET i = 1;
    
    WHILE i <= 10 DO
		SELECT i;
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

CALL while_loop();



-- LOOP
DROP PROCEDURE IF EXISTS standard_loop;

DELIMITER //
CREATE PROCEDURE standard_loop()
BEGIN
	DECLARE i INT;
    
    SET i = 1;
    
    s_loop:LOOP
		
        IF i > 10 THEN
			LEAVE s_loop;
        ELSEIF i <= 10 THEN 
			SELECT i;
			SET i = i + 1;
		END IF;
    
    END LOOP;
END //
DELIMITER ;

CALL standard_loop();



-- CURSOR
drop procedure if exists empCursor;

delimiter //
create procedure empCursor()
begin
    declare o_empno int; -- 
    declare o_ename varchar(20);
    
    declare endOfRow BOOLEAN default FALSE;
    
    declare empCursor cursor for
        select empno, ename from emp;
        
    declare continue handler for not found
        set endOfRow = TRUE;
        
    open empCursor;
    
    cursor_loop: loop
        fetch empCursor 
			into o_empno, o_ename;
            
        if endOfRow then
            leave cursor_loop;
        end if;
        
        case
            when o_empno = 7369 then set o_empno = o_empno and o_ename = o_ename;
            else iterate cursor_loop;
        end case;
        
    end loop cursor_loop;
    
    select o_empno, o_ename;
end //
delimiter ;

call empCursor();writingbookauthor


SELECT * FROM dept;
SELECT * FROM emp01;
SELECT * FROM news;


CREATE TABLE emp12 
	AS SELECT * 
    FROM emp
    where 1!=1;
    
DROP TABLE emp12;

SELECT*
FROM information_schema.table_constraints
WHERE table_schema = 'SCOTT';


SELECT *
FROM dept02;

delete from movie;emp01

INSERT INTO dept VALUES(10, 'ACCOUNTING', 'SEOUL');




USE login;

insert into user values("hj", "혜진", 1234);
insert into user values("dw", "대원", 4567);
insert into user values("hc", "현철", 7894);
insert into user values("ws", "원상", 4062);
commit;

insert into notice_board values();
SET SQL_SAFE_UPDATES = 0;

select * from notice_board;
DELETE FROM notice_board;

INSERT INTO notice_board  
VALUES 
('공지사항 제목 1', '2024-01-04 10:00:00', '이것은 첫 번째 공지사항 내용입니다.', 'user123');
INSERT INTO notice_board 
VALUES 
(NULL, '공지사항 제목 1', CURRENT_TIMESTAMP, '이것은 첫 번째 공지사항 내용입니다.', 'dw');

ALTER TABLE notice_board AUTO_INCREMENT = 1;

SHOW VARIABLES LIKE 'character_set%';
SHOW VARIABLES LIKE 'collation%';

SHOW FULL COLUMNS FROM notice_board;

select * from user;




SELECT @ROWNUM:=@ROWNUM+1 AS ROWNUM
     , notice_board.notice_title
     , notice_board.notice_date
     , notice_board.user_id
  FROM notice_board;
  
  
  
select *
from (
SELECT
	@ROWNUM:=@ROWNUM+1 as board_num
	, n.notice_id
    , n.notice_date
    , n.notice_title
    , n.notice_content
    , n.user_id
FROM notice_board n
WHERE (@ROWNUM:=0)=0
) A 
order by board_num desc;

select *
from notice_board;

delete from notice_board where notice_id = 4;


ALTER TABLE notice_board modify column notice_content varchar(4000);

select *
from user;