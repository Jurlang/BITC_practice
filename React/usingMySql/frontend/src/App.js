import "./App.css";
import { useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";
import Routing from "./components/Routing";
import "bootstrap/dist/css/bootstrap.min.css";


function App() {
  const [user, setUser] = useState(null);
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (token !== null) {
      const jwtUser = jwtDecode(token);
      setUser(jwtUser);
      setIsAuthenticated(true);
    }
  }, []);

  return <Routing user={user}/>;
}

export default App;
