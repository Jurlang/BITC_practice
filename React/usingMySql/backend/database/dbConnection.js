const mysql = require('mysql');

const conn = mysql.createConnection({
    host: 'hyeon-dev.iptime.org',
    port: '9033',
    user: 'react',
    password: 'react',
    database: 'react'
});

conn.connect((err) => {
    if (err) console.log(err);
    else console.log('Connected to the database');
});

module.exports = conn;