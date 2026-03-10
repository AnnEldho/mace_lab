SET VERIFY OFF;
SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION area_circle(r NUMBER)
RETURN NUMBER
IS
BEGIN
   RETURN 3.1416 * r * r;
END;
/
DECLARE
   r NUMBER := &radius;
   result NUMBER;
BEGIN
   result := area_circle(r);
   DBMS_OUTPUT.PUT_LINE('Area of Circle: ' || result);
END;
/
