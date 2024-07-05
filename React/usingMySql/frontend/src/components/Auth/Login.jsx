// Login.jsx
import "./Login.css";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { login } from "../../services/userService";

const Login = ({ setIsAuthenticated }) => {
  const navigate = useNavigate();

  const [formError, setFormError] = useState("");

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const submitData = async (formData) => {
    try{
      await login(formData);
    } catch (err) {
      console.log(err);
      setFormError(err.response.data.message);
    }
  }

  const moveSignUP = () => {
    navigate("/signup");
  };

  return (
    <>
      <div className="container_login">
        <div className="login-box">
          <form onSubmit={handleSubmit(submitData)}>
            <h1 className="title">로그인</h1>
            <div>
              <input
                {...register("userID", {required: "이메일을 입력해주세요."})}
                type="text"
                id="userID"
                className="input"
              />
              {formError && <p className="errorMsg">{formError}</p>}
              <input
                type="password"
                {...register("userPW", {required: "패스워드를 입력해주세요."})}
                id="password"
                className="input"
              />
              {formError && <p className="errorMsg">{formError}</p>}
              <button type="submit" className="button">
                로그인
              </button>
            </div>
            <button className="button" onClick={moveSignUP}>
              회원가입
            </button>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
