const con=require('./db_connect');

const sql='DELETE FROM students WHERE id=1';
con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log("Number of records deleted: "+result.affectedRows);
});