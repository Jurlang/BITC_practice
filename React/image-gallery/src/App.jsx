import { useState } from "react";
import Gallery from "./components/Gallery";
import SearchForm from "./components/SearchForm";
import ThemeToggle from "./components/ThemeToggle";
import PopupBox from "./components/PopupBox";

function App() {
    const [item, setItem] = useState(null);
    return (
        <main>
            <ThemeToggle />
            <SearchForm />
            <Gallery setItem={setItem}/>
            {item && <PopupBox item={item} setItem={setItem}/> }
        </main>
    );
}

export default App;
