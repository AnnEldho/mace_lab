const con=require('./db_connect');

const sql="SELECT * FROM students WHERE age > 20"

con.query(sql, (err, result) => {
  if (err) throw err;
  console.log(result);
  con.end();
});
