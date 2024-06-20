import React, { useEffect, useMemo, useState } from "react";
import styles from "./Home.module.css";
import TransactionForm from "../../components/TransactionForm";
import { useAuthContext } from "../../hooks/useAuthContext";
import { useCollection } from "../../hooks/useCollection";
import TransactionList from "./TransactionList";

export default function Home() {
    const { user } = useAuthContext();
    const [selected, setSelected] = useState("");
    const { documents, error } = useCollection("transactions", ["uid", "==", user.uid]);
    const selectList = [
        { value: "", name: "선택" },
        { value: "createdAt", name: "최신순"},
        { value: "amount", name: "비용순"},
        { value: "name", name: "가나다순"}
    ];
   
    const handleSelect = (e) => {
        setSelected(e.target.value);
    }

    const sortedDocuments = useMemo(() => {
        if (!documents) return null;

        const sorted = [...documents];

        switch (selected) {
            case "createdAt":
                return sorted.sort((a, b) => b.createdAt - a.createdAt);
            case "amount":
                return sorted.sort((a, b) => b.amount - a.amount);
            case "name":
                return sorted.sort((a, b) => a.name.localeCompare(b.name));
            default:
                return documents;
        }
    }, [documents, selected]);

    return (
        <div className={styles.container}>
            <div className={styles.content}>
                <select onChange={handleSelect} value={selected}>
                    {selectList.map((item) => {
                        return <option value={item.value} key={item.value}>
                            {item.name}
                        </option>
                    })}
                </select>
                {error && <p>{error}</p>}
                {sortedDocuments && <TransactionList transactions={sortedDocuments} />}
            </div>
            <div className={styles.sidebar}>
                <TransactionForm uid={user.uid} />
            </div>
        </div>
    );
}
