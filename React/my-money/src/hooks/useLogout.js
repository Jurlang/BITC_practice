import { useEffect, useState } from "react";
import { useAuthContext } from "./useAuthContext";
import { fireauth } from "../firebase/config";

export const useLogout = () => {
    const [error, setError] = useState();
    const [isPending, setIsPending] = useState(false);
    const [isCancelled, setIsCancelled] = useState(false);
    const { dispatch } = useAuthContext();

    useEffect(() => {
        setIsCancelled(false);
        return () => setIsCancelled(true);
    }, []);

    const logout = async () => {
        setError(null);
        setIsPending(true);

        try {
            await fireauth.signOut();
            dispatch({ type: "LOGOUT" });

            setIsPending(false);
            setError(null);

            if (!isCancelled) {
                setIsPending(false);
                setError(null);
            }
        } catch (err) {
            if (!isCancelled) {
                console.log(err.message);
                setError(err.message);
                setIsPending(false);
            }
        }
    };

    return { logout, error, isPending };
};
