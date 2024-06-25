/* eslint-disable react-hooks/exhaustive-deps */
import "bootstrap/dist/css/bootstrap.min.css";

import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const SingleMovie = () => {
  const { movieId } = useParams();
  const [movie, setMovie] = useState(null);
  const [tags, setTags] = useState(null);
  const [companys, setCompanys] = useState(null);

  useEffect(() => {
    fetchSingleMovie();
  }, []);

  const fetchSingleMovie = async () => {
    const response = await fetch(`https://api.themoviedb.org/3/movie/${movieId}?api_key=0a38da9c8fce0bc51ca78920fc889a09&language=ko`);
    const data = await response.json();
    setMovie(data);
    setTags(data.genres);
    setCompanys(data.production_companies);
  };

  if (movie !== null) {
    return (
      <div className="container">
        <div className="d-flex">
          <img src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`} alt="movie poster" className="img-thumbnail mt-5" />
          <div className="w-100">
            <div className="ms-3 mt-5 card align-middle">
              <div className="card-header text-center">영화 정보</div>
              <ul className="list-group list-group-flush">
                <li className="list-group-item">제목 | {movie.title} ( {movie.original_title} )</li>
                <li className="list-group-item">개봉 | {movie.release_date}</li>
                <li className="list-group-item">평점 | {movie.vote_average}</li>
                <li className="list-group-item">시간 | {movie.runtime} 분</li>
                <li className="list-group-item">장르 |{tags.map((tag, index) => {
                    if( index !== tags.length-1)
                      return " " + tag.name + " , ";
                    else 
                      return " " + tag.name;
                  })}</li>
                <li className="list-group-item">제작 | {companys.map((company, index) => {
                    if( index !== companys.length-1)
                      return " " + company.name + " &";
                    else
                      return " " + company.name;
                  })}</li>
               
              </ul>
            </div>
            <div className="ms-3 mt-5 card align-middle">
              <div className="card-header text-center">배경 내용</div>
                <ul className="list-group list-group-flush">
                  <li className="list-group-item">
                    {movie.overview === "" && "내용이 없습니다."}
                    {movie.overview !== "" && movie.overview}
                  </li>
                </ul>
              </div>
            </div>
        </div>
      </div>
    );
  }
};

export default SingleMovie;
