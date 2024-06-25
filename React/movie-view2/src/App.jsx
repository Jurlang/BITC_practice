import { Route, Routes } from "react-router-dom";
import "./App.css";
import Fire from "./assets/fire.png";
import Star from "./assets/glowing-star.png";
import Party from "./assets/partying-face.png";

import MovieList from "./components/MovieList";
import Navbar from "./components/Navbar";
import SingleMovie from "./components/SingleMovie";

function App() {
  return (
    <div className="app">
      <Navbar />
      <Routes>
        <Route path="/" element={<MovieList type="popular" title="인기작품" emoji={Fire} />} />
        <Route path="/top_rate" element={<MovieList type="top_rated" title="최고평점" emoji={Star} />} />
        <Route path="/upcoming" element={<MovieList type="upcoming" title="예정작품" emoji={Party} />} />
        <Route path="/movie/:movieId" element={<SingleMovie />} />
      </Routes>
    </div>
  );
}

export default App;
