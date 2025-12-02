const con = require('./db_connect');
const sql = 'INSERT INTO students(id,name,age,course)VALUES ?';
const values = [
    [4, 'Ann Mary', 20, 'BCA'],
    [5, 'Adhuljith', 21, 'BSc'],
    [6, 'Rahul', 22, 'BBA']];
con.query(sql, [values], (err, result) => {
    if (err) throw err;
    console.log("Number of records inserted: " + result.affectedRows);
});

