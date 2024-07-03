// Signup.jsx
import './Signup.css';
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const submitBtn = async () => {
    if (id === "" || pw === "") {
      alert("아이디 또는 비밀번호를 입력해주시기 바랍니다");
      return;
    } else {
      try {
        const res = await fetch("/api/signup", {
          method: "POST",
          body: JSON.stringify({
            userID: id,
            userPW: pw,
            name: name,
            age: age,
          }),
          credentials: "include",
          headers: { "Content-Type": "application/json" },
        });
        const data = await res.json();
        if (res.status === 200) {
          navigate("/");
        } else {
            setError(data);
          return;
        }
      } catch (err) {
        console.log(err);
      }
    }
  };

  return (
    <div className="container">
      <div className="signup-box">
        <h1 className="title">회원가입</h1>
        <div>
          <input
            type="text"
            className="input"
            value={id}
            onChange={(e) => setId(e.target.value)}
            placeholder="아이디"
          />
          <input
            type="password"
            className="input"
            value={pw}
            onChange={(e) => setPw(e.target.value)}
            placeholder="비밀번호"
          />
          <input
            type="text"
            className="input"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="이름"
            />
            <input
            type="text"
            className="input"
            value={age}
            onChange={(e) => setAge(e.target.value)}
            placeholder="나이"
            />
            {error && <p className="error-message">{error}</p>}
          <button type="submit" className="button" onClick={submitBtn}>
            가입
          </button>
          <button type="button" className="button" onClick={() => navigate("/")}>로그인</button>
        </div>
      </div>
    </div>
  );
};

export default Signup;
