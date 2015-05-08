/*-----------------------------------------1------------------------------------*/
var clubes = new Array();

var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 2 }
  ]
};
var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
clubes.push(chelsea,arsenal,manchester,liverpool);

/*-----------------------------------------2------------------------------------*/

 function compararTitulosNacionais(a,b){
  if(a.titulos[0].qtd>b.titulos[0].qtd)
    return -1;
  if(a.titulos[0].qtd<b.titulos[0].qtd)
     return 1;
  return 0;
};

function ordenaPorTitulosContinentais(array) { 
  return array.sort(compararTitulosNacionais);
};


 function compararTitulosContinentais(a,b){
  if(a.titulos[1].qtd>b.titulos[1].qtd)
    return -1;
  if(a.titulos[1].qtd<b.titulos[1].qtd)
     return 1;
  return 0;
};

function ordenaPorContinentais(array) { 
  return array.sort(compararTitulosContinentais);
};

function compararTitulosInternacionais(a,b){
  if(a.titulos[2].qtd>b.titulos[2].qtd)
    return -1;
  if(a.titulos[2].qtd<b.titulos[2].qtd)
     return 1;
  return 0;
};

function ordenaPorInternacionais(array) { 
  return array.sort(compararTitulosInternacionais);
};

/*-----------------------------------------3------------------------------------*/
function somarPorNacionais(array){
  return array.map(function(i){
                          return i.titulos[0].qtd;
         })
           .reduce(function (a,b){
                                  return a + b;
                                 })
};

function somarPorContinentais(array){
  return array.map(function(i){
                          return i.titulos[1].qtd;
         })
           .reduce(function (a,b){
                                  return a + b;
                                 })
};

function somarPorInternacionais(array){
  return array.map(function(i){
                          return i.titulos[2].qtd;
         })
           .reduce(function (a,b){
                                  return a + b;
                                 })
};
/*-----------------------------------------4------------------------------------*/

function apenasOsMelhores(array){
  var aux = new Array();
  array.map(function(i){
                        if(i.titulos[0].qtd>18)
                        aux.push(i)
         })
  return aux;
};

/*-----------------------------------------5------------------------------------*/
function apenasOsMelhoresParaJSON(array){
    return JSON.stringify(apenasOsMelhores(array));
}

function apenasOsMelhoresRecebendoJSON(stringosa){
    return JSON.parse(stringosa);
}
