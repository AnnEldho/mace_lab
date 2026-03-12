SET SERVEROUTPUT ON;
SET VERIFY OFF;

DECLARE
    radius NUMBER;
    area   NUMBER;
BEGIN
    radius := &radius;

    area := 3.14 * radius * radius;

    DBMS_OUTPUT.PUT_LINE('Area of circle is: ' || area);
END;
/
