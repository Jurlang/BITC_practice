import { auth } from "./config/firebase";

const ChatMessage = (props) => {
    const { text, uid, photoURL } = props.message;
	console.log(photoURL);
    const messageClass = uid === auth.currentUser.uid ? "sent" : "received";
    return (
        <div className={`message ${messageClass}`}>
            <img src={ photoURL || "/images/puppy.png"} />
            <p>{text}</p>
        </div>
    );
};

export default ChatMessage;
