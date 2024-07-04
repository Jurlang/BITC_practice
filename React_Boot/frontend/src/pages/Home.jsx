import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Home = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/api/users");
    setUsers(result.data);
  };

  return (
    <div className="mt-5 container">
      <table className="table text-center">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">userName</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody className="table-group-divider">
          {users.map((user, index) => (
            <tr key={user.id}>
              <th scope="row">{index}</th>
              <td>{user.username}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>
                <Link to={`/readuser/${user.id}`} className="btn btn-outline-secondary mx-2">보기</Link>
                <Link to={`/edituser/${user.id}`} className="btn btn-outline-warning mx-2">수정</Link>
                <Link to={`/deleteuser/${user.id}`} className="btn btn-outline-danger mx-2">삭제</Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Home;
