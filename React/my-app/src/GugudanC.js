import React from "react"

class GugudanC extends React.Component{
	// 그냥 변수 지정도 가능
	hello = "hello123213213";
	
	// 객체의 변수 지정
	state = {
		first : Math.ceil(Math.random()*9),
		second : Math.ceil(Math.random()*9),
		value: '',
		result: '',
		score: 0
	}

	// function 은 화살표 함수로 지정 function (){}으로는 안됨.
	submit = (e) => {
		e.preventDefault();
		if(this.state.first * this.state.second === parseInt(this.state.value)){
			this.setState({
				result: '정답', 
				value:'', 
				first : Math.ceil(Math.random()*9), 
				second : Math.ceil(Math.random()*9),
				score : this.state.score + 1
			});
		}
		else{
			this.setState({
				result: '땡', 
				value:'', 
				first : Math.ceil(Math.random()*9), 
				second : Math.ceil(Math.random()*9),
				score : this.state.score - 1
			});
		}
		e.target.firstChild.focus();
	}

	render(){
		return(
			<div>
				<span>{this.state.first} X {this.state.second} = </span>
				<form onSubmit={this.submit}>
					<input	type="number" 
									onChange={e => this.setState({value:e.target.value})} 
									value={this.state.value} />
					<button type="submit">입력</button>
				</form>
				<div>결과 : {this.state.result}</div>
				<div>점수 : {this.state.score}</div>
				<div>{this.hello}</div>
			</div>
		)
	}

}

export default GugudanC;