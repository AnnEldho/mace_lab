SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE count_employees(dept IN VARCHAR2)
AS
cnt NUMBER;
BEGIN
    SELECT COUNT(*) INTO cnt
    FROM Employee
    WHERE Dept = dept;

    DBMS_OUTPUT.PUT_LINE('Total Employees: ' || cnt);
END;
/

EXEC count_employees('MCA');

/*@pgm32.sql

Procedure created.

Total Employees: 3

PL/SQL procedure successfully completed.

*/