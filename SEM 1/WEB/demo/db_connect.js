const mysql=require('mysql2');

const con=mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'ann@123',
    database:'exampledb'
});

con.connect((err)=>{
    if(err) throw err;
    console.log("Connected to the database!");
});

module.exports=con;