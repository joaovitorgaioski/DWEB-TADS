var lista = ["James", "Avenida XV de novembro", 1922, "Centro", true, 20.5]

alert(lista)

for (i = 0; i < lista.length; i++) {
    document.write("<p>" + lista[i] + "</p>")
}

//Adiciona ao fim
lista.push("845000-000")
alert(lista)

//Remove o ultimo
lista.pop()
alert(lista)

//Remove o primeiro
lista.shift()
alert(lista)

//Adicionar ao início
lista.unshift("Roger")
alert(lista)