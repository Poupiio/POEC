/**DECLARATION ****/

/**
 * Gère la saisie
 * @returns Number
 */
function saisi() {
  let nb0 = prompt("Saisir un nombre entre 0 et 100");
  nb0 = parseInt(nb0);
  return nb0;
}

/**
 * Gère la vérification
 * @param {Number} nb un nombre
 * @returns string
 */
function verifier(nb) {
  if (nb >= 0 && nb <= 50) {
    return "nombre compris entre 0 et 50";
  } else if (nb > 50 && nb <= 75) {
    return "nombre compris entre 51 et 75";
  } else if (nb < 0 || nb > 75) {
    return "nombre > 75 ou < 0";
  } else {
    return "n'est pas un nombre";
  }
}

/**
 * Gère l'affichage
 * @param {string} phrase
 */
function affiche(phrase) {
  console.log(phrase);
}

/**** EXECUTION */
let nb = saisi(); // D'abord la saisie
let result = verifier(nb); // Ensuite la vérification
affiche(result); // Enfin l'affichage
