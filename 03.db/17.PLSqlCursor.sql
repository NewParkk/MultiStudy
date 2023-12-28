-- 17.PLSqlCursor.sql
/* 
1. 용도
	- 여러 개의 행을 처리하고자 할 때 사용
	- 참고
		: 컴퓨터의 마우스 포인터의 커서와 동일한 개념
			
2. 문법
declare
cursor <cursor_name> is <select statement>;
begin
	for 변수 IN  <cursor_name>
	loop 
		
	end loop;  
end;
/
*/
-- cursor for
-- 1.  emp table의 사번, 이름 검색
set serveroutput on

DECLARE
    CURSOR emp_cursor IS SELECT empno, ename FROM emp;
BEGIN
    FOR emp_data IN emp_cursor LOOP
        dbms_output.put_line(emp_data.empno || ' ' ||  emp_data.ename);
    END LOOP;
END;
/
-- 2. dept의 모든 지역정보를 검색[cursor 기능 부여]
DECLARE
    CURSOR dept_cursor IS SELECT loc FROM dept;
BEGIN
    FOR v_loc IN dept_cursor LOOP
        dbms_output.put_line(v_loc.loc);
    END LOOP;
END;
/
-- 3.? 부서 번호에 해당하는 사번, 사원명 검색
-- create or replace procedure emp_info(v_deptno emp.deptno%type)

CREATE OR REPLACE PROCEDURE emp_info1
(v_deptno emp.deptno%type)
IS
BEGIN
    FOR emp_loop in (
    SELECT empno, ename
    FROM emp
    WHERE v_deptno = deptno
    )
    LOOP
        dbms_output.put_line('사번: ' || emp_loop.empno || ' 사원명 ' || emp_loop.ename);
    END LOOP;
END;
/
/*
7782 CLARK
7839 KING
7934 MILLER
*/
exec emp_info1(10)
/*
7369 SMITH
7566 JONES
7902 FORD
*/
exec emp_info1(20)
/*
7499 ALLEN
7521 WARD
7654 MARTIN
7698 BLAKE
7844 TURNER
7900 JAMES
*/
exec emp_info1(30)
