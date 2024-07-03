import React from 'react';
import { format } from 'date-fns';
import './Calendar.css';

const CalendarDay = ({ day, openModal }) => {
  return (
    <div className="calendar-day" onClick={() => openModal(format(day, 'yyyy-MM-dd'))}>
      <span>{format(day, 'd')}</span>
    </div>
  );
};

export default CalendarDay;