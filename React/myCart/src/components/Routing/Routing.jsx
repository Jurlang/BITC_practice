import HomePage from '../Home/HomePage';
import ProductsPage from '../Products/ProductsPage';
import CartPage from '../Cart/CartPage';
import MyOrderPage from '../MyOrder/MyOrderPage';
import LoginPage from '../Authentication/LoginPage';
import SingleProductPage from '../SingleProductPage/SingleProductPage';
import SignupPage from '../Authentication/SignupPage';

import { Route, Routes } from 'react-router-dom';

const Routing = () => {
	return (
		<Routes>
			<Route path='/' element={<HomePage/>}/>
			<Route path='/products' element={<ProductsPage/>}/>
			<Route path='/products/:id' element={<SingleProductPage/>}/>
			<Route path='/signup' element={<SignupPage/>}/>
			<Route path='/login' element={<LoginPage/>}/>
			<Route path='/cart' element={<CartPage/>}/>
			<Route path='/myorders' element={<MyOrderPage/>}/>
		</Routes>
	)
}

export default Routing
