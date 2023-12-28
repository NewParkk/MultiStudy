-- 10.view.sql
/*
emp table 에서 comm 존재자체를 다른 직군들에게 모르게 해야 할 경우
table의 데이터를 어떻게 활용 가능하게 할 것인가?
- 실제 존재 하는 table 기반으로 가상의 논리적인 table

* view 사용을 위한 필수 선행 설정
	1단계 : admin 계정으로 접속
	2단계 : view 생성해도 되는 사용자 계정에게 생성 권한 부여
		>connect system/manager
		>grant create view to SCOTT;
		>conn SCOTT/TIGER

1. view 에 대한 학습
	- 물리적으로는 미존재, 단 논리적으로 존재

2. 개념
	- 보안을 고려해야 하는 table의 특정 컬럼값 은닉
	또는 여러개의 table의 조인된 데이터를 다수 활용을 해야 할 경우
	특정 컬럼 은닉, 다수 table 조인된 결과의 새로운 테이블 자체를 
	가상으로 db내에 생성시킬수 있는 기법 

3. 문법
	- create와 drop : create view/drop view
	- crud는 table과 동일

4. view 기반으로 crud 반영시 실제 원본 table에도 반영된다.

5. 종류
	5-1. 단일 view : 별도의 조인 없이 하나의 table로 부터 파생된 view
	5-2. 복합 view : 다수의 table에 조인 작업의 결과값을 보유하는 view
	5-3. 인라인 view : sql의 from 절에 view 문장  

*/
-- 1. test table생성

-- 2. dept01 table상의 view를 생성
-- SCOTT 계정으로 view 생성 권한 받은 직후에만 가능
connect system/manager
grant create view to SCOTT;
conn SSCOTT/TIGER

CREATE VIEW v_dept01 AS SELECT * FROM dept;

DESC v_dept01;

DROP VIEW v_dept01;

-- 3. ? emp table에서 comm을 제외한 emp01_v 라는 view 생성
CREATE VIEW emp01_v AS SELECT empno, ename, sal FROM emp;

SELECT *
FROM emp01_v;


-- 4. dept01_v에 crud : dept01_v와 dept01 table 변화 동시 검색
SELECT *
FROM dept01;

CREATE VIEW dept01_v AS SELECT * FROM dept01;

SELECT *
FROM dept01_v;

INSERT INTO dept01_v VALUES (50, 'IT', 'SEOUL');


-- view에 데이터 삽입시 원본 데이터에서 삽입됨
SELECT *
FROM dept01;



-- 5. 모든 end user가 빈번히 사용하는 sql문장으로 
-- 해당 직원의 모든 정보 검색(empno, ename, deptno, loc)하기

CREATE VIEW emp01_v2 AS 
SELECT e.empno, e.ename, e.deptno, d.loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT * FROM emp01_v2;


INSERT INTO emp01_v2 VALUES (9999, 'dev', 99, 'BUSAN');
UPDATE v_emp SET ename = 'SUPERB'
WHERE ename = 'KING';


-- 6. 논리적인 가상의 table이 어떤 구조로 되어 있는지 확인 가능한 oracle  자체 table
