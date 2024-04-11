/**
 * Contraindre l'utilisateur à saisir un nombre inférieur à 100
 * @param {string} msg 
 */
function ask(msg) {
  let nb = 0
  do {
    nb = prompt(msg)
    nb = parseInt(nb)
  } while( nb > 100 )
  return nb
}

/**
 * Affiche une suite de nombre
 * @param {Number} nb 
 */
function display(nb) {
  for(let i = nb; i <= 100; i++) {
    console.log(i)
  }
}

/**
 * N'est pas le même que celui qui est dans la fonction ask
 */
let nb = ask('Saisir un nombre < 100')
display(nb)