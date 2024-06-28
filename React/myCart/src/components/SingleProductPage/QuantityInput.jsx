/* eslint-disable react/prop-types */
import "../../css/QuantityInput.css";

const QuantityInput = ({ quantity, stock, setQuantity, cartPage, productId }) => {
  return (
    <>
      <button
        id="decrease"
        onClick={() => {
          cartPage ? setQuantity("decrease", productId) : setQuantity((prev) => prev - 1);
        }}
        className="quantity_input_button"
        disabled={quantity <= 1}
      >
        {" "}
        -{" "}
      </button>
      <p className="quantity_input_count">{quantity}</p>
      <button
        id="increase"
        onClick={() => {
          cartPage ? setQuantity("increase", productId) : setQuantity((prev) => prev + 1);
        }}
        className="quantity_input_button"
        disabled={quantity >= stock}
      >
        {" "}
        +{" "}
      </button>
    </>
  );
};

export default QuantityInput;
