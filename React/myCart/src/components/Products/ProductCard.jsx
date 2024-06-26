/* eslint-disable react/prop-types */
import "../../css/ProductCard.css";
import star from "../../assets/images/white-star.png";
import basket from "../../assets/images/basket.png";

const ProductCard = ({ id, image, price, title, rating, ratingCounts, stock }) => {
  return (
    <article className="product_card">
      <div className="product_image">
        <a href="product/1">
          <img src={`http://localhost:5000/products/${image}`} alt="product image" />
        </a>
      </div>

      <div className="product_details">
        <h3 className="product_price">{price?.toLocaleString("ko-KR")}원</h3>
        <p className="product_title">{title}</p>

        <footer className="align_center product_info_footer">
          <div className="align_center">
            <p className="align_center product_rating">
              <img src={star} alt="star" /> {rating}
            </p>
            <p className="product_review_count">{ratingCounts}</p>
          </div>
          {stock > 0 && (
            <button className="add_to_cart">
              <img src={basket} alt="basket button" />
            </button>
          )}
        </footer>
      </div>
    </article>
  );
};

export default ProductCard;
