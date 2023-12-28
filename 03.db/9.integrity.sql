-- 9.integrity.sql
-- DB 강제 제약 설정

/* dept : emp
1. 공통컬럼 : deptno
2. 어떤 table의 deptno가 종속적인지?
	- 제시하는 table : dept
	- 사용하는 table : emp
3. 제약 사항
	1. dept의 deptno값은 중복 불허, 반드시 값이 있어야만 함
		- 중복 불허 : UNIQUE
		- 반드시 값이 있어야 함 : NOT NULL (nn)
		- primary key(기본키), pk : UNIQUE + NOT NULL
		
	2. emp의 deptno는 반드시 dept의 deptno에서 제시한 데이터에 한해서만 사용 가능
		- deptno : 종속 참조(foreign key(외래키), fk)
		
4. 제약조건 선언 위치
	4-1. 컬럼 레벨 단위
		- 컬럼선언 라인에 제약조건 설정 

	4-2. 테이블 레벨 단위 
		- 모든 컬럼 선언 직후 별도로 제약조건 설정
        
	- 참고 : table 복제시 제약조건은 반영 x, 차후에 명시적으로 추가 설정
			
5. 오라클 table
	5-1. user_constraints
		- 제약조건 정보 보유 table
		- 개발자가 table의 데이터값 직접 수정 불가
		- select constraint_name, constraint_type, table_name 
			from user_constraints;

6. 이미 존재하는 table의 제약조건 수정(추가, 삭제)명령어
	6-1. 제약조건 추가
		alter table 테이블명 add constraint 제약조건명 제약조건(컬럼명);
	
	6-2. 제약조건 삭제(drop)
		- table삭제 
		alter table 테이블명 cascade constraint;
		
	6-3. 제약조건 임시 비활성화
		alter table 테이블명 disable constraint;
		
	6-4. 제약조건 활성화
		alter table 테이블명 enable constraint;
*/

-- 1. 오라클 db에 설정한 table의 제약조건 정보를 보유하고 있는
-- 오라클 :  user_constraints 
SELECT *
FROM user_constraints;


/* constraint_type : 제약조건 정보 컬럼
	P : 기본키, Primary key, 주키
	R : 참조 or 관계 (reference or relation), 외래키
*/

-- 2. 제약 조건 명시
DROP TABLE emp02;

CREATE TABLE emp02(
        empno number(4) CONSTRAINT emp02_empno_nn NOT NULL,
        ename varchar(10)      
);

SELECT *
FROM user_constraints;


-- 3. 확인
INSERT INTO emp02(ename) VALUES('dev');



-- 4. 오라클 엔진이 제약조건명 자동 지정
-- 제약조건 이름짓기 TABLE_COLUMN_제약조건
DROP TABLE emp02;

CREATE TABLE emp02(
        empno number(4) UNIQUE,
        ename varchar2(10)
);
-- 5. pk설정 : 선언 위치에 따른 구분 학습
-- 컬럼 레벨

DROP TABLE emp02;

CREATE TABLE emp02(
        empno number(4) CONSTRAINT emp02_empno_pk PRIMARY KEY,
        ename varchar2(10)
);

INSERT INTO emp02 VALUES(1, 'dev');
INSERT INTO emp02 VALUES(1, 'it');

-- table 레벨
DROP TABLE emp02;

CREATE TABLE emp02(
        empno number(4),
        ename varchar2(10)
);

ALTER TABLE emp02
ADD CONSTRAINT emp02_empno_pk PRIMARY KEY(empno);

INSERT INTO emp02 VALUES(1, 'dev');
INSERT INTO emp02 VALUES(1, 'it');

-- 6. 외래키[참조키]
-- 컬럼 레벨  
DROP TABLE emp02;

CREATE TABLE emp02(
        empno number(4) PRIMARY KEY,
        ename varchar2(10) NOT NULL,
        deptno number(4) CONSTRAINT emp02_deptno_fk REFERENCES dept (deptno)
);


INSERT INTO emp02 VALUES(9999, 'dev', 40);
SELECT * FROM emp02;


INSERT INTO emp02 VALUES(8888, 'it', 50);

-- table 레벨
DROP TABLE emp02;

CREATE TABLE emp02;

CREATE TABLE emp02(
        empno number(4) PRIMARY  KEY,
        ename varchar2(10) NOT NULL,
        deptno  number(4),
        CONSTRAINT emp02_deptno_fk FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

-- 7. 6번의 내용을 table 레벨 단위로 설정해 보기
CREATE TABLE emp02(
        empno number(4) PRIMARY  KEY,
        ename varchar2(10) NOT NULL,
        deptno  number(4)
);

ALTER TABLE emp02
ADD CONSTRAINT emp02_empno_pk PRIMARY KEY(empno);

ALTER TABLE emp02
ADD CONSTRAINT emp02_ename_nn NOT NULL(ename);

ALTER TABLE emp02
ADD CONSTRAINT emp02_deptno_fk FOREIGN KEY(deptno) REFERENCES dept(deptno);
-- 8. emp01과 dept01 table 생성
/* as 로 기존 table 복제할 경우엔 제약조건은 반영되지 않음
따라서 alter 명령어로 추가 적용 필수*/

drop table dept01;
drop table emp01;
create table dept01 as select * from dept;
create table emp01 as select * from emp;

-- 9. 존재하는 table에 제약조건 추가
-- dept01 : 주(부모), emp01 : 종(자식)
ALTER TABLE dept01
ADD CONSTRAINT dept01_deptno_pk PRIMARY KEY (deptno);

ALTER TABLE emp01
ADD CONSTRAINT emp01_empno_pk PRIMARY KEY (empno);

ALTER TABLE emp01
ADD CONSTRAINT emp01_deptno_fk FOREIGN KEY(deptno) REFERENCES dept01(deptno);

COMMIT;




-- 10. 
-- emp01이 이미 참조하는 데이터가 있는 dept01 table 삭제해보기 
DELETE FROM dept01
WHERE deptno = 40;

SELECT * FROM dept01;

DELETE FROM dept01
WHERE deptno = 10;


SELECT * FROM emp01;

-- 11.참조되는 컬럼 데이터라 하더라도 삭제 가능한 명령어

drop table dept02;
drop table emp02;
create table dept02 as select * from dept;
create table emp02 as select * from emp;

ALTER TABLE dept02
ADD CONSTRAINT dept02_deptno_pk PRIMARY KEY(deptno);

ALTER TABLE emp02
ADD CONSTRAINT emp02_empno_pk PRIMARY KEY(empno);

ALTER TABLE emp02
ADD CONSTRAINT emp02_deptno_fk FOREIGN KEY(deptno) REFERENCES dept02(deptno) ON DELETE CASCADE;

DELETE FROM dept02
WHERE deptno = 10;

SELECT * FROM dept02;
SELECT * FROM emp02;


-- 참조키를 부모에서 삭제하고 자식에게는 null값 세팅
drop table dept03;
drop table emp03;
create table dept03 as select * from dept;
create table emp03 as select * from emp;

ALTER TABLE dept03
ADD CONSTRAINT dept03_deptno_pk PRIMARY KEY(deptno);

ALTER TABLE emp03
ADD CONSTRAINT emp03_empno_pk PRIMARY KEY(empno);

ALTER TABLE emp03
ADD CONSTRAINT emp03_deptno_fk FOREIGN KEY(deptno) REFERENCES dept03(deptno) ON DELETE SET NULL;

DELETE FROM dept03
WHERE deptno = 10;

SELECT * FROM dept03;
SELECT * FROM emp03;




-- 12. check : 데이터의 유효 유무 검증 제약조건 
-- age값이 1~100까지만 DB에 저장
DROP TABLE dev;
CREATE TABLE dev(
        ename varchar2(20),
        age number(3) CHECK(age BETWEEN 1 AND 200)
);

INSERT INTO dev VALUES ('it', 201);


-- 13.? gender라는 컬럼에는 데이터가 M 또는 F만 저장되어야 함
DROP TABLE dev;
CREATE TABLE dev(
        ename varchar2(20),
        gender char(1) CHECK (gender IN ('M','F'))
);



-- 14. default : insert시에 데이터를 생략해도 자동으로 db에 저장되는 기본값 
CREATE TABLE dev (
        ename varchar2(20) NOT NULL,
        company char(1) DEFAULT 'S'
);

SELECT * FROM dev;
INSERT INTO dev VALUES ('it', 'D');
INSERT INTO dev(ename)  VALUES ('backend');

