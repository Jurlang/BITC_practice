/* eslint-disable react/prop-types */
import HomePage from "../Home/HomePage";
import ProductsPage from "../Products/ProductsPage";
import CartPage from "../Cart/CartPage";
import MyOrderPage from "../MyOrder/MyOrderPage";
import LoginPage from "../Authentication/LoginPage";
import SingleProductPage from "../SingleProductPage/SingleProductPage";
import SignupPage from "../Authentication/SignupPage";

import { Navigate, Route, Routes } from "react-router-dom";
import Logout from "../Authentication/Logout";
import ProtectedRoute from "./ProtectedRoute";

const Routing = ({ user }) => {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/products" element={<ProductsPage />} />
      <Route path="/products/:id" element={<SingleProductPage />} />
      <Route path="/signup" element={user ? <Navigate to="/" /> : <SignupPage />} />
      <Route path="/login" element={user ? <Navigate to="/" /> : <LoginPage />} />
      <Route element={<ProtectedRoute />}>
        <Route path="/logout" element={<Logout />} />
        <Route path="/cart" element={<CartPage />} />
        <Route path="/myorders" element={<MyOrderPage />} />
      </Route>
    </Routes>
  );
};

export default Routing;
