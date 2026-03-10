SET SERVEROUTPUT ON;

DECLARE
    num NUMBER;         
    fact NUMBER := 1;    
BEGIN
    
    num := &Enter_Number;

    IF num < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Factorial is not defined for negative numbers.');
    ELSE
        FOR i IN 1..num LOOP
            fact := fact * i;
        END LOOP;

        DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is: ' || fact);
    END IF;
END;
/
