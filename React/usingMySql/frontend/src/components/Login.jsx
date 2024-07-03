// Login.jsx
import './Login.css';
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Login = ({ setIsAuthenticated }) => {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const loginSubmit = async () => {
    if (id === "" || pw === "") {
      alert("아이디 또는 비밀번호를 입력해주시기 바랍니다");
      return;
    } else {
      try {
        const res = await fetch("/api/loginCheck", {
          method: "POST",
          body: JSON.stringify({ userID: id, userPW: pw }),
          credentials: "include",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const data = await res.json();

        if (res.status === 200) {
          localStorage.setItem("token", data.token); // 예: 서버에서 받은 토큰 저장
          console.log(data.token);
          setIsAuthenticated(true);
          navigate("/main");
        } else {
            setError(data);
          setId("");
          setPw("");
          return;
        }
      } catch (err) {
        console.log(err);
      }
    }
  };

  const moveSignUP = () => {
    navigate("/signup");
  };

  return (
    <>
      <div className="container_login">
        <div className="login-box">
          <h1 className="title">로그인</h1>
          <div>
            <input
              type="text"
              className="input"
              value={id}
              onChange={(e) => setId(e.target.value)}
              required
            />
            <input
              type="password"
              className="input"
              value={pw}
              onChange={(e) => setPw(e.target.value)}
              required
            />
            {error && <p className="errorMsg">{error}</p>}
            <button type="submit" className="button" onClick={loginSubmit}>
              로그인
            </button>
          </div>
          <button className="button" onClick={moveSignUP}>회원가입</button>
        </div>
      </div>
    </>
  );
};

export default Login;
