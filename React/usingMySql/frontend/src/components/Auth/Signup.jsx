// Signup.jsx
import "./Signup.css";
import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { signup } from "../../services/userService";

const Signup = () => {
  const navigate = useNavigate();
  const [formError, setFormError] = useState("");

  const {
    register,
    handleSubmit,
    formState: { errors },
    watch,
  } = useForm();

  const submitData = async (formData) => {
    console.log(formData);
    try {
      await signup(formData);
    } catch (err) {
      setFormError(err.response.data.message);
    }
  };

  return (
    <div className="container_signup">
      <form onSubmit={handleSubmit(submitData)}>
        <div className="signup-box">
          <h1 className="title">회원가입</h1>
          <div>
            <input
              {...register("userID", {required:"아이디 입력"})}
              type="text"
              className="input"
              placeholder="아이디"
            />
            <input
            {...register("userPW", {required:"비밀번호 입력"})}
              type="password"
              className="input"
              placeholder="비밀번호"
            />
            <input
            {...register("name", {required: "이름 입력"})}
              type="text"
              className="input"
              placeholder="이름"
            />
            <input
            {...register("age", {required: "나이 입력"})}
              type="text"
              className="input"
              placeholder="나이"
            />
            <button type="submit" className="button">
              가입
            </button>
            <button
              type="button"
              className="button"
              onClick={() => navigate("/")}
            >
              로그인
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default Signup;
