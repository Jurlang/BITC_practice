let panels = document.querySelectorAll(".panel");

for (let i = 0; i < panels.length; i++) {
  panels[i].addEventListener("mouseover", function () {
    showImg(panels[i]);
  });
}

function showImg(obj) {
  let pan = document.querySelector(".active");
  pan.classList.remove("active");
  obj.classList.add("active");
}
