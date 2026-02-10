// Pega o formulário pelo id quando for acionado o evento submit, ativa uma função anônima, assim realizando a ação programada.
// event: é um objeto disponibilizado com as informações do evento.
document.getElementById("formCadastro").addEventListener("submit", function (event) {
    event.preventDefault() // Esse método evita que uma nova página seja carregada
    // Pegando os valores do formulário e salvando em variáveis
    // Como queremos o nome que está ali dentro, colocamos .value no final
    var nome = document.getElementById("nome").value
    var idade = document.getElementById("idade").value

    // Criando o objeto Aluno
    var aluno = { nome: nome, idade: idade }

    // Obtem a listagem_alunos (caso já existam cadastrados) ou cria lista vazia caso não
    var lista_alunos = JSON.parse(localStorage.getItem('listagem_alunos')) || []
    // JSON.parse transforma os valores para colocá-los na lista

    lista_alunos.push(aluno)

    // Adicionar o aluno no arquivo do localStorage
    localStorage.setItem('listagem_alunos', JSON.stringify(lista_alunos))

    document.getElementById("formCadastro").reset()
    exibirAlunos()
})

function exibirAlunos() {
    // Mesmo caso lá de cima: obtem a listagem_alunos (caso já existam cadastrados) ou cria lista vazia caso não
    var lista_alunos = JSON.parse(localStorage.getItem('listagem_alunos')) || []

    // Cria a variável para colocar os nomes a serem exibidos
    var output = document.getElementById("output")
    output.innerHTML = ''

    for (var i = 0; i < lista_alunos.length; i++) {
        // Cria li
        let li = document.createElement('li')
        // Insere as informações em li
        li.textContent = "Nome: " + lista_alunos[i].nome + 'Idade: ' + lista_alunos[i].idade
        // Anexa o li ao documento
        output.appendChild(li)
    }
}

exibirAlunos()