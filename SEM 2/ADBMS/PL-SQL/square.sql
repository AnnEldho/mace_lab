SET VERIFY OFF;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE square_num(n IN OUT NUMBER)
IS
BEGIN
   n := n * n;
END;
/
DECLARE
   num NUMBER := &num;
BEGIN
   square_num(num);
   DBMS_OUTPUT.PUT_LINE('Square is: ' || num);
END;
/
