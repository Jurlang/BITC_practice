import React from "react";
import "./Recipe.css";
import { useParams } from "react-router-dom";
import { useFetch } from "../../hooks/useFetch";

const Recipe = () => {
    const { id } = useParams();
    const url = "http://localhost:3030/recipes/" + id;
    const { error, isPending, data: recipe } = useFetch(url);

    return (
        <div className="recipe">
            {error && <p className="error">{error}</p>}
            {isPending && <p className="loading">로딩중 ...</p>}
            {recipe && <h1>{recipe.title}</h1>}
        </div>
    );
};

export default Recipe;
