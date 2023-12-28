-- 18.PLSqlTrigger.sql
/*
1. 트리거 Trigger
	- PL/SQL Block으로 특정 이벤트 발생시 연관된 다른 작업이 자동 수행
	- 장점
		: 개발 코드 자체 간소화, 실행 안정성 제공, 로직 처리에 대한 보장

2. 학습
	1. 구성 
	  실행되는 시점(timing) 
	  실행시키는 사건(event) 
	  trigger가 영향받는 table/view../trigger 
	  body

	2. 문법
		create [or replace] trigger trigger_name
		timing
			event 1[ or event2 or ...]
		on 
			table_name or view_name (이벤트가 등록되는 table명)
		[referencing old or new]
		[for each row]
			trigger body
            
	3. 부여설명
		- timing : trigger가 실행되는 시점 지정을 event 발생 전과 후 의미
				- before
				- after

3. 참고
	1. OLD : trigger가 처리한 레코드의 원래 값을 저장
			select 데이터로 간주
			:old
            
	2. NEW : 새로운 값 포함  
			:new 
*/

-- *trigger 생성 변경 삭제 권한 부여
-- 권한이 없을 경우 admin 계정에서 권한 부여
/*
connect system/manager
grant create trigger to SCOTT;
grant alter any trigger to SCOTT;
grant drop any trigger to SCOTT;
conn SCOTT/TIGER
*/

-- 1. 정해진 시간에만 입력한 경우만 입력 허용, 그 외 오류 발생
-- 데이터 값이 아닌 table 자체에 저장 가능한 시간대의 제한
drop table order_table;
create table order_table(
	no number,
	ord_code varchar2(10),
	ord_date date
);

-- 문장 레벨 trigger
/* 1. 오전 10~12시 저장시 insert 허용 
	- 10:00  12:00
	- 시간을 HH:MI
	- sysdate -> 가공(to_char(sysdate, 'HH24:MI')) -> 10:00

    2. 오전 10~11시 저장시에만 insert 허용
*/
drop trigger time_order;

CREATE OR REPLACE TRIGGER time_order
BEFORE
    INSERT
ON
    order_table
BEGIN
    IF TO_CHAR(SYSDATE, 'HH24:mi')  NOT BETWEEN '11:00' AND '12:00' THEN
        RAISE_APPLICATION_ERROR(-20100, '허용시간이 아님');
    END IF;
END;
/


-- test 문장
insert into order_table values(1, 'c001', sysdate);

SELECT * FROM order_table;







-- 2. ord_code 컬럼에 'c001' 제품 번호가 입력될 경우를 제외한 다른 데이터 입력시 에러 발생
-- for each row 키워드 활용
-- insert하려는 새로운 데이터 표현시   :NEW.ord_code
	-- ord_code 컬럼에 c001이 아니면 insert 불가 : 조건식 if 조건식 then 
	-- -20300 무효한 제품 코드

drop trigger data_filter_order;

CREATE OR REPLACE TRIGGER data_filter_order
BEFORE
    INSERT
ON
    order_table
FOR EACH ROW
BEGIN
    IF (:NEW.ord_code) NOT IN ('c001') THEN
        RAISE_APPLICATION_ERROR(-20300, '유효하지 않은 제품 코드');
    END IF;
END;
/


-- test 문장
insert into order_table values(1, 'c001', sysdate);
insert into order_table values(2, 'c002', sysdate);
select * from order_table;

-- 3. 기존 table의 데이터가 업데이트 될 경우 다른 백업 table로 기존 데이터 이관
-- 원본 table : order_table
-- 백업 table : backup_order
-- order_table에 update가 발생(사용자들로 인해)이 되면 자동(trigger)으로 backup_order에 insert

drop table order_table;
create table order_table(
	no number,
	ord_code varchar2(10),
	ord_date date
);

drop table backup_order;
create table backup_order(
	no number,
	ord_code varchar2(10),
	ord_date date
);
select * from order_table;

drop trigger backup_trigger;


-- test 문장
insert into order_table values(1, 'c001', sysdate);
insert into order_table values(2, 'c002', sysdate);

select * from backup_order;
select * from order_table;

CREATE OR REPLACE TRIGGER backup_trigger
BEFORE
    UPDATE
ON
    order_table
FOR EACH ROW
BEGIN
    INSERT INTO backup_order
        VALUES (:OLD.no, :OLD.ord_code, :OLD.ord_date);
END;
/


update order_table set ord_code='c002' where no=1;

select * from backup_order;
select * from order_table;

-- 4. ?기존 table의 데이터가 delete 될때 기존  내용을 backup table로 이동
-- 원본 table : order_table2
-- 백업 table : backup_order2
drop table backup_order2;
drop table order_table2;

create table order_table2(
	no number,
	ord_code varchar2(10)
);

-- 백업 table에 추가된 컬럼 : 삭제 시점
create table backup_order2(
	no number,
	ord_code varchar2(10),
	time date
);

CREATE OR REPLACE TRIGGER backup_delete_trigger
BEFORE
    DELETE
ON
    order_table2
FOR EACH ROW
BEGIN
    INSERT INTO backup_order2
        VALUES (:OLD.no, :OLD.ord_code, SYSDATE);
END;
/



insert into order_table2 values(1, 'c001');

select * from order_table2;
select * from backup_order2;

drop trigger backup_delete_trigger;

-- test 문장
select * from order_table2;
select * from backup_order2;

delete from order_table2 where no=1;

select * from order_table2;
select * from backup_order2;





-- ON UPDATE CASCADE TRIGGER
DROP TRIGGER on_update_trg;
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
ON DELETE CASCADE;

SELECT *
FROM dept02;

SELECT *
FROM emp02;

CREATE OR REPLACE TRIGGER on_update_trg
AFTER UPDATE OF deptno
ON dept02
FOR EACH ROW
BEGIN
    UPDATE emp02
    SET deptno = :NEW.deptno
    WHERE deptno = :OLD.deptno;
END;
/

UPDATE dept02 SET deptno = 11
WHERE deptno = 10;

SELECT *
FROM dept02;

SELECT *
FROM emp02;