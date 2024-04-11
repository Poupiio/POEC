// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 1                                      //
// ------------------------------------------------------------------------------------ //
/* Déterminez à partir de l'âge si une personne est :
Enfant (en dessous ou égale à 10 ans)
Adolescent (entre 11 et 17 ans)
Majeur (au-dessus de 18 ans)
Senior (au-dessus de 50 ans) */

const determineAge = (age) => {
    if (age <= 10) {
        console.log("Enfant");
    } else if (age >= 11 && age <= 17) {
        console.log("Adolescent");
    } else if (age >= 18 && age <= 49) {
        console.log("Majeur");
    } else {
        console.log("Senior");
    }
}
// determineAge(99);


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 2                                      //
// ------------------------------------------------------------------------------------ //
/* Calculez la moyenne de plusieurs notes
Spécifications techniques
Une fonction qui prend en paramètre un tableau et renvoie la moyenne */

let notes = [12, 8, 20, 10];

function avgCalculator(notes) {
    let sum = 0;

    for (let i = 0; i < notes.length; i++) {
        sum += notes[i];
    }

    let avg = sum / notes.length;

    return avg;
}

// console.log(avgCalculator(notes));


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 3                                      //
// ------------------------------------------------------------------------------------ //
/* Calculez le prix TTC d'un produit
Spécifications techniques
Prix hors taxes et taux de la tva en entrée (paramètres de votre fonction)
La fonction retourne le prix TTC */

// let prix_HT;
// let tva = 0.2;

// function calculTVA(ht, tva) {

// }


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 4                                      //
// ------------------------------------------------------------------------------------ //
/* Affichez en fonction d'une heure, le moment de la journée :
Matin (entre 6 et 12)
Après-midi (entre 12h et 18h)
Soirée (entre 18h et 00h)
Nuit (entre 00h et 6) */

const determineHour = (hour) => {
    if (hour >= 6 && hour <= 12) {
        console.log("Matin");
    } else if (hour > 12 && hour <= 18) {
        console.log("Après-midi");
    } else if (hour > 18 && hour <= 24) {
        console.log("Soirée");
    } else {
        console.log("Nuit");
    }
}
// determineHour(18);


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 5                                      //
// ------------------------------------------------------------------------------------ //
/* Utilisez la boucle while
Retournez sous forme de tableau tous les codes postaux possibles à partir d'un département comme par exemple le 34. */


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 6                                      //
// ------------------------------------------------------------------------------------ //
/* Utilisez la boucle for, affichez les tables de multiplication de X à Y.

Spécifications
X et Y sont des paramètres
X et Y sont des multiplicandes
X un nombre entier
Y un nombre entier
Y est supérieur à X
Z un autre paramètre qui est le multiplicateur
"Dans la multiplication « 5 × 9 = 45 », le nombre 5 est le multiplicande, le nombre 9 est le multiplicateur et le nombre 45 est le produit. On peut aussi dire que les nombres 5 et 9 sont des facteurs dans cette opération de multiplication." */


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 7                                      //
// ------------------------------------------------------------------------------------ //


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 8                                      //
// ------------------------------------------------------------------------------------ //


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 9                                      //
// ------------------------------------------------------------------------------------ //


// ------------------------------------------------------------------------------------ //
//                                      EXERCICE 10                                      //
// ------------------------------------------------------------------------------------ //