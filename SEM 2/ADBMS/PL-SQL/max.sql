SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION find_max(a NUMBER, b NUMBER)
RETURN NUMBER
IS
BEGIN
   IF a > b THEN
      RETURN a;
   ELSE
      RETURN b;
   END IF;
END;
/

DECLARE
   a NUMBER := &a;
   b NUMBER := &b;
   result NUMBER;
BEGIN
   result := find_max(a,b);
   DBMS_OUTPUT.PUT_LINE('Maximum value is: ' || result);
END;
/
