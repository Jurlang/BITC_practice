const db = require('../database/dbConnection'); // 데이터베이스 연결 설정

exports.signUp = (data) => {
    return new Promise((resolve, reject) => {
        db.query(`INSERT INTO user (userID, userPW, name, age) VALUES (?, ?, ?, ?) `, [data[0], data[1], data[2], data[3]], (err, result) => {
            if (err) reject(err);
            else resolve(result);
        });
    });
};

exports.getUser = (userID) => {
    return new Promise((resolve, reject) => {
        db.query(`SELECT * FROM user where userID = ?`, userID, (err, result) => {
            if (err) reject(err);
            else resolve(result);
        });
    });
};