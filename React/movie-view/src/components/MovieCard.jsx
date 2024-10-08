/* eslint-disable react/prop-types */
import Star from "../assets/star.png";
import "../css/MovieCard.css";


const MovieCard = ({ movie }) => {
  return (
    <a className="movie_card" href={`https://www.themoviedb.org/movie/${movie.id}?language=ko`} target='_blank'>
      <img 
          src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`} 
          alt="movie poster" 
          className="movie_poster" />

      <div className="movie_details">
        <h3 className="movie_details_heading">{movie.title}</h3>
        <div className="align_center movie_date_rate">
          <p>{movie.release_date}</p>
          <p className="align_center">
            평점
            <img src={Star} alt="rating icon" className="card_emoji" />
            {movie.vote_average}
          </p>
        </div>
        <p className="movie_description">{movie.overview.substring(0,100)}...</p>
      </div>
    </a>
  );
};

export default MovieCard;
