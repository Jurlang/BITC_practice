let img1 = document.querySelector(".img1");
let img2 = document.querySelector(".img2");
let divs = document.querySelectorAll(".dice");
let h1 = document.querySelector("h1");

function game() {
  let num1 = Math.floor(Math.random() * 6) + 1;
  let num2 = Math.floor(Math.random() * 6) + 1;

  img1.setAttribute("src", "./images/dice" + num1 + ".png");
  img2.setAttribute("src", "./images/dice" + num2 + ".png");

  if (num1 > num2) h1.innerHTML = "🚩Player 1 Win";
  else if (num1 == num2) h1.innerHTML = "Draw !";
  else h1.innerText = "Player 2 Win🚩";
}

divs[0].addEventListener("click", game);
divs[1].addEventListener("click", game);
