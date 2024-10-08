import { createContext, useReducer } from "react";
import AlertReducer from "./AlertReducer";

const AlertContext = createContext();

export const AlertProvider = ({ children }) => {
  const initialState = null;

  const [state, dispatch] = useReducer( AlertReducer ,  initialState );

  // 경고창 메세지를 설정하고 3초뒤 제거
  const setAlert = (msg, type) => {
    dispatch({
      type: 'SET_ALERT',
      payload: { msg, type },
    });

    setTimeout(() => dispatch({ type: 'REMOVE_ALERT' }), 1000 );
  };

  return (
    <AlertContext.Provider value={{
      alert: state,
      setAlert
    }}>
      {children}
    </AlertContext.Provider>
  );
};

export default AlertContext;