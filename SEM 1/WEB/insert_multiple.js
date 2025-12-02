// insert_multiple.js
const con = require('./db_connect');

// Array of student records [ [rollno, name], [rollno, name], ... ]
const students = [
  [1, 'Apsara A'],
  [2, 'Ann Mary'],
  [3, 'Anagha'],
  [4, 'Aamina'],
  
];

// SQL query for multiple insertions
const sql = "INSERT INTO students (rollno, name) VALUES ?";

con.query(sql, [students], (err, result) => {
  if (err) throw err;
  console.log(`✅ ${result.affectedRows} student records inserted successfully!`);
  con.end();
});