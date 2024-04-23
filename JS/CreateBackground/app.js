let body = document.querySelector("#gradient");
let color1 = document.querySelector(".color1");
let color2 = document.querySelector(".color2");
let css = document.querySelector("h3");

color1.addEventListener("change", setGradient);
color2.addEventListener("change", setGradient);

function setGradient() {
  body.style.background = `linear-gradient(to right, ${color1.value} , ${color2.value})`;
  css.textContent = body.style.background + ";";
}
