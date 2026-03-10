SET SERVEROUTPUT ON;
SET VERIFY OFF;

DECLARE
    str VARCHAR2(50);
    rev VARCHAR2(50) := '';
BEGIN
    str := '&str';

    FOR i IN REVERSE 1..LENGTH(str) LOOP
        rev := rev || SUBSTR(str, i, 1);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Reversed String: ' || rev);
END;
/
