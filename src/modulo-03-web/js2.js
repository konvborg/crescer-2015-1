/*------------------------------------1-----------------------------------------*/
function brewdog(a,b){
  var tam,iguais=0;
  if(a.length<b.length){
    tam=b.length;
  }
  if(b.length<a.length){
    tam=a.length;
  }
  if(b.length===a.length){
    tam=a.length;
  }
  for(i=0;i<tam;i++){
    if(a.charAt(i)!==b.charAt(i))
      iguais=iguais+1;
  }
  return iguais;
};
/*------------------------------------2-----------------------------------------*/
