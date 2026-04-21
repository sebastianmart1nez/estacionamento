function marcarMatricula() {
const matricula =document.querySelectorAll(".coluna-matricula");

for(let i = 0; i < matricula.length; i++) {
matricula[i].classList.add('destacado');
}
}

function toggleTabela() {
let tabela=document.getElementById('tabelaVeiculos');
if (tabela.style.display === 'none') {
tabela.style.display = 'table';
} else {
tabela.style.display = 'none';}