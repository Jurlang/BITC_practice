import { useState, useEffect } from "react";
import MovieList from "./components/MovieList";
import MovieListHeading from "./components/MovieListHeading";
import SearchBox from "./components/SearchBox";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

function App() {
    const [movies, setMovies] = useState([]);
    const [searchValue, setSearchValue] = useState("");

    const getMovieRequest = async (searchValue) => {
        // 문자열 + 변수를 사용할 때, 백틱따옴표 사용 ( 1 옆에 ` )
        const url = `http://www.omdbapi.com/?apikey=edc6999f&s=${searchValue}`;
        // fetch = url 에서 보내준 데이터를 받아오는 역할
        // async 와 await 세트 = 비동기 처리
        const response = await fetch(url);
        const responseJson = await response.json();

        if (responseJson.Search) {
            setMovies(responseJson.Search);
        }
    };

    useEffect(() => {
        if (searchValue.length > 3) {
            getMovieRequest(searchValue);
        }
    }, [searchValue]);
    return (
        <div>
            <div className="container-fluid movie-app">
                <div className="row align-items-center my-4">
                    <MovieListHeading heading="Movies" />
                    <SearchBox searchValue={searchValue} setSearchValue={setSearchValue} />
                </div>
                <div className="row">
                    <MovieList movies={movies} />
                </div>
            </div>
        </div>
    );
}

export default App;
