const bcrypt = require('bcrypt');
const userDB = require('../models/userDB');
const jwt = require('jsonwebtoken');
const _ = require("lodash");

require('dotenv').config(); // .env 파일에 설정된 환경 변수 로드
const secretKey = process.env.JWTSECRET; // 환경 변수에서 JWT 비밀키 가져오기

const textToHash = async (text) => {		// 텍스트 값을 hash로 변환
    const saltRounds = 10;

    try {
        const hash = await bcrypt.hash(text, saltRounds);
        return hash
    } catch (err) {
        console.error(err);
        return err;
    }
}

exports.signup = async (req, res) => {
    
    const { userID, userPW, name, age } = req.body;
    console.log(userID, userPW, name, age);
    try {
        const getUser = await userDB.getUser(userID);
        if (getUser.length) {
            res.status(401).json('이미 존재하는 아이디입니다.');
            return;
        }

        const hash = await textToHash(userPW);
        await userDB.signUp([userID, hash, name, age]);
        res.status(200).json('가입 성공');
    } catch (err) {
        console.error(err);
        res.status(500).json(err);
    }
};

const hashCompare = async (inputValue, hash) => { // 입력값과 해시값을 비교하는 함수
    try {
        const isMatch = await bcrypt.compare(inputValue, hash); // bcrypt를 사용하여 입력값과 해시값을 비교
        return isMatch; // 비교 결과 반환 (일치하면 true, 일치하지 않으면 false)
    } catch (err) {
        console.error('hashCompare Error: ', err); // 오류 발생 시 콘솔에 출력
        return err; // 오류 반환
    }
}

exports.loginCheck = async (req, res) => { // 로그인 요청을 처리하는 함수
    const { userID, userPW } = req.body;

    if (!secretKey) {
        console.error('JWT secret key is not defined.');
        res.status(500).json({ error: 'Internal server error' });
        return;
    }

    try {
        const getUser = await userDB.getUser(userID); // 데이터베이스에서 해당 사용자 ID 조회
        if (!getUser.length) { // 사용자 ID가 존재하지 않는 경우
            res.status(401).json('존재하지 않는 아이디입니다.'); // 401 상태 코드와 함께 에러 메시지 반환
            return; // 함수 종료
        }

        const blobToStr = Buffer.from(getUser[0].userPW).toString(); // 데이터베이스에서 가져온 해시값을 문자열로 변환
        const isMatch = await hashCompare(userPW, blobToStr); // 입력된 비밀번호와 해시값을 비교

        if (!isMatch) { // 비밀번호가 일치하지 않는 경우
            res.status(401).json('비밀번호가 일치하지 않습니다.'); // 401 상태 코드와 함께 에러 메시지 반환
            return; // 함수 종료
        }

        // JWT 토큰 생성 시 에러를 캐치
        let token;
        let newUser = _.pick(getUser[0], [
            "userNo", "userID", "name", "age"
        ])

        try {
            token = jwt.sign(newUser, secretKey, { expiresIn: '1h' }); // JWT 토큰 생성 (1시간 유효)
        } catch (err) {
            console.error('JWT sign error: ', err);
            res.status(500).json({ error: 'Token generation failed' });
            return;
        }

        res.status(200).json({ message: '로그인 성공', token: token }); // 200 상태 코드와 함께 성공 메시지 및 토큰 반환
    } catch (err) {
        console.error('loginCheck Error: ', err); // 오류 발생 시 콘솔에 출력
        res.status(500).json({ error: 'Internal server error' }); // 500 상태 코드와 함께 오류 메시지 반환
    }
}