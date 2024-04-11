let nb = prompt('Saisir un nombre entre 0 et 100')
nb = parseInt(nb)

if(nb >= 0 && nb <= 50) {
  console.log('nombre compris entre 0 et 50')
} else if(nb > 50 && nb <= 75) {
  console.log('nombre compris entre 51 et 75')
} else {
  console.log('nombre > 75 ou < 0')
}