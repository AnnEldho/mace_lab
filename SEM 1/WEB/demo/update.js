const con=require('./db_connect');
const sql=`
  UPDATE students 
  SET age = 21, course = 'MCA'
  WHERE id = 1
`;

con.query(sql,(err,result)=>{
    if(err) throw err;
    console.log("Number of records updated: "+result.affectedRows);
});