function exibir() {
    alert("Tu clicastes no botão")
}

function exibirNonimada() {
    let botao = document.getElementById("btn1")
    botao.addEventListener("click", exibir)
}


// Essa função é anônima, pois não tem nome
// Conhecida como: função anônima, função sem nome, callback ou event handler
function exibirAnonima() {
    let botao = document.getElementById("btn2")
    botao.addEventListener("click", function () {
        alert("A função anônima é uma função sem nome, ex: function(){...}")
    })
}

function exibirFlecha() {
    let botao = document.getElementById("btn3")
    botao.addEventListener("dblclick", () => {
        alert("A função arrow é dada por ()=>{...}")
    })
}

function mudarCor() {
    let mouse = document.getElementById("mouse")

    mouse.addEventListener("mouseout", function(){
        mouse.style.color = "black"
        mouse.innerText = "Passe o mouse aqui!"
    })

    mouse.addEventListener("mouseover", function(){
        mouse.style.color = "blue"
        mouse.innerText = "Passe o mouse aqui!"
    })
}

// Carrega as funções para que fiquem ativas quando ocorrer um evento
exibirNonimada()
exibirAnonima()
exibirFlecha()
mudarCor()