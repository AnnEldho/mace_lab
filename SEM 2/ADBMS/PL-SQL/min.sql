SET VERIFY OFF;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE find_min(
   a IN NUMBER,
   b IN NUMBER,
   res OUT NUMBER)
IS
BEGIN
   IF a < b THEN
      res := a;
   ELSE
      res := b;
   END IF;
END;
/
DECLARE
   x NUMBER := &x;
   y NUMBER := &y;
   result NUMBER;
BEGIN
   find_min(x,y,result);
   DBMS_OUTPUT.PUT_LINE('Minimum value: ' || result);
END;
/
