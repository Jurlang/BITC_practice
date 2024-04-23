function calc() {
  var currentYear = 2024;
  var birthYear = prompt("생년을 적으세요");
  var age = currentYear - birthYear;
  document.querySelector("#result").innerHTML = "당신의 나이는 " + age + "세 입니다.";
}

function showPrice() {
  var oprice = document.querySelector("#oPrice").value;
  var sale = document.querySelector("#rate").value;
  var save = oprice * (sale / 100);
  var sprice = oprice - save;

  document.querySelector("#showResult").innerHTML = "상품의 원래 가격은 " + oprice + "원이고, 할인율은 " + sale + "% 입니다.<br>" + save + "원을 절약한 " + sprice + "원에 살 수 있습니다.";
}
