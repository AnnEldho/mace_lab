SET SERVEROUTPUT ON;

DECLARE
    num1 NUMBER;
    num2 NUMBER;
BEGIN
    num1 := &num1;
    num2 := &num2;

    IF num1 > num2 THEN
        DBMS_OUTPUT.PUT_LINE('Maximum number is: ' || num1);
    ELSE IF num2 > num1 THEN
        DBMS_OUTPUT.PUT_LINE('Maximum number is: ' || num2);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Both numbers are equal.');
    END IF;
END;
/
