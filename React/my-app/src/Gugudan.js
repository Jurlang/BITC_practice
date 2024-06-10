import React, { useState } from 'react'

const Gugudan = () => {
	// const [변수명, set변수명] = useState(초기값);
	const [first, setFirst] = useState(Math.ceil(Math.random()*9));
	const [second, setSecond] = useState(Math.ceil(Math.random()*9));
	const [value, setValue] = useState('');
	const [result, setResult] = useState('');
	const [score, setScore] = useState(0);
	
	const submit = (e) => {
		e.preventDefault();
		if(first * second === parseInt(value)){
			setFirst(Math.ceil(Math.random()*9));
			setSecond(Math.ceil(Math.random()*9));
			setValue('');
			setResult("정답");
			setScore(score + 1);
		}
		else{
			setFirst(Math.ceil(Math.random()*9));
			setSecond(Math.ceil(Math.random()*9));
			setValue('');
			setResult("땡");
			setScore(score - 1);
		}
		e.target.firstChild.focus();
	}

	const setOnChange = (e) =>{
		setValue(e.target.value);
	}

  return (
	<div>
		<span>{first} * {second} = </span>
		<form onSubmit={submit}>
			<input  type="number"
					onChange={setOnChange}
					value = {value}/>
			<button>입력</button>
		</form>
		<div>결과 : {result}</div>
		<div>점수 : {score}</div>
	</div>
  )
}

export default Gugudan

// rafc
// rfce