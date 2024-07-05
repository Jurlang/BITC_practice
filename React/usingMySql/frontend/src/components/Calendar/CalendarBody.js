import React from "react";
import CalendarDay from "./CalendarDay";
import "./Calendar.css";
import { format } from "date-fns";

const CalendarBody = ({ days, openModal, todoList }) => {
  return (
    <div className="calendar-body">

      {days.map((day, index) => {
        return (
        <CalendarDay
          key={index}
          day={day}
          openModal={openModal}
          todoList={todoList}
        />
      )} )}
    </div>
  );
};

export default CalendarBody;
