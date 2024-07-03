// backend/server.js

const express = require('express');  // Express 프레임워크 불러오기
const cors = require("cors");        // CORS(Cross-Origin Resource Sharing) 미들웨어 불러오기
const userRoutes = require('./routes/userRoutes'); // 사용자 라우트 모듈 불러오기

const app = express();               // Express 애플리케이션 인스턴스 생성
app.use(express.json());             // JSON 요청 본문을 파싱하는 미들웨어 추가
app.use(cors({
    origin: 'http://localhost:3000', // 허용할 출처 설정
    credentials: true,               // 자격 증명(credentials) 허용 설정
}));

app.use('/api', userRoutes);          // '/api' 경로로 들어오는 요청에 대해 userRoutes 라우트 사용

app.listen(3001, () => {              // 애플리케이션을 3001 포트에서 실행
    console.log("서버 실행")
});