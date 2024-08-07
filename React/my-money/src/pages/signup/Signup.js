import React, { useState } from "react";
import styles from "./Signup.module.css";
import useSignup from "../../hooks/useSignup";

export default function Signup() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");
    const { signup, error, isPending } = useSignup();

    const handleSubmit = (e) => {
        e.preventDefault();
        signup(email, password, name);
    };

    return (
        <form onSubmit={handleSubmit} className={styles["signup-form"]}>
            <h2>Sign-Up</h2>
            <label>
                <span>email : </span>
                <input type="email" onChange={(e) => setEmail(e.target.value)} value={email} />
            </label>
            <label>
                <span>password : </span>
                <input type="password" onChange={(e) => setPassword(e.target.value)} value={password} />
            </label>
            <label>
                <span>name : </span>
                <input type="text" onChange={(e) => setName(e.target.value)} value={name} />
            </label>
            {!isPending && <button className="btn">회원가입</button>}
            {isPending && (
                <button className="btn" disabled>
                    Loading
                </button>
            )}
            {error && <p>{error}</p>}
        </form>
    );
}
