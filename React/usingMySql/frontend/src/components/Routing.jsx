import React from "react";
import { Navigate, Route, Routes } from "react-router-dom";
import Login from "./Auth/Login";
import Signup from "./Auth/Signup";
import Main from "../pages/Main";
import Logout from "./Auth/Logout";

const Routing = ({ user }) => {
  return (
    <Routes>
      <Route path="/" element={user ? <Navigate to="/main" /> : <Login />} />
      <Route path="/signup" element={<Signup />} />
      <Route path="/login" element={<Login />} />
      <Route path="/main" element={user ? <Main user={user} /> : <Login />} />
      <Route path="/logout" element={<Logout />} />
    </Routes>
  );
};

export default Routing;
