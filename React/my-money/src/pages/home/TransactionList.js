import { useFirestore } from "../../hooks/useFirestore";
import styles from "./Home.module.css";

export default function TransactionList({ transactions }) {
    const {deleteDocument} = useFirestore('transactions');
    return (
        <div>
            <div className={styles.transactions}>
                {transactions.map((transaction) => (
                    <li key={transaction.id}>
                        <p className={styles.name}>{transaction.name}</p>
                        <p className={styles.amount}>{transaction.amount}원</p>
                        <button onClick={() => deleteDocument(transaction.id)}>X</button>
                    </li>
                ))}
            </div>
        </div>
    );
}
