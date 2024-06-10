import React, {useState} from 'react'

const GugudanGPT = () => {
	const [number1, setNumber1] = useState(Math.floor(Math.random() * 9) + 1);
	const [number2, setNumber2] = useState(Math.floor(Math.random() * 9) + 1);
	const [userAnswer, setUserAnswer] = useState('');
	const [message, setMessage] = useState('');
	const [score, setScore] = useState(0);
  
	const handleSubmit = (e) => {
	  e.preventDefault();
	  const correctAnswer = number1 * number2;
	  if (parseInt(userAnswer) === correctAnswer) {
		setMessage('정답입니다!');
		setScore(score+1);
	  } else {
		setMessage(`틀렸습니다. 정답은 ${correctAnswer}입니다.`);
	  }
	  setNumber1(Math.floor(Math.random() * 9) + 1);
	  setNumber2(Math.floor(Math.random() * 9) + 1);
	  setUserAnswer('');
	};
  
	return (
	  <div className="App">
		<header className="App-header">
		  <h1>구구단 게임</h1>
		  <p>점수 : {score}</p>
		  <p>{number1} x {number2} = ?</p>
		  <form onSubmit={handleSubmit}>
			<input
			  type="number"
			  value={userAnswer}
			  onChange={(e) => setUserAnswer(e.target.value)}
			/>
			<button type="submit">제출</button>
		  </form>
		  {message && <p>{message}</p>}
		</header>
	  </div>
	);
}

export default GugudanGPT
