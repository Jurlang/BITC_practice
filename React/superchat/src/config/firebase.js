import { initializeApp } from "firebase/app";
import { GoogleAuthProvider, getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";

const firebaseConfig = {
  apiKey: "AIzaSyBeILTy_vXt9EKQ7KowSlR_erfi4ccNQi8",
  authDomain: "superchat-8ed28.firebaseapp.com",
  projectId: "superchat-8ed28",
  storageBucket: "superchat-8ed28.appspot.com",
  messagingSenderId: "284926023817",
  appId: "1:284926023817:web:308d2be88388c631114e58"
};

export const app = initializeApp(firebaseConfig);

export const auth = getAuth(app);

export const googleAuth = new GoogleAuthProvider(app);

export const db = getFirestore(app)