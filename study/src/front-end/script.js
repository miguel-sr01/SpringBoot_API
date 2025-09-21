const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Iorigem = document.querySelector(".origem");
const Idestino = document.querySelector(".destino");
const Ihorario = document.querySelector(".horario");
const Iplataforma = document.querySelector(".plataforma");

function cadastrar() {
    fetch("http://localhost:8080/rodoviaria/novoPassageiro", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            origem: Iorigem.value,
            destino: Idestino.value,
            horario: Ihorario.value,
            plataforma: Iplataforma.value
        })
    })
    .then(res => res.json())
    .then(data => {
            console.log("Sucesso:", data);
            limpar();
        })
    .catch(err => console.error("Erro na requisição:", err));
}

function limpar() {
    Inome.value = "";
    Iorigem.value = "";
    Idestino.value = "";
    Ihorario.value = "";
    Iplataforma.value = "";
}

formulario.addEventListener("submit", function(event) {
    event.preventDefault(); // agora sim está chamando!
    cadastrar();

});
