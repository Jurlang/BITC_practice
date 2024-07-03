import React, { useState } from 'react';
import { startOfMonth, endOfMonth, startOfWeek, endOfWeek, addDays, addMonths } from 'date-fns';
import CalendarHeader from './CalendarHeader';
import CalendarBody from './CalendarBody';
import Modal from './Modal';
import './Calendar.css';

const Calendar = () => {
  const [task, setTask] = useState([]);
  const [currentDate, setCurrentDate] = useState(new Date());
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedDate, setSelectedDate] = useState(null);

  const nextMonth = () => {
    setCurrentDate(addMonths(currentDate, 1));
  };

  const prevMonth = () => {
    setCurrentDate(addMonths(currentDate, -1));
  };

  const openModal = (date) => {
    setSelectedDate(date);
    setModalOpen(true);
  };

  const closeModal = () => {
    setModalOpen(false);
  };

  const saveTask = (task) => {
    console.log(`${selectedDate}: ${task}`);
    closeModal();
  };

  const startDate = startOfWeek(startOfMonth(currentDate));
  const endDate = endOfWeek(endOfMonth(currentDate));

  let date = startDate;
  const days = [];
  while (date <= endDate) {
    days.push(date);
    date = addDays(date, 1);
  }

  return (
    <div className="calendar-container">
      <CalendarHeader currentDate={currentDate} nextMonth={nextMonth} prevMonth={prevMonth} />
      <CalendarBody days={days} openModal={openModal} task={task} />
      <Modal isOpen={modalOpen} onClose={closeModal} onSave={saveTask} selectedDate={selectedDate} task={task} setTask={setTask}/>
    </div>
  );
};

export default Calendar;