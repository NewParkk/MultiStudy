﻿-- 13.index.sql
/*
1. 빠른 검색을 위한 index
	- primary key는 기본적으로 자동 index로 설정됨 
		: 중복 불가인 데이터 구분을 위한 절대 기준데이터 PK
		
	- DB 자체적으로 빠른 검색 기능 부여

	- 기본키 특징
		: 중복 X, 값이 null 허용 X
*/

-- 1. index용 검색 속도 확일을 위한 table 생성
DROP TABLE emp01;
CREATE TABLE emp01 AS SELECT * FROM emp;


-- 2. 테스트를 위한 데이터값 복사
SELECT * FROM emp01;



-- 3. emp01 table에 index 기능 적용
--  어떤 table의 어떤 컬럼에 빠른 검색 지원?
CREATE INDEX idx_emp01_empno ON emp01(empno);
CREATE INDEX idx_emp01_ename ON emp01(ename);

-- 4. SMITH 사번 검색 시간 체크
SELECT *
FROM emp
WHERE ename = 'KING';



-- 5. index 삭제 명령어
DROP INDEX idx_emp01_ename;
