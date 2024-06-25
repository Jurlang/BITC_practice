/* eslint-disable react-hooks/exhaustive-deps */
import "bootstrap/dist/css/bootstrap.min.css";

import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const SingleMovie = () => {
  const { movieId } = useParams();
  const [movie, setMovie] = useState(null);

  useEffect(() => {
    fetchSingleMovie();
  }, []);

  const fetchSingleMovie = async () => {
    const response = await fetch(`https://api.themoviedb.org/3/movie/${movieId}?api_key=0a38da9c8fce0bc51ca78920fc889a09&language=ko`);
    const data = await response.json();
    setMovie(data);
  };
	
  if (movie !== null) {
		console.log(movie);
    return (
      <div className="container">
        <div className="d-flex">
          <img src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`} alt="movie poster" className="img-thumbnail" />
          <div className="w-100">
            <div className="ms-3 mt-5 card">
              <div className="card-header text-center bg-">Infomation</div>
              <ul className="list-group list-group-flush">
                <li className="list-group-item">{movie.title} ( {movie.original_title} )</li>
                <li className="list-group-item">{movie.vote_average}</li>
                <li className="list-group-item">{movie.overview}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
};

export default SingleMovie;
