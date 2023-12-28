-- 8.DML.sql
/* 
- DML : Data Mainpulation Language
            데이터 조작 언어
	   (select/insert/update/delete 모두 다 DML)
		- 이미 존재하는 table에 데이터 저장, 수정, 삭제, 검색

- 영구 저장
	1. insert/update/delete 문장에만 영향을 줌
	2. sql문장을 실행시킨 프로그램상에서만 영향을 줌(DML 작업한 sw상에서만 commit / rollback 유효)
	3. 가급적 sql문장 backup시 insert 문장이 있을 경우 습관적으로 마지막에 commit; 필수(*)
	4. 저장시 : commit
	   복원시 : rollback
       
- 참고 : sql 작업을 편리하게 지원하는 tool들은 auto commit 기능 내포
	
	
1. insert 
	1-1. 모든 컬럼에 데이터 저장
		table 구조상의 컬럼 순서에 맞게 모든 데이터 저장시 사용
		insert into table명 values(데이터값1, ...)

	1-2. 특정 컬럼에만 데이터 저장
		명확하게 컬럼명 기술 
		insert into table명 (컬럼명1,...) values(컬럼과매핑될데이터1...)

2. update 
	2-1. 모든 table(다수의 row)의 데이터 한번에 수정
		where조건문 없는 문장
		update table명 set 컬럼명=수정데이타;

	2-2. 특정 row값만 수정
		where조건문으로 처리하는 문장
		update table명 set 컬럼명=수정데이타 where 조건sql;
        
3. delete
    3-1. table 데이터 삭제
        delete from 테이블명;
*/

--  *** insert 
DROP TABLE people;

CREATE TABLE people(
        name varchar2(20),
        age number(3)
);





-- 1. 컬럼명 기술없이 데이터 입력
INSERT INTO people VALUES('준희', 23);

select * from people;




-- 2. 컬럼명 기술후 데이터 입력 
INSERT INTO people(name, age) VALUES('서현', 24);







-- 3. 다중 table에 한번에 데이터 insert하기 
DROP TABLE emp01;
DROP TABLE emp02;

CREATE TABLE emp01 AS SELECT empno, ename, deptno FROM emp WHERE 1 = 0;
CREATE TABLE emp02 AS SELECT empno, ename, deptno FROM emp WHERE 1 = 0;

select * from emp01;
desc emp01;

INSERT ALL
        INTO emp01 (empno, ename, deptno) VALUES (empno, ename, deptno)
        INTO emp02 (empno, ename, deptno) VALUES (empno, ename, deptno)
SELECT empno, ename, deptno FROM emp;


-- 4. ? 부서 번호가 10인 데이터는 emp01에 저장, 
--  부서 번호가 20 or 30인 데이터는 emp02에 저장
--  조건 표현 : when~then

TRUNCATE TABLE emp01;
TRUNCATE TABLE emp02;

INSERT ALL
        WHEN deptno = 10 THEN
                INTO emp01 (empno, ename, deptno) VALUES (empno, ename, deptno)
        WHEN deptno = 20 or deptno = 30 THEN
                INTO emp02 (empno, ename, deptno) VALUES (empno, ename, deptno)
SELECT empno, ename, deptno FROM emp;


select * from emp02;

--  *** update
-- 1. 테이블의 모든 행 변경
DROP TABLE emp01;

CREATE TABLE emp01 AS SELECT * FROM emp;
SELECT *
FROM emp01;

UPDATE emp01 SET deptno = 60;



--  60이전의 데이터로 복원
ROLLBACK;

SELECT *
FROM emp01;




-- 2. emp01 table의 모든 사원의 급여를 10%(sal*1.1) 인상하기
UPDATE emp01 SET sal = sal*1.1;

SELECT *
FROM emp01;

-- ? emp table로 부터 empno, sal, hiredate, ename 순으로 table 생성
DROP TABLE emp01;

CREATE TABLE emp01 AS SELECT empno, sal, hiredate, ename, deptno, job FROM emp;

SELECT *
FROM emp01;


-- 3. emp01의 모든 사원의 입사일을 오늘로 바꿔주세요
UPDATE emp01 SET hiredate = sysdate;
--  4. 급여가 3000이상인 사원의 급여만 10%인상
UPDATE emp01 SET sal = sal*1.1 WHERE sal >= 3000;
-- 5. ?emp01 table 사원의 급여가 1000이상인 사원들의 급여만 500원씩 삭감 
UPDATE emp01 SET sal = sal-500 WHERE sal >= 1000;
-- 6. ?emp01 table에 DALLAS(dept의 loc)에 위치한 부서의 소속 사원들의 급여를 1000인상
SELECT * FROM DEPT;
SELECT * FROM emp01;
select deptno from dept where loc = 'DALLAS';


UPDATE emp01  SET sal = sal+1000 WHERE deptno IN (select deptno from dept where loc = 'DALLAS');
-- 문제 해결1.
ALTER TABLE emp01 MODIFY(deptno number(3));
SELECT * FROM emp01;

-- 문제해결2.
INSERT ALL
        INTO emp01(deptno) VALUES(deptno)
SELECT deptno FROM emp;

ROLLBACK;

-- 7. emp01 table의 SMITH 사원의 부서 번호를 30으로, 직급은 MANAGER 수정
UPDATE emp01
SET deptno = 30, job = 'MANAGER'
WHERE ename = 'SMITH';









--  *** delete 
-- 8. table 모든 데이터 삭제
SELECT *
FROM emp01;

DELETE FROM emp01;

SELECT *
FROM emp01;



-- 9. 특정 row 삭제(where 조건식 기준)
-- emp01 에서 10번만 삭제

DELETE FROM emp01 WHERE deptno = 10;

DROP TABLE emp01;

CREATE TABLE emp01 AS SELECT * FROM emp;


-- 10. ? emp01 table에서 comm 존재 자체가 없는(null) 사원 모두 삭제

DELETE FROM emp01 WHERE comm is null;


-- 11. ? emp01 table에서 comm이 null이 아닌 사원 모두 삭제
DELETE FROM emp01 WHERE comm is not null;


-- 12. ? emp01 table에서 부서명이 RESEARCH 부서에 소속된 사원 삭제 
ROLLBACK;
DELETE FROM emp01 WHERE deptno = (select deptno from dept where dname = 'RESEARCH');

SELECT * FROM emp01;


-- 13. table 내용 삭제
-- insert/update/delete 문장에 한해서만 commit과 rollback 명령어 적용 가능
SELECT * FROM emp01;
ROLLBACK;
DELETE FROM emp01;
--  *** merge[병합]
-- 14. 병합을 위한 test table생성 및 데이터 insert
--  ex 판매 관련 table
drop table produce01;
drop table produce02;
drop table produce_total;

create table produce01(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
create table produce02(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
create table produce_total(
	판매번호 varchar2(5), 
	제품번호 char(4),
	수량 number(3),
	금액 number(5)
);
--  test용 데이터 insert
insert all
	into produce01 values('101', '1000', 1, 500)
	into produce01 values('102', '1001', 1, 400)
	into produce01 values('103', '1003', 1, 300)
	into produce02 values('201', '1004', 1, 500)
	into produce02 values('202', '1005', 1, 600)
	into produce02 values('203', '1006', 1, 700)
select * from dual;


--  merge 작업 : produce01과 produce_total 병합
--  문제 분석
--  실행 결과 확인
-- ? produce02 table과 produce_total table 병합

MERGE INTO produce_total t
USING produce01 p1 
ON (t.판매번호 = p1.판매번호)
WHEN MATCHED THEN
        UPDATE SET t.수량 = t.수량 + p1.수량
WHEN NOT MATCHED THEN
        INSERT VALUES (p1.판매번호, p1.제품번호, p1.수량, p1.금액);








