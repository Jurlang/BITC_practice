import { useEffect, useState } from "react";
import { useFirestore } from "../hooks/useFirestore";

export default function TransactionForm({uid}) {
    const [name, setName] = useState("");
    const [amount, setAmount] = useState("");
	const {addDocument, response} = useFirestore('transactions');

	useEffect(() => {
		if(response.success) {
			setName('');
			setAmount('');
		}
	}, [response.success]);

    const handleSubmit = (e) => {
        e.preventDefault();
        addDocument({uid,name,amount});
    };

	return (
		<div>
			<h3>거래 추가</h3>
			<form onSubmit={handleSubmit}>
				<label>
					<span>거래명 : </span>
					<input type="text" required onChange={(e) => setName(e.target.value)} value={name} />
				</label>
				<label>
					<span>가격(원) : </span>
					<input type="number" required onChange={(e) => setAmount(e.target.value)} value={amount} />
				</label>
				<button>추가</button>
			</form>
		</div>
	);
}
