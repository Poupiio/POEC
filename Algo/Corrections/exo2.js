let nb1 = prompt('Nombre 1')
let nb2 = prompt('Nombre 2')

nb1 = parseInt(nb1)
nb2 = parseInt(nb2)

console.log(`Addition de ${nb1} et ${nb2} = `, nb1 + nb2)
console.log(`Soustraction de ${nb2} et ${nb1} = `, nb2 - nb1)
console.log(`Multiplication de ${nb1} et ${nb2} = `, nb1 * nb2)
if(nb2 === 0) {
  console.log('division par 0 impossible !')
} else {
  console.log(`Division de ${nb1} et ${nb2} = `, nb1 / nb2)
}