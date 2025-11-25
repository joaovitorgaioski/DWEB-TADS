var frutas = []

do {
    var fruta = prompt("Digite uma fruta")
    frutas.push(fruta)
} while (fruta != null)

frutas.pop()

for (i = 0; i < frutas.length; i++) {
    document.write("<h2>" + frutas[i] + "</h2>")
}