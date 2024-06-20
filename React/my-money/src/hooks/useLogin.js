import { useState } from "react";
import { fireauth } from "../firebase/config";
import { useAuthContext } from "./useAuthContext";

export const useLogin = () => {
    const [error, setError] = useState();
    const [isPending, setIsPending] = useState();
    const { dispatch } = useAuthContext();

    const login = async (email, password) => {
        setError(null);
        setIsPending(true);

        try {
            const res = await fireauth.signInWithEmailAndPassword(email, password);
            dispatch({ type: "LOGIN", payload: res.user });
            setError(null);
            setIsPending(false);
        } catch (err) {
            console.log(err.message);
            setError(err.message);
            setIsPending(false);
        }
    };
    return { login, error, isPending };
};
