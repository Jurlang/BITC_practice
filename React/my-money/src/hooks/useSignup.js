import { useEffect, useState } from "react";
import { fireauth } from "../firebase/config";
import { useAuthContext } from "./useAuthContext";

const useSignup = () => {
    const [error, setError] = useState();
    const [isPending, setIsPending] = useState(false);
    const [isCancelled, setIsCancelled] = useState(false);
    const { dispatch } = useAuthContext();

    useEffect(() => {
        return () => setIsCancelled(true);
    }, []);

    const signup = async (email, password, displayName) => {
        setError(null);
        setIsPending(true);

        try {
            const res = await fireauth.createUserWithEmailAndPassword(email, password);
            console.log(res.user);

            if (!res) {
                throw new Error("가입 중 오류가 발생했습니다.");
            }

            await res.user.updateProfile({ displayName: displayName });

            dispatch({ type: "LOGIN", payload: res.user });
            if (!isCancelled) {
                setError(null);
                setIsPending(false);
            }
        } catch (err) {
            if (!isCancelled) {
                console.log(err.message);
                setError(err.message);
                setIsPending(false);
            }
        }
    };

    return { signup, error, isPending };
};

export default useSignup;
