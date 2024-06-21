import { signOut } from "firebase/auth";
import { auth } from "./config/firebase";

const SignOut = () => {
    const logout = async () => {
        try {
            await signOut(auth);
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <div>
            <button className="sign-out" onClick={logout}>
                Sign out
            </button>
        </div>
    );
};

export default SignOut;
