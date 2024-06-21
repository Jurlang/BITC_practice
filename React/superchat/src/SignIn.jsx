import { auth, googleAuth } from "./config/firebase";
import { signInWithPopup } from "firebase/auth";

const SignIn = () => {
    const signInWithGoogle = async () => {
        try {
            await signInWithPopup(auth, googleAuth);
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <div>
            <button className="sign-in" onClick={signInWithGoogle}>
                Sign in with Google
            </button>
            <p>💚💙💜커뮤니티에서 예의를 지켜주세요🤎🧡💛</p>
        </div>
    );
};

export default SignIn;
