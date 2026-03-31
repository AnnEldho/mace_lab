/*
sqlplus / as sysdba
SQL> CONNECT sys AS SYSDBA;
Enter password: 
Connected.
SQL> CREATE USER student IDENTIFIED BY 123;
User created.
SQL> GRANT CONNECT, RESOURCE TO student;
Grant succeeded.
SQL> CONNECT student/123;
Connected.
SQL> CREATE TABLE Employee (
    Emp_ID NUMBER,
    Emp_Name VARCHAR2(20),
    DOB VARCHAR2(20),
    Dept VARCHAR2(20),
    Designation VARCHAR2(20),
    Salary NUMBER
);  
Table created.

SQL> INSERT INTO Employee VALUES (1, 'Ann', '1970', 'MCA', 'Ass.Prof', 50000);
COMMIT;
1 row created.

SQL> INSERT INTO Employee VALUES (2, 'John', '1980', 'MCA', 'Prof', 60000);
1 row created.

CREATE TABLE BACKUP_EMPLOYEES AS
SELECT * FROM Employee WHERE 1=0;  2  

Table created.*/

SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER emp_backup_trigger
AFTER DELETE ON Employee
FOR EACH ROW
BEGIN
    INSERT INTO BACKUP_EMPLOYEES
    VALUES (:OLD.Emp_ID, :OLD.Emp_Name, :OLD.DOB, :OLD.Dept, :OLD.Designation, :OLD.Salary);
END;
/

BEGIN
   DELETE FROM Employee WHERE Emp_ID = 1;
   
END;
/

SELECT * FROM BACKUP_EMPLOYEES;

/*
@pgm34.sql
Trigger created.
PL/SQL procedure successfully completed.
EMP_ID EMP_NAME		DOB		     DEPT           DESIGNATION		 SALARY
------  -------     ---          ----           ------------     -------
1        Ann		1970		 MCA            Ass.Prof		  50000
/*

