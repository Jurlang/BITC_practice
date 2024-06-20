import React from "react";
import styles from "./Home.module.css";
import TransactionForm from "../../components/TransactionForm";

export default function Home() {
    return (
        <div className={styles.container}>
            <div className={styles.content}>거래내역</div>
            <div className={styles.sidebar}>
                <TransactionForm />
            </div>
        </div>
    );
}
