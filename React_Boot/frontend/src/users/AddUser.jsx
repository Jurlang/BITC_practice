import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AddUser = () => {
  const navigate = useNavigate();

  const [user, setUser] = useState({
    name: "",
    username: "",
    email: "",
  });

  const { name, username, email } = user;

  const onInputChange = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post('http://localhost:8080/api/users', user);
    navigate('/');
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">가입 하기</h2>
          <div className="mb-3">
            <form onSubmit={handleSubmit}>
              <label htmlFor="name" className="form-label">
                이름
              </label>
              <input
                type="text"
                id="name"
                name="name"
                className="form-control"
                onChange={onInputChange}
                placeholder="이름"
              />
              <label htmlFor="username" className="form-label">
                사용자 이름
              </label>
              <input
                type="text"
                id="username"
                name="username"
                className="form-control"
                onChange={onInputChange}
                placeholder="사용자 이름"
              />
              <label htmlFor="email" className="form-label">
                이메일
              </label>
              <input
                type="text"
                id="email"
                name="email"
                className="form-control"
                onChange={onInputChange}
                placeholder="이름"
              />

              <div className="mb-3 text-center">
                <button
                  type="submit"
                  className="btn btn-outline-primary px-3 mx-2"
                >
                  가입
                </button>
                <Link to="/" className="btn btn-outline-danger px-3 mx-2">
                  취소
                </Link>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddUser;
