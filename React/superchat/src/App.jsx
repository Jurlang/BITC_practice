import "./App.css";
import { useAuthState } from 'react-firebase-hooks/auth';

import { auth } from './config/firebase';
import SignOut from "./SignOut";
import SignIn from "./SignIn";
import ChatRoom from "./ChatRoom";

function App() {
  const [ user, loading, error ] = useAuthState(auth);
  console.log(user);
  if(loading) {
    return (
      <div>
        <p>Loading ...</p>
      </div>
    );
  }
  if (error) {
    return (
      <div>
        <p>Error: {error}</p>
      </div>
    );
  }
    return (
        <div className='App'>
          <header>
            <h1>SuperChat💬</h1>
            {user && <SignOut />}
          </header>
          <section>{user? <ChatRoom/> : <SignIn />}</section>
        </div>
    );
}

export default App;
