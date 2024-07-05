import React from "react";
import { format } from "date-fns";
import "./Calendar.css";
import CalendarCard from "./CalendarCard";

const CalendarDay = ({ day, openModal, todoList }) => {
  const today =
    new Date().getMonth() === new Date(day).getMonth() &&
    new Date().getDate() === new Date(day).getDate();
  return (
    <div
      className={`calendar-day m-1 ${
        today ? "border border-primary border-3" : ""
      }`}
      onClick={() => openModal(format(day, "yyyy-MM-dd"))}
    >
      <span>{format(day, "d")}</span>
      {todoList.length > 0
        ? todoList.map((todo, index) => {
            return (
              todo.selectedDate === format(day, "yyyy-MM-dd") && (
                <CalendarCard key={index} todo={todo} />
              )
            );
          })
        : null}
    </div>
  );
};

export default CalendarDay;
