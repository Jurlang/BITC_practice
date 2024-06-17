import React, { useContext } from "react";
import { Link } from "react-router-dom";
import './RecipeList.css';
import { ThemeContext } from "../context/ThemeContext";

const RecipeList = ({recipes}) => {
    const { mode } = useContext(ThemeContext);
    if(recipes.length===0) return <div className='error'>검색된 레시피가 없습니다.</div>
    else return (
        <div className="recipe-list">
            {recipes.map((recipe) => (
                <div key={recipe.id} className={`card ${mode}`}>
                    <h3>{recipe.title}</h3>
                    <p>{recipe.cookingTime} to make.</p>
                    <div>{recipe.method.substring(0, 100)}...</div>
                    <Link to={`/recipe/${recipe.id}`}>요리하기</Link>
                </div>
            ))}
        </div>
    );
};

export default RecipeList;
