import { addDoc, collection, limit, orderBy, query, serverTimestamp } from "firebase/firestore";
import { useEffect, useRef, useState } from "react";
import { auth, db } from "./config/firebase";
import { useCollectionData } from "react-firebase-hooks/firestore";
import ChatMessage from "./ChatMessage";

const ChatRoom = () => {
    const dummy = useRef();
    const [formValue, setFormValue] = useState("");
    const messagesRef = collection(db, "messages");
    const q = query(messagesRef, orderBy("createdAt"), limit(25));
    const [messages] = useCollectionData(q);

    const sendMessage = async (e) => {
        e.preventDefault();
        const { uid, photoURL } = auth.currentUser;

        await addDoc(messagesRef, {
            text: formValue,
            createdAt: serverTimestamp(),
            uid,
            photoURL,
        });
        setFormValue("");
    };

	useEffect(() => {
		dummy.current.scrollIntoView({ behavior: 'smooth' });
	}, [messages])

    return (
        <>
            <main>
                {messages && messages.map((msg, idx) => <ChatMessage key={idx} message={msg} />)}

                <span ref={dummy}></span>
            </main>
            <form onSubmit={sendMessage}>
                <input value={formValue} onChange={(e) => setFormValue(e.target.value)} placeholder="메세지를 입력하세요~" />
                <button type="submit" disabled={!formValue}>
                    💬
                </button>
            </form>
        </>
    );
};

export default ChatRoom;
