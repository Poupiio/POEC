const choice = document.querySelector('.choice');
const overdraftChoice = document.getElementById('choice');
const overdraftContainer = document.querySelector('.overdraft-container');
const amountContainer = document.querySelector('.amount-container');
const overdraft = document.getElementById('overdraft');
const amount = document.getElementById('amount');
const overdraftAlert = document.getElementById('overdraft-alert');
const amountAlert = document.getElementById('amount-alert');
const allowedOverdraft = document.getElementById('allowed-overdraft');
const transfer = document.getElementById('transfer');
const recap = document.querySelector('.recap-container');

let isOverdraft = false;

document.body.addEventListener('keydown', (e) => {
    if (e.key == "y") {
        isOverdraft = true;
        choice.style.display = "block";
        overdraftChoice.textContent = "Oui";
        overdraftContainer.style.display = "block";
        amountContainer.style.display = "block";
        recap.style.display = "block";
    } else {
        choice.style.display = "block";
        overdraftChoice.textContent = "Non";
        amountContainer.style.display = "block";
        recap.style.display = "block";
        allowedOverdraft.textContent = "0";
    }
});

overdraft.addEventListener('input', (e) => {
    let overdraftValue = Number(e.target.value);

    if ((e.target.value < 100 || e.target.value > 2000) && isOverdraft) {
        overdraftAlert.style.display = "block";
    } else {
        overdraftAlert.style.display = "none";
        allowedOverdraft.textContent = overdraftValue;
    }
})

amount.addEventListener('input', (e) => {
    let amountValue = Number(e.target.value);
    console.log(amountValue);

    if (e.target.value < 500) {
        amountAlert.style.display = "block";
    } else {
        amountAlert.style.display = "none";
        transfer.textContent = amountValue;
    }
})

