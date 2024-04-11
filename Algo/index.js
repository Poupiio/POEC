/* EXERCICE 1
Demandez à l'utilisateur de saisir son nom, prénom et âge.
Affichez une phrase contenant le nom, prénom et âge de l'utilisateur.
Aide avec JavaScript
Utilisez la fonction prompt pour ouvrir une fenêtre de dialogue avec un utilisateur.
Utilisez la fonction console.log */

// let ask = prompt("Saisissez votre nom, prénom et votre âge");

// const displayData = (data) => {
//     console.log("Données saisies par l'utilisateur : " + data);
// }
// displayData(ask);


/* EXERCICE 2
Demandez à l'utilisateur de saisir 2 nombres entiers.
Affichez le résultat de l'addition de ces 2 nombres.
Affichez le résultat de la soustraction de ces 2 nombres.
Affichez le résultat de la multiplication de ces 2 nombres.
Affichez le résultat de la division de ces 2 nombres.
Uniquement pour ce dernier point (numéro 5), lorsque le dénominateur (deuxième nombre saisi par l'utilisateur) est égal à 0, n'effectuez pas l'opération, affichez le message suivant "Division par 0 impossible". */


// let askNumbers = prompt("Saisissez 2 nombres");
// let numbers = askNumbers.split (" ")
// let num1 = parseInt(numbers[0]);
// let num2 = parseInt(numbers[1]);

// const displayNumbers = (a, b) => {
//     const add = a + b;
//     const substract = a -b;
//     const multiplication = a - b;
//     const division = b === 0 ? "Division par 0 impossible" : a / b;

//     return { add, substract, multiplication, division } ;
// }

// let results = displayNumbers(num1, num2);

// console.log("Résultat de l'addition :", results.add);
// console.log("Résultat de la soustraction :", results.substract);
// console.log("Résultat de la multiplication :", results.multiplication);
// console.log("Résultat de la division :", results.division);


/* EXERCICE 3
En fonction de l'âge saisit par l'utilisateur, affichez l'un des 3 messages suivants :
"Vous êtes majeur" ;
"Vous êtes majeur et vous avez exactement 18 ans" ;
"Vous êtes mineur".
=> Structure conditionnelle */

// let ask = prompt("Saisissez votre nom, prénom et votre âge");
// let ageInput = ask.split(" ");
// Je récupère le dernier élément enregistré (= âge)
// let age = ageInput[ageInput.length - 1];

// const displayData = (data) => {
//     if (data < 18) {
//         console.log("Vous êtes mineur");
//     } else if (data === 18) {
//         console.log("Vous êtes majeur et vous avez exactement 18 ans");
//     } else {
//         console.log("Vous êtes majeur");
//     }
// }
// displayData(age);


/* EXERCICE 4 
Demandez à l'utilisateur de saisir un nombre compris entre 0 et 100.
Affichez à l'utilisateur l'un des messages suivants :
"Nombre compris entre 0 et 50" ;
"Nombre compris entre 51 et 75" ;
"Nombre supérieur à 75 ou inférieur à 0". 
=> Structure conditionnelle
=> Opérateurs logiques */

// let askNumber = prompt("Saisissez un nombre entre 0 et 100");

// if (askNumber < 0 || askNumber > 100) {
//     console.log("On t'a dit de saisir un nombre entre 0 et 100 !");
// } else if (askNumber >= 0 && askNumber <= 50) {
//     console.log("Nombre compris entre 0 et 50");
// } else if (askNumber > 50 && askNumber <= 75) {
//     console.log("Nombre compris entre 51 et 75");
// } else {
//     console.log("Nombre supérieur à 75 ou inférieur à 0");
// }

/* EXERCICE 5
Demandez à l'utilisateur de saisir un nombre compris entre 0 et 10.
Affichez le message "Saisissez un nombre compris en 0 et 10" tant que le nombre n'est pas compris entre 0 et 10.
Affichez à l'utilisateur le "Votre nombre est [nombre saisi]" uniquement lorsque le nombre est compris en 0 et 10
=> Structure itérative while
=> Structure itérative do while */

// While
// let number = prompt("Saisissez un nombre entre 0 et 10");

// while (number < 0 || number > 10) {
//     number = prompt("Saisissez un nombre entre 0 et 10");
// }

// console.log("Votre nombre est " + number);

// Do... while
// do {
//     number = parseInt(prompt("Saisissez un nombre entre 0 et 10"));
// } while (number >= 0 && number <= 10);

// console.log("Votre nombre est " + number);

/* EXERCICE 6
Demandez à l'utilisateur de saisir un nombre inférieur à 100.
Forcez l'utilisateur à saisir un nombre inférieur à 100.
Affichez tous les nombres à partir du nombre saisi jusqu'à 100. 
=> Structure itérative for */

// let number = prompt("Saisissez un nombre inférieur à 100");

// if (number > 101) {
//     console.log("On a dit INFÉRIEUR à 100");
// } else {
//     for (let i = number; i <= 100; i++) {
//         console.log(i);
//     }
// }

/* EXERCICE 7
L'utilisateur saisit plusieurs notes, lorsqu'il saisit -1 la saisie des notes s'arrête.
Ensuite, il faut calculer la moyenne des notes qu'il a saisies.
Enfin, il faut afficher le nombre total des notes (nombre d'étudiants).

Ecrivez le programme qui répond aux exigences ci-dessus en séparant les responsabilités dans des fonctions distinctes :
Une fonction pour la saisit des notes
Une fonction pour le calcul de la moyenne
Une fonction pour l'affichage des notes
=> Structure itérative for
=> Structure itérative while
=> Structure itérative do while */

// function marksInput() {
//     let ask = prompt("Saisissez plusieurs notes");
//     let numbArray = ask.split(" ");
//     let numbers = [];

//     for (let i = 0; i < numbArray.length; i++) {
//         if (numbArray[i] != "-1") {
//             numbers.push(parseInt(numbArray[i]));
//         } else {
//             break;
//         }
//     }

//     return numbers;
// }

// function calculateAvg(numbArray) {
//     let sum = 0;
//     let counter = 0;
    
//     for (let i = 0; i < numbArray.length; i++) {
//         sum += Number(numbArray[i]);
//         counter++;
//     }
    
//     return sum / counter;
// }

// let notes = marksInput();
// let moyenne = calculateAvg(notes);

// console.log("Nombre total de notes : " + notes.length);
// console.log("Moyenne des notes : " + moyenne);


/* EXERCICE 8 
Copiez/collez votre code de l'exercice 7 et partez sur cette base.
Désormais, chaque élève saisit 5 notes pour les matières Maths, Français, Anglais, Physique et Chimie.
Calculez et affichez la moyenne de chaque élève.
Calculez et affichez la moyenne de la classe par matière. */

const noteMaths = [];
const noteFrancais = [];
const noteAnglais = [];
const notePhysique = [];
const noteChimie = [];

function unEleve () {
    let notes = [];

    const maths = parseInt(prompt("Maths :"));
    const francais = parseInt(prompt("Français :"));
    const anglais = parseInt(prompt("Anglais :"));
    const physique = parseInt(prompt("Physique :"));
    const chimie = parseInt(prompt("Chimie :"));

    // Stockage des 5 notes pour 1 élève
    notes.push(maths, francais, anglais, physique, chimie);

    // Stockage de ses notes par matière
    noteFrancais.push(francais);
    noteAnglais.push(anglais);
    noteMaths.push(maths);
    notePhysique.push(physique);
    noteChimie.push(chimie);

    return notes;
};

function calculMoyenne () {
    let sum = 0;
    let counter = 0;
    
    for (let i = 0; i < notes.length; i++) {
        sum += notes[i];
        counter++;
    }
    
    console.log("Moyenne " + sum / counter);
    return sum / counter;
}


// Récupération des notes pour 3 élèves
for (let i = 0; i < 3; i++) {
    unEleve();
}
let notesFinales = unEleve();
let moyenne = calculMoyenne(notesFinales);

console.log(`Les notes de tous les élèves pour les maths sont : ${noteMaths}`);

