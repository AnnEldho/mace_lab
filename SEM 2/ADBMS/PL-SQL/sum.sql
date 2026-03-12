SET SERVEROUTPUT ON;

DECLARE
    num1 NUMBER := 20;
    num2 NUMBER := 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE(
        'Sum of ' || num1 || ' and ' || num2 || ' is ' || (num1 + num2)
    );
END;
/

