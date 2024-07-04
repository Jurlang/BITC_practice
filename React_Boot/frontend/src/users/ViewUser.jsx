import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

const ViewUser = () => {
  const navigate = useNavigate();
  const { id } = useParams();

  const [user, setUser] = useState({
    id: "",
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

  const deleteUser = async (id) => {
    if (window.confirm("정말로 삭제하시겠습니까?")) {
      await axios.delete(`http://localhost:8080/api/users/${id}`);
      navigate("/");
    }
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">정보 보기</h2>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              이름
            </label>
            <input type="text" id="name" name="name" className="form-control" readOnly value={user.name}/>
            <label htmlFor="username" className="form-label">
              사용자 이름
            </label>
            <input
              type="text"
              id="username"
              name="username"
              className="form-control"
              readOnly
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
              readOnly
              value={user.email}
            />

            <div className="mb-3 text-center">
              <Link
                to={`/edituser/${user.id}`}
                className="btn btn-outline-warning mx-2"
              >
                수정
              </Link>
              <button
                onClick={() => deleteUser(user.id)}
                className="btn btn-outline-danger mx-2"
              >
                삭제
              </button>
              <Link to="/" className="btn btn-outline-danger px-3 mx-2">
                취소
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ViewUser;
