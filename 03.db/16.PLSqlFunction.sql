-- 16.PLSqlFunction.sql
/*
plsql의 종류
1. 익명 블록
	- 이름 없음, 재사용 고려 X, 단순 문법

2. procedure
	- procedure 키워드
	- in/out/inout
	- 재사용, 실행 후 out 데이터 활용
	- return 키워드 미존재
	- 호출 방법 
		1. sql 실행창에서 execute 
		2. java 언어인 경우 jdbc api로 실행
		3. 또 다른 procedure 내에서 실행
		* 일반 함수 호출과 사용하는 방법이 다름
	
3. function
	- funcation 키워드
	- 재사용
	- 반환값 표현, return 키워드
	- 절대 기존 함수명들과 중복 불가
	- 참고
		함수 종류 : 내장 함수 & 사용자 정의 함수
    - 프로시저와 다른 문법
        - 리턴 타입 선언 + 리턴 값
        - return 키워드 활용
*/

-- 1. emp table의 사번으로 사원 이름(리턴 값, 이름의 타입이 리턴타입) 검색 로직 함수 
CREATE OR REPLACE FUNCTION emp_info(v_empno emp.empno%type)
RETURN varchar2
IS
    v_ename varchar2(10);
BEGIN
    SELECT ename
        INTO v_ename
    FROM emp
    WHERE empno = v_empno;
    
    RETURN v_ename;
END;
/


SELECT emp_info(7369)
FROM DUAL;
-- 사용

-- 2.? %type 사용해서 사원명으로 해당 사원의 직무(job) 반환하는 함수 
-- 함수명 : emp_job
CREATE OR REPLACE FUNCTION emp_job(v_ename emp.ename%type)
RETURN emp.job%type
IS
    v_job emp.job%type;
BEGIN
    SELECT job
        INTO v_job
    FROM emp
    WHERE ename = v_ename;
    
    RETURN v_job;
END;
/

SELECT emp_job('SMITH')
FROM DUAL;

-- 3.? 특별 보너스를 지급하기 위한 함수
-- 급여를 200% 인상해서 지급(sal*2)
-- 함수명 : cal_bonus
CREATE OR REPLACE FUNCTION sp_bonus(v_ename emp.ename%type)
RETURN emp.sal%type
IS
    v_sal emp.sal%type;
BEGIN
    SELECT sal
        INTO v_sal
    FROM emp
    WHERE ename = v_ename;
    
    RETURN v_sal*2;
END;
/
SELECT sp_bonus('SMITH')
FROM DUAL;


-- 4.? 부서 번호를 입력 받아 최고 급여액을 반환하는 함수
-- 함수명 : s_max_sal
CREATE OR REPLACE FUNCTION s_max_sal(v_deptno emp.deptno%type)
RETURN emp.sal%type
IS
    v_sal emp.sal%type;
BEGIN
    SELECT max(sal)
        INTO v_sal
    FROM emp
    WHERE deptno = v_deptno;
    RETURN v_sal;
END;
/
SELECT s_max_sal(10)
FROM DUAL;
-- 5. ? 부서 번호를 입력 받아 부서별 평균 급여를 구해주는 함수
CREATE OR REPLACE FUNCTION avg_sal(v_deptno emp.deptno%type)
RETURN emp.sal%type
IS
    avg_sal emp.sal%type;
BEGIN
    SELECT AVG(sal)
        INTO avg_sal
    FROM emp
    WHERE deptno = v_deptno;
    RETURN avg_sal;
END;
/

SELECT avg_sal(30)
FROM DUAL;



-- 함수명 : avg_sal
-- 함수 내부에서 avg() 호출 가능

-- 존재하는 함수 삭제 명령어
-- drop function 함수명;

-- 함수 내용 검색
DESC user_source;
SELECT * FROM user_source;
-- 7. dept table은 pk(deptno) 설정되어 있음, dept에 새로운 데이터 저장 함수 : insert_dept
/* 
1. 필요 sql : insert into dept values(?, ?, ?);
2. 실행 경우의 수
	1. 정상
		insert 완료
	2. 비정상 실행
        ??
3. 설계
	데이터 무결성 문제 발생 시 자동 데이터 변경 후 insert
	dup_val_on_index : exception 활용
*/

-- 8. procedure 또는 function에 문제 발생시 show error로 메세지 출력하기
show error



