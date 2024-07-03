import React from 'react';
import CalendarDay from './CalendarDay';
import './Calendar.css';

const CalendarBody = ({ days, openModal, task }) => {
  return (
    <div className="calendar-body">
      {days.map((day, index) => (
        <CalendarDay key={index} day={day} openModal={openModal} task={task} />
      ))}
    </div>
  );
};

export default CalendarBody;