const price = document.getElementById('price');
const response = document.getElementById('response');
const replay = document.getElementById('replay');

let randomNum = Math.floor(Math.random() * 20 + 1);
console.log(randomNum);

const replayGame = () => {
   price.value = "";

   response.textContent = "";

   randomNum = Math.floor(Math.random() * 20 + 1);
   console.log(randomNum);
}

price.addEventListener('change', (e) => {
   let guessNum = e.target.value;

   if (guessNum == randomNum) {
      response.textContent = "C'est gagné !";
      response.style.color = "#46A758";
      response.style.fontSize = "3rem";
   } else if (guessNum < randomNum) {
      response.textContent = "C'est + !";
      response.style.color = "#D13415";
      response.style.fontSize = "2rem";
   } else {
      response.textContent = "C'est - !";
      response.style.color = "#D13415";
      response.style.fontSize = "2rem";
   }
})


replay.addEventListener('click', replayGame);