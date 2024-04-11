/**
 * calcul la moyenne
 * @param {Array} notes tableau des notes 
 * @param {Number} total taille total du tableau
 * @returns Number
 */
function avg(notes, total) {
  let sum = 0
  for(let i = 0; i < total; i++) {
    sum = sum + notes[i]
  }
  return sum / total
}

/**
 * Retourne la taille d'un tableau
 * On peut s'en passer et utiliser directement la propriété length sur un tableau tab.length
 * @param {Array} notes 
 * @returns Number
 */
function getLength(notes) {
  let i = 0
  while(notes[i]) { // En gros ici tant qu'on a une valeur on incrémente notre compteur
    i++
  }
  return i
}

/**
 * Demande les notes
 * @returns Array
 */
function askNotes() {
  let notes = []
  let note = 0
  let i = 0
  while(note != -1){
    note = prompt('Saisir une note')
    note = parseInt(note)
    if(note != -1) {
      /**
       * Vu que le prompt est dans la boucle, lorsqu'on saisit -1, on quittera la boucle au prochain tour
       * donc sans cette condition, la note  -1 sera ajouté au calcul et faussera le résultat
      */
      notes[i] = note
      i++ // ie i = i + 1
    }
  } 
  return notes
}

// Exécution

const notes = askNotes()
console.log('les notes ', notes)
const total = getLength(notes)
const avgStudent = avg(notes, total)

console.log('Moyenne est ', avgStudent)
