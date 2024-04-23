const button = document.querySelector("button");
const buttons = document.querySelectorAll(".drum");
const arrName = { w: "crash", a: "kick-bass", s: "snare", d: "tom1", j: "tom2", k: "tom3", l: "tom4" };

for (var i = 0; i < buttons.length; i++) {
  buttons[i].style.background = `url(images/${arrName[buttons[i].className.split(" ")[0]]}.png)`;
  buttons[i].addEventListener("click", function () {
    handleClick(this);
  });
}

function handleClick(idx) {
  var audio = new Audio("sounds/" + arrName[idx.className.split(" ")[0]] + ".mp3");
  audio.play();
}
