import React from "react";
import { format } from "date-fns";

const CalendarHeader = ({ currentDate, nextMonth, prevMonth }) => {
  return (
    <div className="calendar-header">
      <button className="calendar-button" onClick={prevMonth}>이전</button>
      <span>{format(currentDate, "yyyy년 MM월")}</span>
      <button className="calendar-button" onClick={nextMonth}>다음</button>
    </div>
  );
};

export default CalendarHeader;
