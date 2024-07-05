import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

const Navbar = ({ user, todoList }) => {
  return (
    <nav className="navbar navbar-expand-lg bg-dark text-white">
      <div className="container-fluid">
        <a className="navbar-brand" href="/">
          Calender
        </a>
        <div className="navbar-nav ms-auto">
          <p className="me-5 my-auto">{user.name}님~ 반갑습니다 ! </p>
          <Link to="/logout" onClick={()=>{localStorage.setItem("todoList", todoList)}} className="btn btn-danger">
            로그아웃
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
