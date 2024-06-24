/* eslint-disable react/prop-types */
import { useState } from "react";
import "../css/TaskForm.css";
import Tag from "./Tag";

export default function TaskForm({setTasks}) {
  const [taskData, setTaskData] = useState({ task: "", status: "todo", tags: [] });

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log({ taskData });
    setTasks((prev) => {
      return [...prev, taskData];
    })
    setTaskData({
      task:'', status:"todo", tags: []
    })
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setTaskData((prev) => {
      return { ...prev, [name]: value };
    });
  };

  const selectTag = (tag) => {
    if (taskData.tags.some((item) => item === tag)) {
      const filterTags = taskData.tags.filter((item) => item !== tag);
      setTaskData((prev) => {
        return { ...prev, tags: filterTags };
      });
    } else {
      setTaskData((prev) => {
        return { ...prev, tags: [...prev.tags, tag] };
      });
    }
  };

  const checkTag = (tag) => {
    return taskData.tags.some((item) => item === tag);
  };

  return (
    <header className="app_header">
      <form onSubmit={handleSubmit}>
        <input type="text" name="task" className="task_input" onChange={handleChange} value={taskData.task} placeholder="Enter your task" />

        <div className="task_form_bottom_line">
          <div>
            <Tag tagName="HTML" selectTag={selectTag} selected={checkTag("HTML")} />
            <Tag tagName="JavaScript" selectTag={selectTag} selected={checkTag("JavaScript")} />
            <Tag tagName="CSS" selectTag={selectTag} selected={checkTag("CSS")} />
            <Tag tagName="React" selectTag={selectTag} selected={checkTag("React")} />
          </div>
          <div>
            <select name="status" className="task_status" value={taskData.status} onChange={handleChange}>
              <option value="todo">할일</option>
              <option value="doing">진행중</option>
              <option value="done">완료</option>
            </select>
            <button type="submit" className="task_submit">
              + 추가
            </button>
          </div>
        </div>
      </form>
    </header>
  );
}
