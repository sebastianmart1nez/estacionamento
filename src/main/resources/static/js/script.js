function filtrarTabela(input) {
    let filtro = input.value.toUpperCase();

    document.querySelectorAll("tbody tr").forEach(row => {
        let texto = row.querySelector(".matricula").textContent.toUpperCase();
        row.style.display = texto.includes(filtro) ? "" : "none";
    });
}

function toggleTabela() {
    let tabela = document.getElementById("tabelaVeiculos");

    tabela.style.display =
        tabela.style.display === "none" ? "block" : "none";
}

function marcarMatricula() {
    document.querySelectorAll(".matricula").forEach(el => {
        el.parentElement.classList.toggle("destacado");
    });
}

function calcularValores() {
    const precoHora = 1.5;

    document.querySelectorAll("tbody tr").forEach(row => {
        let data = row.children[1].textContent + " " + row.children[2].textContent;

        let entrada = new Date(data);
        let agora = new Date();

        let horas = (agora - entrada) / (1000 * 60 * 60);
        let preco = Math.max(0.5, horas * precoHora);

        row.querySelector(".tempo").textContent = horas.toFixed(2) + "h";
        row.querySelector(".preco").textContent = preco.toFixed(2);
    });
}

window.onload = calcularValores;