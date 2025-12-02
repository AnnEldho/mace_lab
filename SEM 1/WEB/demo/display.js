const con=require('./db_connect');

const sql='SELECT * FROM students';

con.query(sql,(err,result)=>{
    if(err) throw err;
    console.table(result);
});