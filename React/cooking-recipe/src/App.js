import { BrowserRouter, Route, Routes } from 'react-router-dom'
import "./App.css"
import Home from './pages/home/Home';
import Create from './pages/create/Create';
import Search from './pages/search/Search';
import Recipe from './pages/recipe/Recipe';
import Navbar from './components/Navbar';
import ThemeSelector from './components/ThemeSelector';
import { ThemeContext } from './context/ThemeContext';
import { useContext } from 'react';



function App() {
    const { mode } = useContext(ThemeContext);
    return (
    <div className={`App ${mode}`}>
        <BrowserRouter>
        <Navbar/>
        <ThemeSelector/>
            <Routes>

                <Route path='/' element={ <Home /> } />
                <Route path='/create' element={ <Create /> } />
                <Route path='/search' element={ <Search /> } />
                <Route path='/recipe/:id' element={ <Recipe /> } />

            </Routes>
        </BrowserRouter>
        
    </div>
    );
}

export default App;
