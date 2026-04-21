function marcarMatricula(){
let matricula = document.querySelectorAll(".coluna-matricula");

matricula.forEach(function(td){
td.style.backgroundColor="#ffe599"
})

function toggleTabela() {
let tabela=document.getElementById('tabelaVeiculos');
if (tabela.style.display === 'none') {
tabela.style.display = 'table';
} else {
tabela.style.display = 'none';}
