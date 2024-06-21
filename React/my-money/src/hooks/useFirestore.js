import { useEffect, useReducer, useState } from "react";
import { firedb, timestamp } from "../firebase/config";

let initialState = {
	document: null,
	isPending: false,
	error: null,
	success: false
};

const firestoreReducer = (state, action) => {
	switch (action.type) {
		case 'IS_PENDING':
			return { isPending: true, document: null, success: false, error: null};
		case 'ADDED_DOCUMENT':
			return { isPending: false, document: action.payload, success: true, error: null};
		case 'ERROR':
			return { isPending: false, document: null, success: false, error: action.payload};
		case 'DELETE_DOCUMENT':
			return { isPending: false, document: null, success: true, error: null};
		default:
			return state;
	}
};

export const useFirestore = ( collection) => {
	const [response, dispatch] = useReducer(firestoreReducer, initialState);
	const [isCancelled, setIsCancelled] = useState(false);

	const ref = firedb.collection(collection);

	const dispatchIfNotCancelled = (action) => {
		if(!isCancelled) {
			dispatch(action);
		}
	};

	const addDocument = async(doc) => {
		dispatch({type: 'IS_PENDING'});

		try{
			const createdAt = timestamp.fromDate(new Date());
			const addedDocument = await ref.add({...doc, createdAt});
			dispatchIfNotCancelled({type: 'ADDED_DOCUMENT', payload: addedDocument});
		} catch(err){
			dispatchIfNotCancelled({type: 'ERROR', payload: err.message});
		}
	};

	const deleteDocument = async (id) => {
        dispatch({type: 'IS_PENDING'});
        try {
            await ref.doc(id).delete();
            dispatchIfNotCancelled({type: 'DELETE_DOCUMENT'});
        } catch(err){
            dispatchIfNotCancelled({type: 'ERROR', paylod: '삭제할 수 없습니다.'});
        }
    };

    useEffect(() => {
        setIsCancelled(false);
        return() => setIsCancelled(true);
    }, []);

	return {addDocument, deleteDocument, response};

}