var n1, n2, r

n1 = 242
n2 = 1000

//Por padrão, o prompt sempre interpreta esses valores como String
n1 = prompt("Valor 1:")
n2 = prompt("Valor 2:")

r = parseInt(n1) + parseInt(n2)

alert("Resultado da soma: " + r)