CREATE OR REPLACE PROCEDURE calc_total(
    rno IN NUMBER,
    m1 IN NUMBER,
    m2 IN NUMBER,
    m3 IN NUMBER
)
AS
tot NUMBER;
BEGIN
    tot := m1 + m2 + m3;

    INSERT INTO sessional_exam
    VALUES (rno, m1, m2, m3, tot);

    DBMS_OUTPUT.PUT_LINE('Total Marks: ' || tot);
END;
/

BEGIN
	calc_total(101, 80, 85, 90);
END;
/
/*
@pgm33.sql

Procedure created.

Total Marks: 255

PL/SQL procedure successfully completed.

*/