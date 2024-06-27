/* eslint-disable react/prop-types */
import "../../css/QuantityInput.css";

const QuantityInput = ({quantity, handleClick, stock}) => {
  return (
    <>
      <button id="decrease" onClick={(e) => handleClick(e.target.id)} className="quantity_input_button" disabled={quantity <= 1}> - </button>
      <p className="quantity_input_count">{quantity}</p>
      <button id="increase" onClick={(e) => handleClick(e.target.id)} className="quantity_input_button" disabled={quantity >= stock}> + </button>
    </>
  );
};

export default QuantityInput;
