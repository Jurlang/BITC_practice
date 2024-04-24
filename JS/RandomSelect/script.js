const tagsEl = document.getElementById("tags");
const textarea = document.getElementById("textarea");

textarea.focus();

textarea.addEventListener("keyup", (e) => {
  createTags(e.target.value);
  if (e.key === "Enter") {
    setTimeout(() => {
      e.target.value = "";
    }, 10);

    randomSelect();
  }
});

function createTags(input) {
  const tags = input
    .split(",") // input split.
    .filter((tag) => tag.trim() !== "") // 공백들어간 부분 제거
    .map((tag) => tag.trim()); // 각 배열 데이터 속의 공백 제거

  console.log(tags);

  tagsEl.innerHTML = "";

  tags.forEach((tag) => {
    const tagEl = document.createElement("span");
    tagEl.classList.add("tag");
    tagEl.textContent = tag;
    tagsEl.appendChild(tagEl);
  });
}

function randomSelect() {
  let cnt = 0;
  const times = 30;
  const interval = setInterval(() => {
    const randomTag = randomTagFunc();
    if (randomTag !== undefined) {
      addHighlight(randomTag);

      if (cnt < 19) {
        setTimeout(() => {
          removeHighlight(randomTag);
        }, 100);
      }
    }
    cnt = cnt + 1;
    console.log(cnt);
    if (cnt == 20) clearInterval(interval);
  }, 100);
}

function randomTagFunc() {
  const tags = document.querySelectorAll(".tag");
  return tags[Math.floor(Math.random() * tags.length)];
}

function addHighlight(tag) {
  tag.classList.add("highlight");
}
function removeHighlight(tag) {
  tag.classList.remove("highlight");
}
