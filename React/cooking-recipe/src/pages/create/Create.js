import React, { useRef, useState, useEffect } from "react";
import {useNavigate} from "react-router-dom";
import "./Create.css";
import { useFetch } from "../../hooks/useFetch";

const Create = () => {
    const [title, setTitle] = useState("");
    const [method, setMethod] = useState("");
    const [cookingTime, setCookingTime] = useState(0);
    const [newIngredient, setNewIngredient] = useState("");
    const [ingredients, setIngredients] = useState([]);
    const ingredientInput = useRef();
    const { postData, data } = useFetch("http://localhost:3030/recipes", "POST");
    const navigate = useNavigate();

    useEffect(() => {
        if(data) {
            navigate("/");
        }
    }, [data, navigate]);

    const handleSubmit = (e) => {
        e.preventDefault();
        postData({ title, ingredients, method, cookingTime: cookingTime + " 분" });
        console.log({ title, ingredients, method, cookingTime: cookingTime + " 분" });
    };

    const handleAdd = (e) => {
        e.preventDefault();
        const ing = newIngredient.trim();

        if (ing && !ingredients.includes(ing)) {
            setIngredients((prevIngredients) => [...prevIngredients, newIngredient]);
        }
        setNewIngredient("");
        ingredientInput.current.focus();
    };

    return (
        <div>
            <div className="create">
                <h2 className="page-title">새 레시피를 추가하세요</h2>
                <form onSubmit={handleSubmit}>
                    <label>
                        <span>요리 제목 : </span>
                        <input type="text" onChange={(e) => setTitle(e.target.value)} value={title} required />
                    </label>
                    <label>
                        <span>요리 재료 : </span>
                        <div className="ingredients">
                            <input type="text" onChange={(e) => setNewIngredient(e.target.value)} value={newIngredient} ref={ingredientInput} />
                            <button onClick={handleAdd} className="btn">
                                사용
                            </button>
                        </div>
                    </label>
                    <p>
                        재료들 :{" "}
                        {ingredients.map((i) => (
                            <em key={i}>{i}, </em>
                        ))}{" "}
                    </p>
                    <label>
                        <span>요리 방법 : </span>
                        <textarea onChange={(e) => setMethod(e.target.value)} value={method} required />
                    </label>
                    <label>
                        <span>쿠킹 타임 (분) : </span>
                        <input type="number" onChange={(e) => setCookingTime(e.target.value)} value={cookingTime} required />
                    </label>
                    <button className="btn">추가</button>
                </form>
            </div>
        </div>
    );
};

export default Create;
