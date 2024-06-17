import React from "react";
import "./Search.css";
import { useLocation } from "react-router-dom";
import { useFetch } from "../../hooks/useFetch";
import RecipeList from "../../components/RecipeList";

const Search = () => {
    const queryString = useLocation().search;
    const queryParams = new URLSearchParams(queryString);
    const query = queryParams.get("q");

    const url = "http://localhost:3030/recipes?q=" + query;
    const { data, isPending, error } = useFetch(url);
    return (
        <div>
            {error && <p className="error">{error}</p>}
            {isPending && <p className="loading">로딩중 ...</p>}
            {data && (
                <div>
                    <h2 className="page-title">"{query}"를 포함하는 레시피는</h2>
                    <RecipeList recipes={data} />
                </div>
            )}
        </div>
    );
};

export default Search;
