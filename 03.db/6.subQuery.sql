-- 6.subQuery.sql
-- select문 내에 포함된 또 다른 select문 작성 방법
-- 참고 : join 또는 subquery로 동일한 결과값 검색

-- 문법 : 비교 연산자(대소비교, 동등비교) 오른쪽에 () 안에 select문 작성 
-- 	   : create 및 insert 에도 사용 가능
-- 	   : test 위해서 원본이 아닌 복사본 table활용 권장 
-- 실행순서 : sub query가 main 쿼리 이전에 실행

-- 1. SMITH라는 직원 부서명 검색


SELECT d.dname
FROM emp e, dept d
WHERE e.ename = 'SMITH' AND e.deptno = d.deptno;









-- 서브쿼리

-- 2. SMITH와 동일한 직급(job)을 가진 사원들 검색(SMITH 포함)

SELECT ename, job
FROM EMP
WHERE job = (SELECT job
                        FROM emp
                        WHERE ename = 'SMITH');


SELECT e.*
FROM EMP s, EMP e
WHERE s.job = e.job AND s.ename = 'SMITH';

-- 3. SMITH와 급여가 동일하거나 더 많은(>=) 사원명과 급여 검색
-- SMITH 제외해서 검색하기
SELECT sal
FROM emp
WHERE ename = 'SMITH';

SELECT ename, sal
FROM emp
WHERE sal >= (SELECT sal
                        FROM emp
                        WHERE ename = 'SMITH')
AND ename != 'SMITH';






-- 4. DALLAS에 근무하는 사원의 이름, 부서 번호 검색

SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno
                            FROM DEPT
                            WHERE loc = 'DALLAS');

SELECT e.ename, d.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno AND d.loc = 'DALLAS';







-- 5. 평균 급여보다 더 많이 받는(>) 사원만 검색
-- ** where 절에 그룹함수가 사용되는 서브쿼리는 조인으로 변경x
SELECT ename
FROM emp
WHERE sal >= (select avg(sal)
                        FROM emp);




-- 
-- 6.급여가 3000이상 사원이 소속된 부서에 속한  사원이름, 급여 검색
-- 급여가 3000이상 사원의 부서 번호

SELECT ename, sal
FROM emp
WHERE deptno IN (SELECT deptno
                                FROM emp
                                WHERE sal >= 3000);


-- 7. in 연산자를 이용하여 부서별로 가장 급여를 많이 받는 사원의 정보(사번, 사원명, 급여, 부서번호) 검색
-- 사번, 사원명, 급여, 부서번호 
select deptno
from emp
group by deptno;

select max(sal)
from emp
group by deptno;


-- 부서별로 가장 급여를 많이 받는 사원
	
SELECT e.empno, e.ename, e.sal, e.deptno
FROM emp e
WHERE deptno IN (select deptno
                            from emp
                            group by deptno)
    AND sal IN (select max(sal)
                            from emp
                            group by deptno);
    
    
SELECT e.empno, e.ename, e.sal, e.deptno
FROM emp e
WHERE (deptno, sal) IN (SELECT  deptno, max(sal)
                                    FROM emp
                                    GROUP BY deptno);
    
    
    
-- 부서번호 내림차순 정렬

-- 8. 직급(job)이 MANAGER인 사람이 속한 부서의 부서 번호와 부서명(dname)과 지역검색(loc)

SELECT deptno, dname, loc
FROM dept
WHERE deptno in (SELECT deptno
                            FROM emp
                            WHERE job = 'MANAGER');


-- 연산자 정리
-- 서브쿼리 결과가 다중행이기때문에 아래식 오류
SELECT empno, sal
FROM emp
WHERE sal >= (SELECT sal
                        FROM emp
                        WHERE sal > 1000);


-- any
SELECT empno, sal
FROM emp
WHERE sal >= ANY (SELECT sal
                                FROM emp
                                WHERE sal > 1000);
-- all
SELECT empno, sal
FROM emp
WHERE sal >= ALL (SELECT sal
                                FROM emp
                                WHERE sal > 1000);
-- exits, not exists
SELECT ename, comm
FROM emp
WHERE NOT EXISTS (SELECT ename
                        FROM emp
                        WHERE ename = 'x' );

-- 스칼라 서브쿼리 (결과값을 하나만 반환, SELECT절)
-- 사원명, 부서번호, 부서명

SELECT e.ename, e.deptno, d.dname
FROM emp e , dept d
WHERE e.deptno = d.deptno;


SELECT e.ename, e.deptno, ( SELECT d.dname
                                        FROM dept d
                                        WHERE e.deptno = d.deptno)
FROM emp e;


-- 인라인 뷰 (from 서브쿼리, 별칭사용가능)
SELECT *
FROM (SELECT empno, ename
            FROM emp) j;
            
        
-- ename,  deptno,  sal

SELECT e.ename, e.deptno, e.sal
FROM emp e, (SELECT deptno, MAX(sal) ms
                            FROM emp
                            GROUP BY deptno) m
WHERE e.deptno = m.deptno AND e.sal = m.ms;
    

SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno;





