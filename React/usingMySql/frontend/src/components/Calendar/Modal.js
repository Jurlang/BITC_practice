import React, { useState } from "react";
import { format } from "date-fns";
import "./Modal.css";

const Modal = ({ isOpen, onClose, onSave, selectedDate, todoList }) => {
  const [task, setTask] = useState("");

  const handleClose = () => {
    setTask("");
    onClose();
  };

  const handleSave = () => {
    onSave(selectedDate, task);
    setTask("");
    onClose();
  };

  return (
    <div
      className={`modal fade ${isOpen ? "show" : ""}`}
      style={{ display: isOpen ? "block" : "none" }}
      tabIndex="-1"
      aria-hidden={!isOpen}
      role="dialog"
    >
      <div className="modal-dialog" role="document">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">
              {selectedDate ? `${selectedDate} 할 일` : "할 일 추가"}
            </h5>
          </div>
          <div className="modal-body">
            <h5>할 일</h5>
            <div>
              {todoList.length > 0
                ? todoList.map((todo, index) => {
                    return (
                      todo.selectedDate === format(selectedDate, "yyyy-MM-dd") && <p key={index}>{index+1}. {todo.task}</p>
                    );
                  })
                : "입력된 할 일이 없습니다."}
            </div>
            <hr/>
            <h5>입 력</h5>
            <textarea
              value={task}
              onChange={(e) => setTask(e.target.value)}
              placeholder="할 일을 입력하세요..."
              className="form-control"
              rows="5"
            />
          </div>
          <div className="modal-footer">
            <button
              type="button"
              className="btn btn-secondary"
              onClick={handleClose}
            >
              취소
            </button>
            <button
              type="button"
              className="btn btn-primary"
              onClick={handleSave}
            >
              저장
            </button>
          </div>
        </div>
      </div>
      {isOpen && <div className="modal-backdrop fade show zin"></div>}
    </div>
  );
};

export default Modal;
