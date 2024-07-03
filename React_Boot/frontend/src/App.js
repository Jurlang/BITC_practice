import Navbar from "./layout/Navbar";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import Home from "./pages/Home";

function App() {
  return (
    <div>
      <Navbar />
      <div className="container mt-5">
        <Home />
      </div>
    </div>
  );
}

export default App;
