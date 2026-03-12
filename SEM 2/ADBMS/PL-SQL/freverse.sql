SET VERIFY OFF;
SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION reverse_string(str VARCHAR2)
RETURN VARCHAR2
IS
   rev VARCHAR2(100) := '';
BEGIN
   FOR i IN REVERSE 1..LENGTH(str) LOOP
      rev := rev || SUBSTR(str,i,1);
   END LOOP;

   RETURN rev;
END;
/
DECLARE
   s VARCHAR2(50) := '&text';
   result VARCHAR2(50);
BEGIN
   result := reverse_string(s);
   DBMS_OUTPUT.PUT_LINE('Reversed String: ' || result);
END;
/
