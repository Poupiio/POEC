/**
 * Demande à l'utilisateur de saisir un nombre
 * @param {string} message message à afficher dans le prompt 
 * @returns Number
 */
function ask (message) {
  let nb = prompt(message)
  return parseInt(nb)
}

let nb = 0 // n'est pas le même que celui dans la fonction saisi

do {
  nb = ask('Saisir un nombre compris entre 0 et 10')
} while( nb < 0 || nb > 10 ) // en rentrant autre chose qu'un nombre le programme affichera NaN (Not a Number), c'est une piste d'amélioration du programme
// quand j'arrive ici je suis sûre à 1000000000 % que l'utilisateur a saisi la bonne valeur
console.log(`Nombre saisi est ${nb}`)