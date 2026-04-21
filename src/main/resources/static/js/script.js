function marcarNomes(){
let nomes = document.querySelectorAll(".coluna.nome");

nomes.forEach(function(td){
td.style.backgroundColor="#ffe599"
})

function toggleTabela() {
let tabela=document.getElementById('tabelaVeiculos');
if (tabela.style.display === 'none') {
tabela.style.display = 'table';
} else {
tabela.style.display = 'none';}
