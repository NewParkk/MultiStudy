-- 11.rownum.sql
-- oracle 자체적으로 제공하는 컬럼
-- table당 자동 생성 객체
-- 검색시 검색된 데이터 순서대로 rownum값 자동 반영(1부터 시작)
SELECT rownum, empno
FROM emp
WHERE rownum < 4;




-- ? dept의 deptno를 내림차순(desc)으로 검색, rownum
SELECT rownum, deptno
FROM dept
ORDER BY deptno desc;



--? deptno의 값이 오름차순으로 정렬해서 30번 까지만 검색, rownum 포함해서 검색
SELECT rownum, deptno
FROM dept
WHERE  deptno <= 30
ORDER BY deptno DESC;
--emp table
--? deptno의 값을 오름차순으로 정렬해서 상위 3개의 데이터만 검색, rownum, ename 포함해서 검색
/* 
1	10	CLARK
2	10	MILLER
3	10	KING
*/
SELECT rownum, deptno, ename
FROM emp 
WHERE rownum < 4
ORDER BY deptno ASC;


-- 해결책 : 인라인 뷰
-- 검색한 결과의 순번을 순차적으로 적용 후 재정렬 
-- 인라인 view : sql의 from 절에 view 문장
SELECT rownum, deptno, ename
FROM (SELECT deptno, ename
            FROM emp 
            ORDER BY deptno ASC)
WHERE rownum < 4;


-- ?1. emp  table의 입사일이 신입(내림)부터 5명의 사원만 검색 
-- 힌트 rownum 컬럼, view 도 사용해서 활용 
-- 인라인 뷰 형식의 쿼리문
/*
1	MILLER	82/01/23
2	JAMES	81/12/03
3	FORD	81/12/03
4	KING	81/11/17
5	MARTIN	81/09/28
*/
SELECT ename, hiredate
FROM (SELECT ename, hiredate 
            FROM emp 
            ORDER BY hiredate DESC)
WHERE rownum < 6;






-- ?2. 인라인 뷰를 사용하여 급여를 많이 받는 순서대로 3명만 이름과 급여 검색 
/*
KING	5000
FORD	3000
JONES	2975
*/

SELECT ename, sal
FROM (SELECT ename, sal
            FROM emp
            ORDER BY sal DESC)
WHERE rownum < 4;


-- 실행 x
SELECT rownum, empno, ename
FROM emp
WHERE rownum > 10;

-- 1 ~ 5 : BETWEEN 1 AND 5
SELECT rownum, empno, ename
FROM emp
WHERE rownum BETWEEN 6 AND 10;

-- rownum 문법상 범위를 지정하려면 무조건 1부터


-- 해결법
-- 페이징 (paging) from절 내의 rownum을 별칭으로 둬서 
-- rownum이 포함된 테이블 자체를 select으로 가져와 사용
SELECT *
FROM(SELECT rownum rn, empno, ename
            FROM (SELECT empno, ename
            FROM emp
            ORDER BY empno ASC))
WHERE rn BETWEEN 6 AND 10;
