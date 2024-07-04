/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable no-unused-vars */
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

const EditUser = () => {
  const navigate = useNavigate();
  const {id} = useParams();

  const [user, setUser] = useState({
    id: {id},
    name: "",
    username: "",
    email: "",
  });

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/users/${id}`);
    setUser(result.data);
  };

  useEffect(() => {
    loadUser();
  }, []);

  const { name, username, email } = user;

  const onInputChange = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/api/users/${user.id}`, user);
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">수정 하기</h2>
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
                value={user.name}
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
                value={user.username}
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
                placeholder="이메일"
                value={user.email}
              />

              <div className="mb-3 text-center">
                <button
                  type="submit"
                  className="btn btn-outline-primary px-3 mx-2"
                >
                  수정
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

export default EditUser;
