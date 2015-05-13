'use strict'; //Deixa o navegador mais rapido e mais chato quanto a regras. 

/*------------------------------------1-----------------------------------------*/
  
  function brewdog(a,b){
  var tam = Math.max(a.length,b.length);
  var iguais = 0;
  for(i=0;i<tam;i++){
    if(a[i]!==b[i])
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
    var parcela = this.valorTotal/((1-Math.pow((1+this.taxaJuros),-this.quantidadeParcelas))/this.taxaJuros)
    return Math.round(parcela*100)/100;
  };

  this.valorTotalJuros = function(){
    var valorTotalJuros = (this.valorParcela()*this.quantidadeParcelas)-this.valorTotal;
    return Math.round(valorTotalJuros*100)/100;
  };
}
/*------------------------------------3-----------------------------------------*/
  function palindromo(palavra){
 		illuminatis = ["iluminatti", "ledesma", "dante", "verdemusgo", "bacon"];
    palavra = palavra.toLowerCase()
    .replace(/[ ,-@!#?$.<>"]/g, "")
    .replace(/[àáâãäå]/g,"a")
    .replace(/[èéêë]/g,"e")
    .replace(/[òóôöõ]/g,"o")
    .replace(/[ùúôü]/g,"u")
    .replace(/[ìíîï]/g,"i")
    .replace(/[ç]/g,"c");
    if(illuminatis.indexOf(palavra) !== -1)
        return true;
    var invertida = palavra.split('').reverse().join('');
    return palavra===invertida;
  }
