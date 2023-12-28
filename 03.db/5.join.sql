-- 5.join.sql

/*
1. 조인이란?
	다수의 table간에  공통된 데이터를 기준으로 검색하는 명령어
	다수의 table이란?
		동일한 table을 논리적으로 다수의 table로 간주
			- self join
		물리적으로 다른 table간의 조인

2. 사용 table 
	1. emp & dept 
	  : deptno 컬럼을 기준으로 연관되어 있음

	 2. emp & salgrade
	  : sal 컬럼을 기준으로 연관되어 있음
-- Database 옵션 - Reverse engineer - scott 선택하여 erd그리기

3. table에 별칭 사용 
	검색시 다중 table의 컬럼명이 다를 경우 table별칭 사용 불필요, 
	서로 다른 table간의 컬럼명이 중복된 경우,
	컬럼 구분을 위해 오라클 엔진에게 정확한 table 소속명을 알려줘야 함
	- table명 또는 table별칭
	- 주의사항 : 컬럼별칭 as[옵션], table별칭 as 사용 불가


4. 조인 종류 
	1. equi 조인
		 = 동등비교 연산자 사용
		 : 사용 빈도 가장 높음
		 : 테이블에서 같은 조건이 존재할 경우의 값 검색 

	2. not-equi 조인
		: 100% 일치하지 않고 특정 범위내의 데이터 조인시에 사용
		: between ~ and(비교 연산자)

	3. self 조인 
		: 동일 테이블 내에서 진행되는 조인
		: 동일 테이블 내에서 상이한 칼럼 참조
			emp의 empno[사번]과 mgr[사번] 관계

	4. outer 조인 
		: 두개 이상의 테이블이 조인될때 특정 데이터가 모든 테이블에 존재하지 않고 컬럼은 존재하나 null값을 보유한 경우
		  검색되지 않는 문제를 해결하기 위해 사용되는 조인
		  null 값이기 때문에 배제된 행을 결과에 포함 할 수 있으며 (+) 기호를 조인 조건에서 정보가 부족한 컬럼쪽에 적용
		
		: oracle DB의 sql인 경우 데이터가 null 쪽 table 에 + 기호 표기 
*/
	

-- 1. dept table의 구조 검색

-- dept, emp, salgrade table의 모든 데이터 검색
DESC DEPT;
DESC EMP;
DESC SALGRADE;
/*
*/
-- 1. 동등 조인
-- = 동등 비교
-- 사원들의 이름, 사번, 부서위치 정보 검색 후 출력
SELECT ename, empno, loc, E.DEPTNO
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-- 주의 1 : 명확한 테이블.속성 문법 사용할것
SELECT ename, empno, loc, EMP.deptno
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno;

-- 주의 2 : 조건(다른 테이블에서 공통으로 갖고있는 속성)을 잘 줄것
SELECT ename, empno, loc, emp.deptno
FROM emp, dept;

-- 주의 3 : 테이블의 별칭 사용시 별칭으로만 접근할것 (FROM절이 가장먼저 적용되기 때문)
SELECT ename, empno, loc, E.DEPTNO
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;



-- 2. SMITH 의 이름ename, 사번empno, 근무지역(부서위치)loc 정보를 검색
SELECT ename, empno, loc
FROM emp e, dept d
WHERE E.DEPTNO = D.DEPTNO and e.ename = 'SMITH';


-- 3. deptno가 동일한 모든 데이터 검색
-- emp & dept
SELECT *
FROM emp e, dept d
WHERE E.DEPTNO = D.DEPTNO;




-- 4. 2+3 번 항목 결합해서 SMITH에 대한 모든 정보(ename, empno, sal, comm, deptno, loc) 검색하기
SELECT e.ename, e.empno, d.loc, e.sal, e.comm, e.deptno
FROM emp e, dept d
WHERE E.DEPTNO = D.DEPTNO and ename = 'SMITH';




-- 5.  SMITH에 대한 이름(ename)과 부서번호(deptno), 부서명(dept의 dname) 검색하기
SELECT e.ename, e.deptno, d.dname
FROM emp e , dept d
WHERE e.deptno = d.deptno and e.ename = 'SMITH';


-- 6. 뉴욕에 근무하는 사원의 이름과 급여를 검색 
-- loc='NEW YORK', ename, sal
SELECT e.ename, e.sal, d.loc
FROM emp e , dept d
WHERE e.deptno = d.deptno and d.loc = 'NEW YORK';


-- 7. ACCOUNTING 부서(dname)에 소속된 사원의 이름과 입사일 검색
SELECT e.ename, e.hiredate, d.dname
FROM emp e , dept d
WHERE e.deptno = d.deptno and d.dname = 'ACCOUNTING';


-- 8. 직급이 MANAGER인 사원의 이름, 부서명 검색
SELECT e.ename, d.dname, e.job
FROM emp e , dept d
WHERE e.deptno = d.deptno AND e.job = 'MANAGER';


-- *** 2. not-equi 조인
-- salgrade table(급여 등급 관련 table)
-- 9. 사원의 급여가 몇등급인지 검색
-- between ~ and : 포함
DESC salgrade;

SELECT *
FROM salgrade;



SELECT e.ename, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

-- ? 등급이 3등급인 사원들의 이름과 급여 검색

SELECT e.ename, s.grade
FROM emp e, salgrade s
WHERE s.grade = 3 AND e.sal BETWEEN s.losal AND s.hisal;




-- 10. 사원(emp) 테이블의 부서 번호(deptno)로 부서 테이블을 참조하여 사원명, 부서번호, 부서의 이름(dname) 검색

-- *** 3. self 조인

-- 11. SMITH 직원의 매니저 이름 검색

SELECT m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'SMITH';


-- ? SMITH 직원의 메니저의 부서번호 검색
SELECT m.deptno, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'SMITH';


-- 12. 매니저가 KING인 사원들의 이름과 직급 검색
desc emp;
select * from emp;
select * from dept;


SELECT e.ename, e.job, e.mgr
FROM emp e, emp m
WHERE e.mgr = m.empno AND m.ename = 'KING';


-- 13. SMITH와 동일한 근무지에서 근무하는 사원의 이름 검색
-- SMITH 데이터 절대 검색 불가 - hint 부정 연산자
-- SMITH동일 근무지 - deptno로 검색
-- deptno가 일치되는 사원의 이름 -  ename

SELECT c.ename, c.deptno
FROM emp s , emp c
WHERE s.ename = 'SMITH' AND s.deptno = c.deptno AND c.ename != 'SMITH';




-- *** 4. outer join 
-- 14. 모든 사원명, 매니저 명 검색, 단 매니저가 없는 사원도 검색되어야 함
SELECT e.ename, m.ename
FROM emp e , emp m
WHERE e.mgr = m.empno(+);


-- 15. 모든 직원명, 부서번호, 부서명 검색
SELECT e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- *** hr/hr 계정에서 test
-- 16. 직원의 이름(LAST_NAME)과 직책(job_title)을 출력(검색)
-- 단, 사용되지 않는 직책이 있다면 그 직책이 정보도 검색에 포함

SELECT e.LAST_NAME, j.job_title
FROM employees e, jobs j
WHERE e.job_id(+) = j.job_id;


-- 17. 직원들의 이름(first_name), 입사일, 부서명(department_name) 검색하기
-- 단, 부서가 없는 직원이 있다면 그 직원 정보도 검색에 포함
-- employees, departments

SELECT e.first_name, e.hire_date, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);


-- Natural Join
SELECT e.empno, e.ename, deptno
FROM emp e NATURAL JOIN dept d;

-- ON
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;


SELECT e.ename, e.job, d.dname
FROM emp e JOIN dept d 
ON e.deptno = d.deptno
WHERE e.job = 'MANAGER';


SELECT e.ename, e.job, d.dname
FROM emp e JOIN dept d 
USING (deptno)
WHERE e.job = 'MANAGER';



-- Outer  Join
SELECT e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


SELECT e.ename, d.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;


SELECT e.first_name, e.hire_date, d.department_name
FROM employees e FULL OUTER JOIN departments d
ON e.department_id = d.department_id;


--
SELECT e.ename, d.loc, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno AND (e.sal BETWEEN s.losal AND s.hisal);


SELECT e.ename, d.loc, s.grade
FROM emp e
JOIN dept d USING (deptno)
JOIN salgrade s ON  e.sal BETWEEN s.losal AND s.hisal;



