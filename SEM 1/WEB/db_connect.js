// db_connect.js
const mysql = require('mysql2');

const con = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'ann@123',
  database: 't_db' // default DB
});

con.connect((err) => {
  if (err) throw err;
  console.log('✅ Connected to MySQL database: t_db');
});

module.exports = con; // Export connection for reuse