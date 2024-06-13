import React from 'react'
import './Home.css'
import { useFetch } from '../../hooks/useFetch'
import RecipeList from '../../components/RecipeList';

const Home = () => {
	// useFetch 를 사용해서 가져오는 데이터 : data isPending, error
	 const { data, isPending, error }= useFetch('http://localhost:3030/recipes');
  return (
	<div className='home'>
		{error && <p className="error">{error}</p>}
		{isPending && <p className="loading">로딩중 ...</p>}
		{data && <RecipeList recipes={data}/> }
	</div>
  )
}

export default Home
