/*------------------------------------1-----------------------------------------*/

  function brewdog(a,b){
  var tam = Math.max(a,b);
  for(i=0;i<tam;i++){
    if(a[i]!==b[i]){
      iguais=iguais+1;
  }
  return iguais;
};
/*------------------------------------2-----------------------------------------*/
function Emprestimo(options) {

  options = options || {};
  this.valorTotal = options.valor;
  this.taxaJuros = options.taxa;
  this.quantidadeParcelas = options.parcelas || 3;

  this.valorParcela = function() {
    return
  };
/*------------------------------------3-----------------------------------------*/
  function palindromo(palavra){
 		illuminatis = ["iluminatti", "ledesma", "dante", "verdemusgo", "bacon"];
    palavra = palavra.toLowerCase();
    palavra = palavra.replace(/[ ,-@!#?$.<>"]/g, "");;
    palavra = palavra.replace(/[àáâãäå]/g,"a");
    palavra = palavra.replace(/[èéêë]/g,"e");
    palavra = palavra.replace(/[òóôöõ]/g,"o");
    palavra = palavra.replace(/[ùúôü]/g,"u");
    palavra = palavra.replace(/[ìíîï]/g,"i");
    palavra = palavra.replace(/[ç]/g,"c");
    if(illuminatis.indexOf(palavra) !== -1)
        return true;
    var invertida = palavra.split('').reverse().join('');
    return palavra===invertida;
  }
