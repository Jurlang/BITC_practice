import React from "react";
import "./SingleCard.css";

const SingleCard = ({card, handleChoice, flipped, disabled}) => {

	function handleClick() {
		if(!disabled){
			handleChoice(card);
		}
	}

    return (
        <div className="card">
            <div className={flipped ? 'flipped' : ''}>
				<img className='front' src={card.src} alt='card front'></img>
				<img className='back' src='/img/cover.png' alt='card back' onClick={handleClick}></img>
			</div>
        </div>
    );
};

export default SingleCard;
