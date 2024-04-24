const button = document.querySelector("button");
const buttons = document.querySelectorAll(".drum");
const objName = { w: "tom1", a: "tom2", s: "tom3", d: "tom4", j: "snare", k: "crash", l: "kick-bass" };

for (var i = 0; i < buttons.length; i++) {
  buttons[i].style.background = `url(images/${objName[buttons[i].textContent]}.png) center no-repeat`;
  buttons[i].style.backgroundSize = `cover`;
  buttons[i].addEventListener("click", function () {
    mouseClick(this);
  });
}

function mouseClick(obj) {
  var audio = new Audio("sounds/" + objName[obj.textContent] + ".mp3");
  console.log(objName[obj.textContent] + ".mp3");
  audio.play();
}

function keyboardClick(idx) {
  switch (idx) {
    case "w":
    case "a":
    case "s":
    case "d":
    case "j":
    case "k":
    case "l":
      var audio = new Audio("sounds/" + objName[idx] + ".mp3");
      console.log(objName[idx] + ".mp3");
      audio.play();
      break;
    default:
      break;
  }
}

document.onkeydown = (e) => keyboardClick(e.key);
