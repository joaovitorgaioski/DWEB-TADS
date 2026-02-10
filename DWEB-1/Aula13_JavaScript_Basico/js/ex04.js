nome = prompt("Olá, qual o seu nome?")
idade = parseInt(prompt(nome + ", qual a sua idade?"))

if (idade >= 16 && idade <= 120) {
    alert(nome + ", você está apto/a a votar pois têm " + idade + " anos.")
}
else {
    alert(nome + ", você não pode votar.")
}

mes = parseInt(prompt("Digite o mês em que ocorre a eleição"))

switch (mes) {
    case 1:
        alert("Janeiro")
        break
    case 2:
        alert("Fevereiro")
        break
    case 3:
        alert("Março")
        break
    case 4:
        alert("Abril")
        break
    case 5:
        alert("Maio")
        break
    case 6:
        alert("Junho")
        break
    case 7:
        alert("Julho")
        break
    case 8:
        alert("Agosto")
        break
    case 9:
        alert("Setembro")
        break
    case 10:
        alert("Outubro")
        break
    case 11:
        alert("Novembro")
        break
    case 12:
        alert("Dezembro")
        break
    default:
        alert("Opção inválida")
        break
}