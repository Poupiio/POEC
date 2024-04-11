const lastName = prompt('Nom ?')
const firstName = prompt('Prénom ?')
let age = prompt('Age')
age = parseInt(age)

console.log(`Nom : ${lastName}, Prénom : ${firstName} et age ${age}`)

if(age >= 18) { // début du bloc conditionnelle (grande condition) ici
  if( age === 18) { // un autre bloc conditionnelle (petite condition)
    console.log('Exactement 18 !')
  } else {
    console.log('Majeur !')
  } 
} else {
  console.log('Mineur !')
} // fin du bloc conditionnelle
// le programme continue ensuite après avoir exécuté l'une de 3 issus