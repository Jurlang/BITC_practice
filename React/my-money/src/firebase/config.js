import firebase from "firebase/app";
import 'firebase/auth';
import "firebase/firestore";

const firebaseConfig = {
    apiKey: "AIzaSyA2Up-8XUiH0d2xmT5BQV5aByDbFuZoObE",
    authDomain: "mymoney-b977f.firebaseapp.com",
    projectId: "mymoney-b977f",
    storageBucket: "mymoney-b977f.appspot.com",
    messagingSenderId: "157294948997",
    appId: "1:157294948997:web:0b4c4d5fb5c24017662fec",
};

//firebase init
firebase.initializeApp(firebaseConfig);

//init service
const firedb = firebase.firestore();
//login auth
const fireauth = firebase.auth();
//db date time
const timestamp = firebase.firestore.Timestamp;

export { firedb, fireauth, timestamp };
