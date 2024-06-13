import { useState, useEffect } from "react";
import "./App.css";
import ImageCard from "./component/ImageCard";
import ImageSearch from "./component/ImageSearch";

function App() {
    const [images, setImages] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    const [term, setTerm] = useState("puppy");

    useEffect(() => {
        // fetch(api_url) 에서 데이터를 받고 .then() 에서 처리, catch() 는 에러 발생시
        fetch(`https://pixabay.com/api/?key=${process.env.REACT_APP_PIXABAY_API_KEY}&q=${term}&image_type=photo&orientation=horizontal`)
            .then((res) => res.json())
            .then((data) => setImages(data.hits))
            .catch((err) => console.log(err));
    }, [term]);

    return (
        <div className="container mx-auto my-7">
            <ImageSearch setTerm={setTerm} />
            {images.length === 0 && <h1 className="text-5xl text-center mt-32">이미지가 없습니다.</h1>}
            {images.length > 0 && (
                <div className="grid sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-7">
                    {images.map((img) => (
                        <ImageCard key={img.id} image={img} />
                    ))}
                </div>
            )}
        </div>
    );
}

export default App;
