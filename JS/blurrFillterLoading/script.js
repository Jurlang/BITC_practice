const loadText = document.querySelector(".loading-text");
const bg = document.querySelector(".bg");

let load = 0;

let interval = setInterval(blurring, 100); // 0.1초에 한번씩 함수 실행

function blurring() {
  load = load + 2;
  if (load > 99) {
    // bg.style.filter = "blur(0px)";
    clearInterval(interval); // Interval 종료
  }

  bg.style.filter = `blur(${scale(load, 0, 100, 30, 0)}px`;
  loadText.textContent = load;
  loadText.style.opacity = scale(load, 0, 100, 1, 0);

  console.log(load);
}

const scale = (num, in_min, in_max, out_min, out_max) => {
  return ((num - in_min) * (out_max - out_min)) / (in_max - in_min) + out_min;
};
