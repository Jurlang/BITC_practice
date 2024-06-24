import "./App.css";
import todoIcon from "./assets/direct-hit.png";
import doingIcon from "./assets/glowing-star.png";
import doneIcon from "./assets/check-mark-button.png";

import TaskColumn from "./components/TaskColumn";
import TaskForm from "./components/TaskForm";
import { useState } from "react";

export default function App() {
  const [tasks, setTasks] = useState([]);

  const handleDelete = (taskIndex) => {
    const newTasks = tasks.filter((task, index) => index !== taskIndex);
    setTasks(newTasks);
  };

  return (
    <div className="app">
      <TaskForm setTasks={setTasks} />
      <header className="app_header">Header Section</header>
      <main className="app_main">
        <TaskColumn title="할 일" icon={todoIcon} tasks={tasks} status="todo" handleDelete={handleDelete} />
        <TaskColumn title="진행 중" icon={doingIcon} tasks={tasks} status="doing" handleDelete={handleDelete} />
        <TaskColumn title="완 료" icon={doneIcon} tasks={tasks} status="done" handleDelete={handleDelete} />
      </main>
    </div>
  );
}
