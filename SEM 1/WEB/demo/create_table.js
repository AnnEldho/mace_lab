const con = require('./db_connect');

const sql = `
  CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50)
  )
`;

con.query(sql,(err,result)=>{
    if (err) throw err;
    console.log("Table created.");
})