// create_table.js
const con = require('./db_connect');

const sql = `
  CREATE TABLE IF NOT EXISTS students (
    rollno INT PRIMARY KEY,
    name VARCHAR(15)
  )
`;

con.query(sql, (err) => {
  if (err) throw err;
  console.log('🧱 Table "students" created');
  con.end();
});