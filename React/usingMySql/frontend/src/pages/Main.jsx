import React, { useEffect, useState } from "react";
import Calendar from "../components/Calendar/Calendar";
import Navbar from "../components/Navbar/Navbar";

const Main = ({user}) => {
  const [todo, setTodo] = useState({
    selectedDate: "",
    task: "",
  });
  const [todoList, setTodoList] = useState([]);

  useEffect(() => {
    if(localStorage.getItem("todoList")!==null)
    setTodoList(localStorage.getItem("todoList"));
  }, []);

  return (
    <div>
      <Navbar user={user} todoList={todoList}/>

      <Calendar todo={todo} setTodo={setTodo} todoList={todoList} setTodoList={setTodoList} />
    </div>
  );
};

export default Main;
