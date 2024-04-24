const boxes = document.querySelectorAll(".box");

window.addEventListener("scroll", checkBoxes);

function checkBoxes() {
  const trigger = (window.innerHeight / 5) * 4.8;

  // array.forEach( func_name(array.item_name) )
  boxes.forEach((box) => {
    const boxTop = box.getBoundingClientRect().top; // 박스 상단의 높이

    // 박스 높이 < 트리거 포인트 => 박스를 원래 위치로
    if (boxTop < trigger) {
      box.classList.add("show");
    } else {
      box.classList.remove("show");
    }
  });
}

checkBoxes();
