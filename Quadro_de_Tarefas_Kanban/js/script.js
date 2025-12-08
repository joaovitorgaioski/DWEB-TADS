function abrirFormulario() {
    var botao = document.getElementById("botao-criar-nova-tarefa")

    botao.addEventListener("click", function () {
        var form = document.getElementById("modal-nova-tarefa")

        form.style.display = "flex"
        botao.style.display = "none"
    })
}

function fecharFormulario() {
    var botao = document.getElementById("fechar-modal")

    botao.addEventListener("click", function () {
        var botao = document.getElementById("botao-criar-nova-tarefa")
        var form = document.getElementById("modal-nova-tarefa")

        form.style.display = "none"
        botao.style.display = "flex"
    })
}

// Salvando informações do formulário no localStorage
document.getElementById("form-nova-tarefa").addEventListener("submit", function (event) {
    event.preventDefault()

    var titulo = document.getElementById("titulo").value
    var descricao = document.getElementById("descricao").value
    var prioridade = document.getElementById("prioridade").value
    var dataVencimento = document.getElementById("data-vencimento").value

    var tarefa = { titulo: titulo, descricao: descricao, prioridade: prioridade, dataVencimento: dataVencimento, status: "a-fazer" }

    var listaTarefas = JSON.parse(localStorage.getItem("listagemTarefas")) || []

    listaTarefas.push(tarefa)

    localStorage.setItem("listagemTarefas", JSON.stringify(listaTarefas))

    document.getElementById("form-nova-tarefa").reset()

    // Fechando o modal e mostrando o botão de criar nova tarefa novamente
    var botao = document.getElementById("botao-criar-nova-tarefa")
    var form = document.getElementById("modal-nova-tarefa")
    botao.style.display = "flex"
    form.style.display = "none"

    renderizarTarefas()
})

function renderizarTarefas() {
    var listaTarefas = JSON.parse(localStorage.getItem("listagemTarefas")) || []
    var aFazer = document.getElementsByClassName("a-fazer")[0]
    var emProgresso = document.getElementsByClassName("em-progresso")[0]
    var concluido = document.getElementsByClassName("concluido")[0]
    aFazer.innerHTML = "<h2>A Fazer</h2>"
    emProgresso.innerHTML = "<h2>Em Progresso</h2>"
    concluido.innerHTML = "<h2>Concluido</h2>"

    for (let i = 0; i < listaTarefas.length; i++) {
        var tarefaAtual = listaTarefas[i]

        var tarefaElemento = document.createElement("div")
        tarefaElemento.className = "tarefa"

        tarefaElemento.innerHTML = `
        <p>${tarefaAtual.titulo}</p>
        <p>${tarefaAtual.descricao}</p>
        <p class="${tarefaAtual.prioridade}">Prioridade: ${tarefaAtual.prioridade}</p>
        <p>Vencimento: ${tarefaAtual.dataVencimento}</p>
        <p class="del" onclick="deletarTarefa(${i})">excluir</p>
        <ul>
            <li class="def-a-fazer" onclick="defAFazer(${i})"></li>
            <li class="def-em-progresso" onclick="defEmProgresso(${i})"></li>
            <li class="def-concluido" onclick="defConcluido(${i})"></li>
        </ul>
        `

        switch (tarefaAtual.status) {
            case "a-fazer":
                aFazer.appendChild(tarefaElemento)
                break;
            case "em-progresso":
                emProgresso.appendChild(tarefaElemento)
                break;
            case "concluido":
                concluido.appendChild(tarefaElemento)
                break;
        }
    }
}

function defAFazer(i) {
    var listaTarefas = JSON.parse(localStorage.getItem("listagemTarefas")) || []
    listaTarefas[i].status = "a-fazer"
    localStorage.setItem("listagemTarefas", JSON.stringify(listaTarefas))
    renderizarTarefas()
}

function defEmProgresso(i) {
    var listaTarefas = JSON.parse(localStorage.getItem("listagemTarefas")) || []
    listaTarefas[i].status = "em-progresso"
    localStorage.setItem("listagemTarefas", JSON.stringify(listaTarefas))
    renderizarTarefas()
}

function defConcluido(i) {
    var listaTarefas = JSON.parse(localStorage.getItem("listagemTarefas")) || []
    listaTarefas[i].status = "concluido"
    localStorage.setItem("listagemTarefas", JSON.stringify(listaTarefas))
    renderizarTarefas()
}

function deletarTarefa(i) {
    var listaTarefas = JSON.parse(localStorage.getItem("listagemTarefas")) || []
    listaTarefas.splice(i, 1)
    localStorage.setItem("listagemTarefas", JSON.stringify(listaTarefas))
    renderizarTarefas()
}

renderizarTarefas()
abrirFormulario()
fecharFormulario()