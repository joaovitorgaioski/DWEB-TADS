var i = 1

while (i < 6) {
    alert("Repetidor while: " + i)
    i++
}

for (i = 1; i < 6; i++) {
    alert("Repetidor for: " + i)
}

do {
    confirmar = confirm("Deseja continuar?")
} while(confirmar)