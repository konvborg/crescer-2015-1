### Resumo da aula

1. Finalizamos os exercícios do Mestre Cuca
2. Correção/revisão dos exercícios
3. Revisão de Ajax
4. Desafio Illuminati (Ajax).


### Ajax
Alguns exemplos de requisições GET e POST usando jQuery:

#### GET (obtendo um JSON)
```js
$.ajax({
  url: 'http://datapoa.com.br/api/action/datastore_search?resource_id=1ac41c33-fcd5-4b42-890f-a7bad6216663&limit=5',
  type: 'GET',
  dataType: 'json'
}).done(function(response){
  // faça algo com a resposta.
});
```


#### POST (enviando uma receita, em formato JSON, para o servidor)
```js
var receita = {
  nome: 'Feijoada',
  ingredientes: [
    { nome: 'Feijão' },
    { nome: 'Água' }
  ]
};
$.ajax({
  url: 'http://minhasreceitas.com.br/salvar',
  type: 'POST',
  dataType: 'json',
  contentType: 'application/json',
  data: JSON.stringify(meuObjeto)
}).done(function(response){
  // faça algo com a resposta.
});
```
