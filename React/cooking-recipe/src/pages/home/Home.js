import React from 'react'
import './Home.css'
import { useFetch } from '../../hooks/useFetch'

const Home = () => {
	// useFetch 를 사용해서 가져오는 데이터 : data isPending, error
	 const { data, isPending, error }= useFetch('http://localhost:3030/recipes');
  return (
	<div className='home'>
		{error && <p className="error">{error}</p>}
		{isPending && <p className="loading">로딩중 ...</p>}
		{data && data.map(recipe => <h2 key={recipe.id}>{recipe.title}</h2>)}
	</div>
  )
}

export default Home
