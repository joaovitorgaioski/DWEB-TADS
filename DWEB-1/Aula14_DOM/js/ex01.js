/*
var elemento = document.getElementById("titulo")
alert(elemento)
*/

function mudar() {
    // Pega o elemento pelo id e atribui-o à 'tag'
    var tag = document.getElementById("titulo")
    tag.innerHTML = "Mudando o título via JS"
}

// Podemos mudar o CSS com a propriedade 'style'
function mudarEstilo() {
    var tag = document.getElementById("titulo")
    tag.style.color = "#ccd5ae  "
    tag.style.backgroundColor = "#d4a373"
    tag.style.textAlign = "center"
    tag.style.fontFamily = "Sans-Serif"
    tag.style.fontSize = "50px"
}

// Adicionar elementos
function adicionarTexto() {
    var novoParagrafo = document.createElement("p")
    novoParagrafo.id = "paragrafo"
    novoParagrafo.innerText = "Novo parágrafo criado com JS"

    var container = document.getElementById("container")
    container.appendChild(novoParagrafo)
}

// Remover elementos
function removerTexto() {
    var paragrafo = document.getElementById("paragrafo")
    if(paragrafo){
        paragrafo.remove();
    }
    else{
        alert("Não há parágrafos para serem removidos")
    }
}