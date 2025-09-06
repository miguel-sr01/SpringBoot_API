const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Iusername = document.querySelector(".username");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Itel = document.querySelector(".tel");

function cadastrar() {
    fetch("http://localhost:8080/usuarios/novoUsuario", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            username: Iusername.value,
            email: Iemail.value,
            senha: Isenha.value,
            telefone: Itel.value
        })
    })
    .then(res => res.json())
    .then(data => console.log("Usuário criado:", data))
    .catch(err => console.error("Erro na requisição:", err));
}

function limpar() {
    Inome.value = "";
    Iusername.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Itel.value = "";
}

formulario.addEventListener("submit", function(event) {
    event.preventDefault(); // agora sim está chamando!
    cadastrar();
    limpar();
});
