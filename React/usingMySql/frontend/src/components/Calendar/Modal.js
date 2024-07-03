import React, { useState } from 'react';
import './Modal.css';

const Modal = ({ isOpen, onClose, onSave, selectedDate, task, setTask }) => {

  if (!isOpen) return null;

  const handleSave = () => {
    onSave(task);
    setTask('');
  };

  return (
    <div className="modal-overlay">
      <div className="modal">
        <h2>{selectedDate ? `${selectedDate} 할 일` : '할 일 추가'}</h2>
        <textarea
          value={task}
          onChange={(e) => setTask(e.target.value)}
          placeholder="할 일을 입력하세요..."
        />
        <div className="modal-actions">
          <button onClick={handleSave}>저장</button>
          <button onClick={onClose}>취소</button>
        </div>
      </div>
    </div>
  );
};

export default Modal;