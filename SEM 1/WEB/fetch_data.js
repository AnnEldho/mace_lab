// fetch_data.js
const con = require('./db_connect');

const sql = "SELECT * FROM students";

con.query(sql, (err, results) => {
  if (err) throw err;

  console.log("📋 Student Records:");
  console.table(results); // displays formatted output
  con.end();
});