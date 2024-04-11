const lastName = prompt('Nom ?')
const firstName = prompt('Prénom ?')
let age = prompt('Age')
age = parseInt(age)

console.log(`Nom : ${lastName}, Prénom : ${firstName} et age ${age}`)

if(age > 18) { // début du bloc conditionnelle ici
  console.log('Majeur !')
} else if( age === 18) {
  console.log('Exactement 18 !')
} else {
  console.log('Mineur !')
} // fin du bloc conditionnelle
// le programme continue (sort de la boucle conditionnelle) après avoir exécuté l'une de 3 issus