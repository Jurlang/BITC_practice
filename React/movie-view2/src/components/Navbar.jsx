import { Link, NavLink } from 'react-router-dom';
import Fire from '../assets/fire.png';
import Star from '../assets/glowing-star.png';
import Party from '../assets/partying-face.png';
import '../css/Navbar.css';
import DarkMode from './DarkMode';


const Navbar = () => {
	return (
		<nav className='navbar'>
			<Link to='/' className='h1 text-decoration-none ms-5'>MovieApp</Link>

			<div className='navbar_links me-5'>
				<DarkMode />
				<NavLink to='/'>
					인기작품
					<img className='navbar_emoji' src={Fire} alt='fire emoji'/>
				</NavLink>
				<NavLink to='/top_rate'>
					최고평점
					<img className='navbar_emoji' src={Star} alt='star emoji'/>
				</NavLink>
				<NavLink to='/upcoming'>
					예정작품
					<img className='navbar_emoji' src={Party} alt='party emoji'/>
				</NavLink>
			</div>
		</nav>
	)
}

export default Navbar
