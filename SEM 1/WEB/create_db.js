// create_db.js
const mysql = require('mysql2');

const con = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'ann@123',
  database: 't_db' 
});

con.connect((err) => {
  if (err) throw err;
  console.log('✅ Connected to MySQL server');

  con.query('CREATE DATABASE IF NOT EXISTS t_db', (err, result) => {
    if (err) throw err;
    console.log('📦 Database "t_db" created or already exists');
    con.end();
  });
});